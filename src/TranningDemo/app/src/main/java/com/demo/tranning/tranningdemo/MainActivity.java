package com.demo.tranning.tranningdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this,MovieActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Adapter View Flipper
        if (id == R.id.nav_camera) {
            startActivity(new Intent(this,AdapterViewFlipperActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this,GridViewActivity.class));
        } else if (id == R.id.nav_slideshow) {
            //Array adapter
            startActivity(new Intent(this,ArrayAdapterActivity.class));
        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(this,AutoCompleteTextView.class));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this,BaseAdapterActivity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this,ExpandableListAdapterActivity.class));
        }else if(id==R.id.nav_list_view_activity){
            startActivity(new Intent(this,ListActivityDemo.class));
        }else if(id==R.id.nav_simple_adapter){
            startActivity(new Intent(this,SimpleAdapterActivity.class));
        }else if(id==R.id.nav_simple_list_view){
            startActivity(new Intent(this,SimpleListViewActivity.class));
        }else if(id==R.id.nav_spinner){
            startActivity(new Intent(this,SpinnerActivity.class));
        }else if(id==R.id.nav_stack_view){
            startActivity(new Intent(this,StackViewActivity.class));
        }else if(id==R.id.nav_movie){
            startActivity(new Intent(this,MovieActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
