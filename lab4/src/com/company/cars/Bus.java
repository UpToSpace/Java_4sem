package com.company.cars;

import com.company.Car;

public class Bus extends Car {
    int passangers;
    public Bus(){
        super();
    }
    public Bus(int price, double gas, int speed, int passangers) throws Exception {
        super(price, gas, speed);
        this.passangers = passangers;
    }

    public void setPassangers(int passangers) {
        this.passangers = passangers;
    }

    @Override
    public String toString() {
        return super.toString() +
                "passangers=" + passangers;
    }
}
