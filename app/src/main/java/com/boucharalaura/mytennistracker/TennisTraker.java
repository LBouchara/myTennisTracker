package com.boucharalaura.mytennistracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TennisTraker extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MatchesMap.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis_traker);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        InsertData FRGData = InsertData.newInstance();
        FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
        fgt.addToBackStack("new fragment");
        fgt.replace(R.id.container, FRGData).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tennis_traker, menu);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            final int REQUEST_IMAGE_CAPTURE = 0;
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"fname_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
            //takePictureIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null)
            {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
        else if (id == R.id.nav_gallery)
        {
        }
        else if (id == R.id.nav_list)
        {
            DisplayData FRGData = DisplayData.newInstance();
            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
            fgt.addToBackStack("new fragment");
            fgt.replace(R.id.container, FRGData).commit();
        }
        else if (id == R.id.nav_recorder)
        {
            InsertData FRGData = InsertData.newInstance();
            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
            fgt.addToBackStack("new fragment");
            fgt.replace(R.id.container, FRGData).commit();
        }
        else if (id == R.id.nav_manage)
        {
        }
        else if (id == R.id.nav_map)
        {
            MatchesMap FRGData = MatchesMap.newInstance();
            FragmentTransaction fgt = getSupportFragmentManager().beginTransaction();
            fgt.addToBackStack("new fragment");
            fgt.replace(R.id.container, FRGData).commit();
        }
        else if (id == R.id.nav_share)
        {
        }
        else if (id == R.id.nav_send)
        {
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
