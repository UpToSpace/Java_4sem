package com.company;
import com.company.admin.Admin;
import com.company.admin.SortByGas;
import com.company.cars.Taxi;
import com.company.cars.Type;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;

public class Main {
    static Logger Log;
    static {
        Log = Logger.getLogger(Main.class.getName());
    }
    public static void main(String[] args) throws Exception {
        Log.log(Level.WARNING, "Creating arraylist");

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Taxi(1000, 20.9, 370, Type.BUSINESS));
        cars.add(new Taxi(200, 30.4, 200, Type.STANDART));
        cars.add(new Taxi(500, 24.7, 260, Type.COMFORT));
        for (Car car:cars
             ) {
            System.out.println(car);
        }

        Admin admin = new Admin();
        System.out.println(admin.CountPrice(cars));
        admin.SortByGas(cars);
        admin.SearchCar(cars, 220, 300);
        Log.log(Level.INFO, "Sorting arraylist");
        for (Car car:cars
        ) {
            System.out.println(car);
        }
    }
}
