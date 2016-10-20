package com.example.pizzahub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VegPizza extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2;
    public static int c=0;
    Button b1,b2;

    PizzaTypeAdapter p1=new PizzaTypeAdapter();

    int i=0;
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
    /*
    *  pizzas.add(new Pizza("Veg Pizza", R.drawable.pizza));
        pizzas.add(new Pizza("Non-Veg Pizza", R.drawable.pizza));
        pizzas.add(new Pizza("Beverages", R.drawable.pizza));
        pizzas.add(new Pizza("Veg Pizza", R.drawable.pizza));
        pizzas.add(new Pizza("Non-Veg Pizza", R.drawable.pizza));
        pizzas.add(new Pizza("Beverages", R.drawable.pizza));
    *
    *
    * */
    public void incdec(View v)
    {
        Button b= (Button) v;
        switch(b.getId())
        {
            case R.id.button1:
                c=c-1;
                if(t1.getText().toString().equals("Name :Veg Pizza"))
                {

                    Toast.makeText(this,"Veg",Toast.LENGTH_SHORT).show();
                    p1.p2=p1.item_count1.get(0);
                    p1.p2--;
                    p1.item_count1.set(0,p1.p2);
                }

                if(t1.getText().toString().equals("Name :Non-Veg Pizza"))
                {

                    //Toast.makeText(this,"Non-Veg",Toast.LENGTH_SHORT).show();
                    p1.q2=p1.item_count1.get(1);
                    p1.q2--;

                    p1.item_count1.set(1,p1.q2);
                }

                if(t1.getText().toString().equals("Name :Beverages"))
                {

                    //Toast.makeText(this,"Beverage",Toast.LENGTH_SHORT).show();
                    p1.r2=p1.item_count1.get(2);
                    p1.r2--;

                    p1.item_count1.set(2,p1.r2);
                }
                Toast.makeText(this,String.valueOf(c),Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                c++;
                if(t1.getText().toString().equals("Name :Veg Pizza"))
                {
                   // Toast.makeText(this,"Veg",Toast.LENGTH_SHORT).show();
                    p1.p2=p1.item_count1.get(0);
                    p1.p2++;

                    p1.item_count1.set(0,p1.p2);
                }

                if(t1.getText().toString().equals("Name :Non-Veg Pizza"))
                {

                   // Toast.makeText(this,"Non-Veg",Toast.LENGTH_SHORT).show();
                    p1.q2=p1.item_count1.get(1);
                    p1.q2++;
                    p1.item_count1.set(1,p1.q2);
                }

                if(t1.getText().toString().equals("Name :Beverages"))
                {

                   // Toast.makeText(this,"Beverage",Toast.LENGTH_SHORT).show();
                    p1.r2=p1.item_count1.get(2);
                    p1.r2++;
                    p1.item_count1.set(2,p1.r2);
                }
                Toast.makeText(this,String.valueOf(c),Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void cart(View v)
    {
       int a1= p1.item_count1.get(0);
        int b1=p1.item_count1.get(1);
        int c1=p1.item_count1.get(2);

       Intent i=new Intent(this,AddressActivity.class);

        startActivity(i);


        //Toast.makeText(this,"  Veg Pizza: "+String.valueOf(p1.item_count1.get(0))+"  Non-Veg Pizza:  "+String.valueOf(p1.item_count1.get(2))+"  Beverages : "+String.valueOf(p1.item_count1.get(2)),Toast.LENGTH_LONG).show();

        //Toast.makeText(this,"  Veg Pizza: "+String.valueOf(p1.p2)+"  Non-Veg Pizza:  "+String.valueOf(p1.q2)+"  Beverages : "+String.valueOf(p1.r2),Toast.LENGTH_LONG).show();


    }
}
