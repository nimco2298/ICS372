package com.example.fieldagents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.File;

import ourClasses.Site;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private JSON jsonInfo = new JSON();

    //to display to screen
    TextView screen;

    private DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        switch(item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                break;

            case R.id.nav_addCollection:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddCollectionFragment()).commit();

                break;
            case R.id.nav_addReading:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddReadingFragment()).commit();

                break;
            case R.id.nav_dataLog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DataLogFragment()).commit();

                break;
            case R.id.nav_endCollection:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EndCollectionFragment()).commit();

                break;
            case R.id.nav_invalidSite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InvalidSiteFragment()).commit();

                break;
            case R.id.nav_import:

                //change to the activity layout to import
                setContentView(R.layout.activity_json);

                //Created intent to launch the new activity
                Intent intent = new Intent(MainActivity.this, JSONActivity.class);
                startActivity(intent);

                //Toast.makeText(this, "JSON has been imported!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_export:
                ReaderWriter.fileWriter(Site.formatSiteForExport());
                Toast.makeText(this, "Export", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed(){

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }




}