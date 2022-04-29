package Admin;

import Cars.Taxi;
import Cars.Type;
import Main.Car;

import java.util.ArrayList;
import java.util.Collections;

public class Admin implements IAdmin
{
    public ArrayList<Car> cars;
    public Admin() throws Exception {
        cars = new ArrayList<Car>();
        cars.add(new Taxi(1000, 20.9, 370, Type.BUSINESS));
        cars.add(new Taxi(200, 30.4, 200, Type.STANDART));
        cars.add(new Taxi(500, 24.7, 260, Type.COMFORT));
    }



    @Override
    public int CountPrice(ArrayList<Car> cars) {
        int sum = 0;
        for (Car car: cars) {
            sum+=car.getPrice();
        }
        return sum;
    }

    @Override
    public void SortByGas(ArrayList<Car> cars) {
        Collections.sort(cars, new SortByGas());
    }

    @Override
    public void SearchCar(ArrayList<Car> cars, int speed1, int speed2) {
        for (Car car:cars
        ) {
            if (car.getSpeed() > speed1 && car.getSpeed() < speed2)
            {
                System.out.println(car);
            }
        }
    }
}
