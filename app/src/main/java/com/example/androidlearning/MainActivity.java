package com.example.androidlearning;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidlearning.dagger.DaggerActivity;
import com.example.androidlearning.db.FileIOActivity;
import com.example.androidlearning.db.RealmActivity;
import com.example.androidlearning.db.SPOActivity;
import com.example.androidlearning.db.SQLiteActivity;
import com.example.androidlearning.eventbus.ActivityFargment;
import com.example.androidlearning.eventbus.EventBusActivity;
import com.example.androidlearning.eventbus.UserDataEvent;
import com.example.androidlearning.lbs.MapsActivity;
import com.example.androidlearning.md.CardsActivity;
import com.example.androidlearning.md.RotateAnimationActivity;
import com.example.androidlearning.md.ToolbarActivity;
import com.example.androidlearning.md.TranslateAnimationActivity;
import com.example.androidlearning.picasso.PicassoActivity;
import com.example.androidlearning.spring.SpringActivity;

import de.greenrobot.event.EventBus;

//AIzaSyC74kyKm-K8vfjIgqBdlCGHvwLfvpWNHDw
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button sqliteButton = (Button) findViewById(R.id.sqlite_button);
//        sqliteButton.setEnabled(true);
//        sqliteButton.setOnClickListener(saveButtonListener);
//
//        Button realmButton = (Button) findViewById(R.id.realm_button);
//        realmButton.setEnabled(true);
//        realmButton.setOnClickListener(realmButtonListener);
//
//        Button spoButton = (Button) findViewById(R.id.spo_button);
//        spoButton.setEnabled(true);
//        spoButton.setOnClickListener(spoButtonListener);
//
//        Button fileIOButton = (Button) findViewById(R.id.flieio_button);
//        fileIOButton.setEnabled(true);
//        fileIOButton.setOnClickListener(fileIOButtonListener);

//        Button springButton = (Button) findViewById(R.id.spring_button);
//        springButton.setEnabled(true);
//        springButton.setOnClickListener(springButtonListener);


//        Button eventBusButton = (Button) findViewById(R.id.eventbus_button);
//        eventBusButton.setEnabled(true);
//        eventBusButton.setOnClickListener(eventBusButtonListener);

//        Button daggerButton = (Button) findViewById(R.id.di_button);
//        daggerButton.setEnabled(true);
//        daggerButton.setOnClickListener(daggerButtonListener);


//        Button picassoButton = (Button) findViewById(R.id.picasso_button);
//        picassoButton.setEnabled(true);
//        picassoButton.setOnClickListener(picassoButtonListener);


//        Button toolbarButton = (Button) findViewById(R.id.toolbar_button);
//        toolbarButton.setEnabled(true);
//        toolbarButton.setOnClickListener(toolbarButtonListener);

//        Button cardsButton = (Button) findViewById(R.id.cards_button);
//        cardsButton.setEnabled(true);
//        cardsButton.setOnClickListener(cardsButtonListener);

//        Button drawerButton = (Button) findViewById(R.id.drawer_button);
//        drawerButton.setEnabled(true);
//        drawerButton.setOnClickListener(drawerButtonListener);

//        Button mapsButton = (Button) findViewById(R.id.maps_button);
//        mapsButton.setEnabled(true);
//        mapsButton.setOnClickListener(mapsButtonListener);

    }

//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener saveButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            showSQLiteDataScreen();
//        }
//    };
//
//    private void showSQLiteDataScreen() {
//        Intent intent = new Intent(this, SQLiteActivity.class);
//        startActivity(intent);
//    }
//
//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener realmButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            showRealmDataScreen();
//        }
//    };
//
//    private void showRealmDataScreen() {
//        Intent intent = new Intent(this, RealmActivity.class);
//        startActivity(intent);
//    }
//
//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener spoButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            showSPODataScreen();
//        }
//    };
//
//    private void showSPODataScreen() {
//        Intent intent = new Intent(this, SPOActivity.class);
//        startActivity(intent);
//    }
//
//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener fileIOButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            createFile();
//        }
//    };
//
//    private void createFile() {
//        Intent intent = new Intent(this, FileIOActivity.class);
//        startActivity(intent);
//    }
//
//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener springButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            callSpringRestService();
//        }
//    };
//
//    private void callSpringRestService() {
//        Intent intent = new Intent(this, SpringActivity.class);
//        startActivity(intent);
//    }

//    private View.OnClickListener eventBusButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            EditText firstName = (EditText) findViewById(R.id.firstName1);
//            EditText lastName = (EditText) findViewById(R.id.lastName1);
//            EditText age = (EditText) findViewById(R.id.age1);
//
//            UserDataEvent dataEvent = new UserDataEvent();
//            dataEvent.setFirstName(firstName.getText().toString());
//            dataEvent.setLastName(lastName.getText().toString());
//            dataEvent.setAge(age.getText().toString());
//
//            EventBus.getDefault().post(dataEvent);
//        }
//    };

//    // Called when the EventBus's EventBus.getDefault().post(new UserDataEvent()) is invoked.
//    public void onEvent(UserDataEvent userDataEvent) {
//        System.out.println("--------- Hey onEvent is called ------------");
//        Intent intent = new Intent(this, EventBusActivity.class);
//        intent.putExtra("firstName", userDataEvent.getFirstName());
//        intent.putExtra("lastName", userDataEvent.getLastName());
//        intent.putExtra("age", userDataEvent.getAge());
//
//        startActivity(intent);
//    }



//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener daggerButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            callDaggerActivity();
//        }
//    };
//
//    private void callDaggerActivity() {
//        Intent intent = new Intent(this, DaggerActivity.class);
//        startActivity(intent);
//    }

//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener picassoButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            callPicassoActivity();
//        }
//    };
//
//    private void callPicassoActivity() {
//        Intent intent = new Intent(this, PicassoActivity.class);
//        startActivity(intent);
//    }

//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener toolbarButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            callToolbarActivity();
//        }
//    };
//
//    private void callToolbarActivity() {
//        Intent intent = new Intent(this, ToolbarActivity.class);
//        startActivity(intent);
//    }

//    //create an anonymous class to act as a button click listener
//    private View.OnClickListener cardsButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            callCardsActivity();
//        }
//    };
//
//    private void callCardsActivity() {
//        Intent intent = new Intent(this, CardsActivity.class);
//        startActivity(intent);
//    }


    //create an anonymous class to act as a button click listener
    private View.OnClickListener mapsButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            callMapsActivity();
        }
    };

    private void callMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void ShowLinearAnimation(View view) {
        Intent intent = new Intent(this, TranslateAnimationActivity.class);
        startActivity(intent);
    }

    public void showRotateAnimation(View view) {
        Intent intent = new Intent(this, RotateAnimationActivity.class);
        startActivity(intent);
    }

    public void CallFragment(View view) {
//        Intent intent = new Intent(this, ActivityFargment.class);
//        startActivity(intent);

        showAlertDialog(view);
    }


    public void showAlertDialog(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Make a Decision");
        alertDialogBuilder.setMessage("Did you make the Decision ?");

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogIf, int id) {
                // Yes button is clicked
                Toast.makeText(MainActivity.this, "YES is clicked", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // NO button is clicked
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



        // Create an anonymous class to act as a button click listener
//    private View.OnClickListener drawerButtonListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            callDrawerActivity();
//        }
//    };

//    private void callDrawerActivity() {
//        Intent intent = new Intent(this, DrawerActivity.class);
//        startActivity(intent);
//    }


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


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
