package com.example.androidlearning.eventbus;

import android.app.Activity;
import android.os.Bundle;

import com.example.androidlearning.R;

/**
 * Created by FCWL on 10/19/2015.
 */
public class ActivityFargment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
}
