package com.example.pizzahub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView im1;
    ImageView im2,im3,im4,im5;
    private List<Pizza> pizzas;
    private RecyclerView rv;
    /*public static int num_of_items=0;
    public static int item_type[]=new int[num_of_items];
    public static int item_type_count[]=new int[num_of_items];
    */

    //    Login l1=new Login();
    //  TextView nav_header_name,nav_header_mailid;
    /* public  NavigationActivity(String name,String mailid)
     {
         this.name=name;
         this.mailid=mailid;
     }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /* im1= (ImageView) findViewById(R.id.imageView1);
        im2= (ImageView) findViewById(R.id.imageView2);
        im3= (ImageView) findViewById(R.id.imageView3);
        im4= (ImageView) findViewById(R.id.imageView4);
        im5= (ImageView) findViewById(R.id.imageView5);
        Picasso.with(getApplicationContext()).load("https://images-na.ssl-images-amazon.com/images/I/81RfxKAIXEL.png").into(im1);
        Picasso.with(getApplicationContext()).load("https://images-na.ssl-images-amazon.com/images/I/81RfxKAIXEL.png").into(im2);
        Picasso.with(getApplicationContext()).load("https://images-na.ssl-images-amazon.com/images/I/81RfxKAIXEL.png").into(im3);
        Picasso.with(getApplicationContext()).load("https://images-na.ssl-images-amazon.com/images/I/81RfxKAIXEL.png").into(im4);
        Picasso.with(getApplicationContext()).load("https://images-na.ssl-images-amazon.com/images/I/81RfxKAIXEL.png").into(im5);
*/
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       /* nav_header_name= (TextView) findViewById(R.id.nav_name);
        nav_header_mailid= (TextView) findViewById(R.id.nav_mailid);
        nav_header_name.setText(l1.name);
        nav_header_mailid.setText(l1.emailid);*/


        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();


    }

    private void initializeData(){
        pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Veg Pizza", R.drawable.pizza));
        pizzas.add(new Pizza("Non-Veg Pizza", R.drawable.pizza));
        pizzas.add(new Pizza("Beverages", R.drawable.pizza));
    }

    private void initializeAdapter(){
        PizzaTypeAdapter adapter = new PizzaTypeAdapter(pizzas,this);
        rv.setAdapter(adapter);
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
    /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.navigation, menu);
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

      */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } */if (id == R.id.chp) {
            Intent i=new Intent(this,PasswordChangeActivity.class);
            startActivity(i);
        }
        else if (id == R.id.fp) {
            Intent i=new Intent(this,PasswordSetActivity.class);
            startActivity(i);
        }
        else if (id == R.id.logout) {
            finish();
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);

        }

        else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
