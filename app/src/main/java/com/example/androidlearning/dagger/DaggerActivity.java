package com.example.androidlearning.dagger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidlearning.R;

/**
 * Created by fcwl on 5/29/2015.
 */
public class DaggerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();

        Vehicle vehicle = component.provideVehicle();
        vehicle.increaseSpeed(400);
        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();

        EditText editText = (EditText) findViewById(R.id.dagger_speed);
        editText.setText(vehicle.getSpeed()+"");
        editText.setBackgroundColor(125);
    }

    @Override
    // Called when the activity becomes visible to the user
    protected void onStart() {
        super.onStart();
    }

    @Override
    // Called when the activity is no longer visible to the user
    protected void onStop() {
        super.onStop();
    }

}
