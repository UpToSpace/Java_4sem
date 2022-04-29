package Admin;

import Main.Car;

import java.util.ArrayList;

public interface IAdmin {
    int CountPrice(ArrayList<Car> cars);
    void SortByGas(ArrayList<Car> cars);
    void SearchCar(ArrayList<Car> cars, int speed1, int speed2);
}