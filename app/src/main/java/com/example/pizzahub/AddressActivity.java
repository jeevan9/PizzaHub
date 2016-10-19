package com.example.pizzahub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {
    TextView t1;
    VegPizza p1=new VegPizza();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        t1=(TextView) findViewById(R.id.counter);
        t1.setText(String.valueOf(p1.c));
    }
}
