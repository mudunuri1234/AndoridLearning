package com.example.androidlearning.dagger;

import javax.inject.Inject;

/**
 * Created by fcwl on 5/29/2015.
 */
public class Vehicle {

    private Motor motor;

    @Inject
    public Vehicle(Motor motor){
        this.motor = motor;
    }

    public void increaseSpeed(int value){
        motor.increaseSpeed(value);
    }

    public int getSpeed(){
        return motor.getRpm();
    }

}

