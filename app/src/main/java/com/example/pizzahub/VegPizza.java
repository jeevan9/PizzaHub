package com.example.pizzahub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VegPizza extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_pizza);
        i1 = (ImageView) findViewById(R.id.pizza_photo);
        t1 = (TextView) findViewById(R.id.pizza_name);
        i1.setImageResource(getIntent().getIntExtra("image_url", 1));
        t1.setText("Name :" + getIntent().getStringExtra("name"));
    }
}
