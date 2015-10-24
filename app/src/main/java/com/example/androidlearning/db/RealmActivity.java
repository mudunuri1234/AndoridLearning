package com.example.androidlearning.db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidlearning.R;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by fcwl on 9/22/2015.
 *
 * http://code.oursky.com/realm-database-for-android-projects/
 * https://realm.io/docs/java/0.73.0/#queries
 */
public class RealmActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ RealmActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        Button saveButton = (Button) findViewById(R.id.realm_save_button);
        saveButton.setEnabled(true);
        saveButton.setOnClickListener(saveDataListener);
    }

    private View.OnClickListener saveDataListener = new View.OnClickListener() {
        public void onClick(View v) {
            System.out.println("--------- Save Data Listener Called -----------");
            //addContact();

            ArrayList<Contacts> contacts = getContacts();

            //deleteContact();

            //updateContact();
        }
    };

    private ArrayList<Contacts> getContacts() {
        ArrayList<Contacts> contactsList = new ArrayList<>();
        Realm realm = Realm.getInstance(this);
        RealmResults<Contacts> query = realm.where(Contacts.class).findAll();
        for (Contacts contact : query) {
            contactsList.add(contact);
            System.out.println("---- name -----" + contact.toString());
        }
        System.out.println("--------- query ----------" + query.size());
        return contactsList;
    }

    public void addContact() {
        Realm realm = Realm.getInstance(getApplicationContext());

        // Begings the transaction
        realm.beginTransaction();
        Contacts contacts = realm.createObject(Contacts.class);

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

        // Adding Primary Key
        contacts.setId(UUID.randomUUID().toString());
        contacts.setFirstName(firstName);
        contacts.setLastName(lastName);
        contacts.setEmail(emailId);
        contacts.setStreet(streetName);
        contacts.setZip(zipCode);

        System.out.println("--------- contacts ----------" + contacts.toString());

        // Commit the transaction
        realm.commitTransaction();
    }

    private void deleteContact() {
        Realm realm = Realm.getInstance(getApplicationContext());
        realm.beginTransaction();

        RealmResults<Contacts> results = realm.where(Contacts.class).findAll();
        System.out.println("--------- resultsBefore ----------" + results.size());

        results.remove(0);
        realm.commitTransaction();

        RealmResults<Contacts> resultsAfter = realm.where(Contacts.class).findAll();
        System.out.println("--------- resultsAfter ----------" + resultsAfter.size());
    }

    private void updateContact() {
        Realm realm = Realm.getInstance(getApplicationContext());
        realm.beginTransaction();

        RealmResults<Contacts> results = realm.where(Contacts.class).findAll();
        System.out.println("--------- resultsBefore ----------" + results.size());

        Contacts contact = results.get(0);
        contact.setLastName("New Name");
        realm.commitTransaction();

        getContacts();
    }

}

