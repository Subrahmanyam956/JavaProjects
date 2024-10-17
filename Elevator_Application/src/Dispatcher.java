import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dispatcher {
    List<CarRequest> requests  = new ArrayList<>();
    Car car;
//    PriorityQueue<CarRequest> stoppingRequests  = new PriorityQueue<>();
    List<CarRequest> stoppingRequests = new ArrayList<>();
    int maxFloors = 15;

    public Dispatcher(Car car) {
        this.car = car;
    }

    public void runCar() {
        System.out.println("car is moving and at floor: " + car.getCurFloor());
    }

    public void settingUpCarRequests() {
        sortCarRequests();
        for(CarRequest request: requests) {
            if(car.isUpDirection()) {
                int requestStartFloor = request.getCurFloor();
                int requestTargetFloor = request.getTargetFloor();
                boolean isUpDirection = request.isUpDirection();

                if((requestStartFloor > car.getCurFloor()) && (isUpDirection)) {
                    stoppingRequests.add(request);
                }
            } else {
                int requestStartFloor = request.getCurFloor();
                int requestTargetFloor = request.getTargetFloor();
                boolean isUpDirection = request.isUpDirection();

                if((requestStartFloor < car.getCurFloor()) && (!isUpDirection)) {
                    stoppingRequests.add(request);
                }
            }
        }
    }

    void sortCarRequests() {
        requests.sort(Comparator.comparingInt(CarRequest::getCurFloor));
    }

    public void moveCar(Car car) {
        while(true) {
            car.setState(1);
            int carCurFloor = car.getCurFloor();
            System.out.println("Car is moving and is at floor : " +carCurFloor);
            if(carCurFloor == 0) {
                car.setUpDirection(true);
            } else if (carCurFloor == maxFloors) {
                car.setUpDirection(false);
            }
            if(car.isUpDirection() && (carCurFloor < maxFloors)) {
                checkForStops();
                car.setCurFloor(carCurFloor + 1);
            } else {
                car.setCurFloor(carCurFloor - 1);
            }
        }
    }

    public void checkForStops() {
        int carCurFloor = car.getCurFloor();
        for(CarRequest carRequest : stoppingRequests) {
            if(carRequest.getCurFloor() == carCurFloor) {
                System.out.println("car is stopping at floor: "+ carCurFloor);
            }
        }
    }
}
