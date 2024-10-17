import java.util.Scanner;

public class CheckForAnyNewRequests {


    void checkForAnyNewRequests(Dispatcher dispatcher) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Y in case of any new carRequest.. if no request enter N");
            String input = sc.nextLine();
            if(input.equals("Y")) {
                System.out.println("Enter curFloor: ");
                int curFloor = sc.nextInt();
                System.out.println("Enter targetFloor: ");
                int targetFloor = sc.nextInt();
                boolean isUpDirection = (curFloor < targetFloor);
                CarRequest newCarRequest = new CarRequest(curFloor, targetFloor, isUpDirection);
                dispatcher.requests.add(newCarRequest);
                dispatcher.settingUpCarRequests();
            } else {
                break;
            }
        }
    }
}
