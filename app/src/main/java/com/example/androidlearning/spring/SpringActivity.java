package com.example.androidlearning.spring;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.androidlearning.R;

/**
 * Created by fcwl on 6/9/2015.
 */
public class SpringActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ SpringActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);

        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);

        // Calling the REST service Asynchronously
        RestServiceClient restClient = new RestServiceClient(firstName, lastName);
        restClient.execute();
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
