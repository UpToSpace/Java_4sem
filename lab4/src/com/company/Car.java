package com.company;

import java.io.Serializable;

public abstract class Car implements Serializable {
    int price;
    double gas;
    int speed;
    public Car(){}
    public Car(int price, double gas, int speed) throws Exception {
        if (price <= 0 || gas <= 0 || speed <= 0)
        {
            throw new Exception("Incorrect value");
        }
        this.price = price;
        this.gas = gas;
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", gas=" + gas +
                ", speed=" + speed +
                '}';
    }
}
