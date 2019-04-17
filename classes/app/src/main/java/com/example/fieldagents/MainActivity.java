package com.example.fieldagents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private JSON jsonInfo = new JSON();
    TextView screen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Button buttonReadJson = findViewById(R.id.buttonReadJson);
        buttonReadJson.setOnClickListener(this);
        Button buttonImportJson = findViewById(R.id.buttonImportJSON);
        buttonImportJson.setOnClickListener(this);

        screen = findViewById(R.id.txtJson); //display json thats read


    }
/*
    //when Read JSON button is clicked, it will launch code in JSON class
    public void onClickReadJSON (View view){

        TextView screen = findViewById(R.id.txtJson); //display readings

        String readingsList= jsonInfo.readJSON();
        screen.setText(readingsList);


    }

    public void onClickImportJSON(View view){
        TextView screen2 = findViewById(R.id.textShow);
        jsonInfo.quietImportFromFile();
        screen2.setText("Imported file can now be used");
    }

*/
    /*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//
*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonReadJson:

                /*
                TextView screen = findViewById(R.id.txtJson); //display readings

                String readingsList= jsonInfo.readJSON();
                screen.setText(readingsList);

                   */
                String readingsList= jsonInfo.readJSON();
                screen.setText(readingsList);
                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "Button Read JSON clicked!",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.buttonImportJSON:
               /*
                TextView screen2 = findViewById(R.id.textShow);
                jsonInfo.quietImportFromFile();
                screen2.setText("Imported file can now be used");
*/
                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "Button Import JSON clicked!",
                        Toast.LENGTH_LONG).show();
                break;

        }
    }

}
