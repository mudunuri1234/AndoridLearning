package com.example.androidlearning.dagger;

/**
 * Created by fcwl on 5/29/2015.
 */
public class Motor {

    private int rpm;

    public int getRpm(){
        return rpm;
    }

    public void increaseSpeed(int value){
        rpm = rpm + value;
    }

}
