package com.example.androidlearning.md;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.androidlearning.R;

/**
 * Created by fcwl on 7/9/2015.
 */
public class ToolbarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("------- Inside onCreateOptionsMenu --------");
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        CreateMenu(menu);

        return true;
    }

    private void CreateMenu(Menu menu_new) {
        MenuItem mnu1 = menu_new.add(0, 0, 0, "Item 1");
        {
            mnu1.setAlphabeticShortcut('a');
            mnu1.setIcon(R.drawable.ic_launcher);
        }

        MenuItem mnu2 = menu_new.add(0, 1, 1, "Item 2");
        {
            mnu2.setAlphabeticShortcut('b');
            mnu2.setIcon(R.drawable.ic_launcher);
        }

        MenuItem mnu3 = menu_new.add(0, 2, 2, "Item 3");
        {
            mnu3.setAlphabeticShortcut('c');
            mnu3.setIcon(R.drawable.ic_launcher);
        }

        MenuItem mnu4 = menu_new.add(0, 3, 3, "Item 4");
        {
            mnu4.setAlphabeticShortcut('d');
        }

        menu_new.add(0, 4, 4, "Item 5");
        menu_new.add(0, 5, 5, "Item 6");
        menu_new.add(0, 6, 6, "Item 7");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("------- Inside onOptionsItemSelected --------");
        return MenuChoice(item);
    }

    private boolean MenuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "You clicked on Item 1", Toast.LENGTH_LONG).show();
                return true;
            case 1:
                Toast.makeText(this, "You clicked on Item 2", Toast.LENGTH_LONG).show();
                return true;
            case 2:
                Toast.makeText(this, "You clicked on Item 3", Toast.LENGTH_LONG).show();
                return true;
            case 3:
                Toast.makeText(this, "You clicked on Item 4", Toast.LENGTH_LONG).show();
                return true;
            case 4:
                Toast.makeText(this, "You clicked on Item 5", Toast.LENGTH_LONG).show();
                return true;
            case 5:
                Toast.makeText(this, "You clicked on Item 6", Toast.LENGTH_LONG).show();
                return true;
            case 6:
                Toast.makeText(this, "You clicked on Item 7", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
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
