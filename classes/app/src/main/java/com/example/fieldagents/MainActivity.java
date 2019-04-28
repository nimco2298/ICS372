package com.example.fieldagents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import ourClasses.AllSites;
import ourClasses.Site;

import static android.os.Environment.getExternalStorageDirectory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private JSON jsonInfo = new JSON();

    //to display to screen
    TextView screen, screen2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the button
        Button buttonImportJson = findViewById(R.id.buttonImportJSON);
        //listen for clicks
        buttonImportJson.setOnClickListener(this);


        Button buttonReadJson = findViewById(R.id.buttonReadJSON);
        buttonReadJson.setOnClickListener(this);



        Button buttonExport = findViewById(R.id.buttonExport);
        buttonExport.setOnClickListener(this);

/*
        screen = findViewById(R.id.textShow); //display json thats read


    }

    //when Read JSON button is clicked, it will launch code in JSON class
    public void onClickReadJSON (View view){

        TextView screen = findViewById(R.id.txtJson); //display readings

        String readingsList= jsonInfo.readJSON();
        screen.setText(readingsList);


    }
*/
        screen = findViewById(R.id.textShow); //display json thats read
        screen2 = findViewById(R.id.txtJson); //display import json method


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonImportJSON:

                File fileDir1 = Environment.getExternalStorageDirectory();

                //json file is in sdcard
                File file1 = new File(fileDir1 + "/Download/json/example.json");
                // File file = new File(fileDir, "/sdcard/Downloads/json/example.json")

                String readings1 = jsonInfo.importFromFile(file1);
                screen2.setText(readings1);
                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "JSON Data is imported!",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.buttonReadJSON:

                    //get the file from android
                    File fileDir = getExternalStorageDirectory();

                    //json file is in sdcard
                    File file = new File(fileDir + "/Download/json/example.json");
                   // File file = new File(fileDir, "/sdcard/Downloads/json/example.json")

                    String readings2 = jsonInfo.readJSON(file);
                    screen.setText(readings2); // display the output to the Android screen



                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "JSON Is Read!",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.buttonExport:

                ReaderWriter.fileWriter(Site.formatSiteForExport());

        }
    }

}
