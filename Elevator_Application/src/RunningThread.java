public class RunningThread {

    private static volatile boolean running = true; // To control the execution of the thread

    public static void main(String[] args) {

        final Object lock = new Object();
        final boolean[] isPaused = {false}; // Flag to pause Thread 2


        Car car = new Car(0, 0, true);
        Dispatcher dispatcher = new Dispatcher(car);

        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("Thread 1 is running");
                try {
                    CheckForAnyNewRequests check = new CheckForAnyNewRequests();
                    check.checkForAnyNewRequests(dispatcher);
                    Thread.sleep(3000); // Sleep for 5000 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Using another lambda expression for the second task
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (isPaused[0]) {
                        try {
                            System.out.println("Thread 2 is paused...");
                            lock.wait(); // Thread waits (pause) until notified
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Thread 2 is running");
                try {
                    Thread.sleep(3000); // Main thread sleeps for 5 seconds
                    dispatcher.moveCar(car);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        // Controller Thread: Pauses and resumes Thread 2 periodically
        Thread controller = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Wait 5 seconds
                    synchronized (lock) {
                        isPaused[0] = !isPaused[0]; // Toggle pause state
                        if (!isPaused[0]) {
                            lock.notify(); // Resume Thread 2
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start all threads
        thread1.start();
        thread2.start();
        controller.start();

    }
}
