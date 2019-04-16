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
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Button buttonReadJson = findViewById(R.id.buttonReadJson);
        buttonReadJson.setOnClickListener(this);

    }

    //when Read JSON button is clicked, it will launch code in JSON class
    public void onClickReadJSON (View view){

        TextView screen = findViewById(R.id.textShow); //display readings

        String readingsList= jsonInfo.readJSON();
        screen.setText(readingsList);

       // display.setText(readings);
    }

    //
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
            case R.id.buttonReadJson1:
                //mini notiication on screen
                Toast.makeText(getApplicationContext(), "Button Read JSON clicked!",
                        Toast.LENGTH_LONG).show();
                break;

        }
    }

}
