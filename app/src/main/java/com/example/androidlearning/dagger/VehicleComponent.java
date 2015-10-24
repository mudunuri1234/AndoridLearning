package com.example.androidlearning.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fcwl on 5/29/2015.
 */
@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();

}

