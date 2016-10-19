package com.example.pizzahub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VegPizza extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2;
    public static int c=0;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_pizza);
        i1 = (ImageView) findViewById(R.id.pizza_photo);
        t1 = (TextView) findViewById(R.id.pizza_name);
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        i1.setImageResource(getIntent().getIntExtra("image_url", 1));
        t1.setText("Name :" + getIntent().getStringExtra("name"));
    }
    public void incdec(View v)
    {
        Button b= (Button) v;
        switch(b.getId())
        {
            case R.id.button1:
                c=c-1;
                Toast.makeText(this,String.valueOf(c),Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                c++;
                Toast.makeText(this,String.valueOf(c),Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void cart(View v)
    {
       Intent i=new Intent(this,AddressActivity.class);
        //i.putExtra("npizza",c);
        startActivity(i);
    }
}
