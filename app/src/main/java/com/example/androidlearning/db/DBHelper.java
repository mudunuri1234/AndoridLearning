package com.example.androidlearning.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by fcwl on 7/1/2015.
 *
 * http://www.tutorialspoint.com/android/android_sqlite_database.htm
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TestDB.db";
    public static final Integer DATABASE_VERSION = 1;
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_FNAME = "firstName";
    public static final String CONTACTS_COLUMN_LNAME = "lastName";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            " create table contacts " +
            " (id integer primary key, firstName text, lastName text, email text, street text, zip text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public Long insertContact(String firstName, String lastName, String email, String street, String zip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("zip", zip);

        // Returns the inserted PK value
        Long id = db.insert("contacts", null, contentValues);
        return id;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact(Integer id, String firstName, String lastName, String email, String street, String zip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("zip", zip);

        db.update("contacts", contentValues, "id = ?", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllContacts() {
        ArrayList<String> dataList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from contacts", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            dataList.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_FNAME)));
            res.moveToNext();
        }
        return dataList;
    }

    public ArrayList<ContactsDTO> getContactsList() {
        ArrayList<ContactsDTO> contactsList = new ArrayList<ContactsDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from contacts", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            ContactsDTO contactsDTO = new ContactsDTO();
            String fname = res.getString(res.getColumnIndex(CONTACTS_COLUMN_FNAME));
            String lname = res.getString(res.getColumnIndex(CONTACTS_COLUMN_LNAME));
            String email = res.getString(res.getColumnIndex("email"));
            String street = res.getString(res.getColumnIndex("street"));
            String zip = res.getString(res.getColumnIndex("zip"));
            Integer id = res.getInt(res.getColumnIndex("id"));

            contactsDTO.setFirstName(fname);
            contactsDTO.setLastName(lname);
            contactsDTO.setEmail(email);
            contactsDTO.setStreet(street);
            contactsDTO.setZip(zip);
            contactsDTO.setId(id);

            contactsList.add(contactsDTO);
            res.moveToNext();
        }

        return contactsList;
    }

}
