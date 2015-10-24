package com.example.androidlearning.db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidlearning.R;

import java.util.ArrayList;

/**
 * Created by FCWL on 9/21/2015.
 */
public class SQLiteActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ SQLiteActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setEnabled(true);
        saveButton.setOnClickListener(saveDataListener);
    }

    private View.OnClickListener saveDataListener = new View.OnClickListener() {
        public void onClick(View v) {
            System.out.println("--------- Save Data Listener Called ------------");
            EditText fname = (EditText) findViewById(R.id.fname_edittext);
            EditText lname = (EditText) findViewById(R.id.lname_edittext);
            EditText email = (EditText) findViewById(R.id.email);
            EditText street = (EditText) findViewById(R.id.street);
            EditText zip = (EditText) findViewById(R.id.zip);

            String firstName = fname.getText().toString();
            String lastName = lname.getText().toString();
            String emailId = email.getText().toString();
            String streetName = street.getText().toString();
            String zipCode = zip.getText().toString();

            saveData(firstName, lastName, emailId, streetName, zipCode);
        }
    };

    public void saveData(String firstName, String lastName, String email, String street, String zip) {
        System.out.println("--------- Save Data called ----------" + firstName);
        DBHelper dbHelper = new DBHelper(this);
        //Long id = dbHelper.insertContact("Srinivas1", "Mudunuri1", "srini@statefarm.com", "Washington St", "85298");
        Long id = dbHelper.insertContact(firstName, lastName, email, street, zip);
        System.out.println("------ id -----" + id);

        int rows = dbHelper.numberOfRows();
        System.out.println("------ rows -----" + rows);

        ArrayList<ContactsDTO> contactsList = dbHelper.getContactsList();
        System.out.println("--------- contactsList ----------" + contactsList.size());
        for(ContactsDTO contactsDTO : contactsList) {
            System.out.println(contactsDTO);
        }

        int rowsDeleted = dbHelper.deleteContact(2);
        System.out.println("------ rowsDeleted -----" + rowsDeleted);
    }

}
