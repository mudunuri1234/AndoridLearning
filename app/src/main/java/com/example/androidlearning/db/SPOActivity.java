package com.example.androidlearning.db;

/**
 * Created by fcwl on 6/30/2015.
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidlearning.R;

/**
 * Created by fcwl on 6/30/2015.
 */
public class SPOActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ SPOActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spo);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", "Srinivas");
        editor.putString("password", "admin123");
        editor.putString("logged", "YES, I did");
        editor.commit();


        Button getDataButton = (Button) findViewById(R.id.get_data_button);
        getDataButton.setEnabled(true);
        getDataButton.setOnClickListener(getDataButtonListener);
    }


    private View.OnClickListener getDataButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            System.out.println("--------- getDataButtonListener called ------------");
            callReadDataActivity();
        }
    };

    public void callReadDataActivity() {
        getSPOData();
    }

    private void getSPOData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userName = preferences.getString("username", "NONE");
        String password = preferences.getString("password", "NONE");
        String logged = preferences.getString("logged", "NONE");

        Log.i("------ userName ------", userName);
        Log.i("------ password ------", password);
        Log.i("------ logged ------", logged);

        EditText userNameEdit = (EditText) findViewById(R.id.username);
        userNameEdit.setText(userName);

        EditText passwordEdit = (EditText) findViewById(R.id.password);
        passwordEdit.setText(password);

        EditText cachedEdit = (EditText) findViewById(R.id.cached);
        cachedEdit.setText(logged);
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

