package com.company.cars;

import com.company.Car;

import java.io.Serializable;

public class Taxi extends Car implements Serializable {
    Type type;

    public void setType(String type) {
        switch (type)
        {
            case "BUSINESS":
                this.type = Type.BUSINESS;
                break;
            case "COMFORT":
                this.type = Type.COMFORT;
                break;
            case "STANDART":
                this.type = Type.STANDART;
                break;
            default:
                this.type = Type.STANDART;
                break;
        }
    }

    public Taxi(){
        super();
    }

    public Taxi(int price, double gas, int speed, Type type) throws Exception {
        super(price, gas, speed);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "type=" + type;
    }
}
