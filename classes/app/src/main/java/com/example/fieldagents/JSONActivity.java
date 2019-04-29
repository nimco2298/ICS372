package com.example.fieldagents;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class JSONActivity extends AppCompatActivity implements View.OnClickListener{


    private JSON jsonInfo = new JSON();

    //to display to screen
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_json);


        Button buttonImportJson = findViewById(R.id.buttonImportJSON);
        buttonImportJson.setOnClickListener(this);

        Button buttonImportXML = findViewById(R.id.buttonImportXML);
        buttonImportXML.setOnClickListener(this);

        screen = findViewById(R.id.textShow); //display any info to this Android screen
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonImportJSON:

                //get the file from android
                File fileDir = Environment.getExternalStorageDirectory();

                //json file is in sdcard
                File file = new File(fileDir + "/Download/json/example.json");
                // File file = new File(fileDir, "/sdcard/Downloads/json/example.json")

                String readings = jsonInfo.importFromFile(file);
                screen.setText(readings); // display the output to the Android screen


                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "JSON Is imported!",
                        Toast.LENGTH_LONG).show();


                //Launch back to Main Activity
                Intent intent = new Intent(JSONActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonImportXML:

                //get the file from android
                File fileDir2 = Environment.getExternalStorageDirectory();

                //json file is in sdcard
                File file2 = new File(fileDir2 + "/Download/json/example.xml");
                // File file = new File(fileDir, "/sdcard/Downloads/json/example.json")


                /** String readings = xmlInfo.importFromFile(file) **/
                /** screen.setText(readings); // display the output to the Android screen **/


                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "XML Is imported!",
                        Toast.LENGTH_LONG).show();
                break;


        }


       }
    }

