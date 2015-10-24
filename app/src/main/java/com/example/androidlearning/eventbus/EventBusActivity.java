package com.example.androidlearning.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import com.example.androidlearning.R;

/**
 * Created by FCWL on 9/29/2015.
 */
public class EventBusActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);

        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String age = getIntent().getStringExtra("age");

        ((EditText) findViewById(R.id.firstName)).setText(firstName);
        ((EditText) findViewById(R.id.lastName)).setText(lastName);
        ((EditText) findViewById(R.id.age)).setText(age);
    }

//    public void onEvent(UserDataEvent userDataEvent) {
//        System.out.println("--------- Hey onEvent is called ------------");
//        EditText firstName = (EditText) findViewById(R.id.firstName);
//        EditText lastName = (EditText) findViewById(R.id.lastName);
//        EditText age = (EditText) findViewById(R.id.age);
//
//        firstName.setText(userDataEvent.getFirstName());
//        lastName.setText(userDataEvent.getLastName());
//        age.setText(userDataEvent.getAge());
//    }
//
//    @Override
//    public void onStart() {
//        EventBus.getDefault().register(this);
//        super.onStart();
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }

}
