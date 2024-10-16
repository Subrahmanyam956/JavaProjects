import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dispatcher {
    PriorityQueue<CarRequest> requests  = new PriorityQueue<>();
    List<Car> cars = new ArrayList<>();

    public void runCart() {
        for(Car car : cars) {
            if(car.getState() == 0) {
                // get the next car movement target
                // moveCar()
            }
        }
    }
}
