package com.example.androidlearning.db;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.androidlearning.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by fcwl on 9/25/2015.
 *
 * http://developer.android.com/training/basics/data-storage/files.html#GetWritePermission
 */
public class FileIOActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ FileIOActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileio);
        writeToFile("Srinivas");

        String nameFromFile = readFromFile();
        EditText ioName = (EditText) findViewById(R.id.ioname_edittext);
        ioName.setText(nameFromFile);
    }

    private void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            System.out.println("File Created ------------------");
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile() {
        String data = "";
        try {
            InputStream inputStream = openFileInput("config.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                data = stringBuilder.toString();
            }

            System.out.println("----- read data data -----" + data);

        } catch (FileNotFoundException e) {
            Log.e("FileIOActivity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("FileIOActivity", "Can not read file: " + e.toString());
        }

        return data;
    }

}
