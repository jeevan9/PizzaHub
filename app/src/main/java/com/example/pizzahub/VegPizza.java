package com.example.pizzahub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VegPizza extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2;
    public static int c=0;
    public static int total_cost=0;
    Button b1,b2;

    Spinner spinner1;
    TextView t3;
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
        t3= (TextView) findViewById(R.id.pizzacost);
        i1.setImageResource(getIntent().getIntExtra("image_url", 1));
        t1.setText("" + getIntent().getStringExtra("name"));
        spinner1= (Spinner) findViewById(R.id.pizzasize);
        ArrayAdapter<CharSequence> array_adapter=ArrayAdapter.createFromResource(this, R.array.pizzatypes, android.R.layout.simple_spinner_item);
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(array_adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Selected Item is:"+parent.getItemAtPosition(position)+"  At Pos:"+position, Toast.LENGTH_LONG).show();
                p1.s= (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "You Select Something", Toast.LENGTH_LONG).show();
            }
        });

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
                if(t1.getText().toString().equals("Veg Pizza"))
                {
                    if(p1.s.equals("small"))
                    {
                        p1.cp2=p1.cp2-110;
                        total_cost=total_cost-110;
                        t3.setText("110");
                        p1.vs--;
                    }
                    if(p1.s.equals("medium"))
                    {
                        p1.cp2=p1.cp2-130;
                        t3.setText("130");
                        total_cost=total_cost-130;
                        p1.vm--;
                    }

                    if(p1.s.equals("large"))
                    {
                        t3.setText("150");
                        p1.cp2=p1.cp2-150;
                        total_cost=total_cost-150;
                        p1.vl--;
                    }

                    // Toast.makeText(this,"Veg",Toast.LENGTH_SHORT).show();
                    p1.p2=p1.item_count1.get(0);
                    p1.p2--;
                    p1.item_count1.set(0,p1.p2);
                }

                if(t1.getText().toString().equals("Non-Veg Pizza"))
                {

                    if(p1.s.equals("small"))
                    {

                        p1.cq2=p1.cq2-170;
                        total_cost=total_cost-170;
                        t3.setText("170");
                        p1.nvs--;
                    }
                    if(p1.s.equals("medium"))
                    {
                        p1.cq2=p1.cq2-190;
                        total_cost=total_cost-190;
                        t3.setText("190");
                        p1.nvm--;
                    }

                    if(p1.s.equals("large"))
                    {
                        t3.setText("210");
                        p1.cq2=p1.cq2-210;
                        total_cost=total_cost-210;
                        p1.nvl--;
                    }
                    //Toast.makeText(this,"Non-Veg",Toast.LENGTH_SHORT).show();
                    p1.q2=p1.item_count1.get(1);
                    p1.q2--;
//                    p1.cq2=p1.cq2-200;
                    p1.item_count1.set(1,p1.q2);

  //                  total_cost=total_cost-200;
                }

                if(t1.getText().toString().equals("Beverages"))
                {
                    if(p1.s.equals("small"))
                    {

                        p1.cr2=p1.cr2-40;
                        total_cost=total_cost-40;
                        t3.setText("40");
                        p1.bs--;
                    }
                    if(p1.s.equals("medium"))
                    {
                        p1.cr2=p1.cr2-60;
                        total_cost=total_cost-60;
                        t3.setText("60");
                        p1.bm--;
                    }

                    if(p1.s.equals("large"))
                    {
                        p1.cr2=p1.cr2-80;
                        total_cost=total_cost-80;
                        t3.setText("80");
                        p1.bl--;
                    }


                    //Toast.makeText(this,"Beverage",Toast.LENGTH_SHORT).show();
                    p1.r2=p1.item_count1.get(2);
                    p1.r2--;
                   // p1.cr2=p1.cr2-50;
                    p1.item_count1.set(2,p1.r2);

                   // total_cost=total_cost-50;
                }
                Toast.makeText(this,String.valueOf(c),Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                c++;
                if(t1.getText().toString().equals("Veg Pizza"))
                {

                   // Toast.makeText(this,"Veg",Toast.LENGTH_SHORT).show();
                    p1.p2=p1.item_count1.get(0);
                    if(p1.s.equals("small"))
                    {
                        t3.setText("110");
                        p1.cp2=p1.cp2+110;
                        total_cost=total_cost+110;
                        p1.vs++;


                    }
                    if(p1.s.equals("medium"))
                    {
                        t3.setText("130");
                        p1.cp2=p1.cp2+130;
                        total_cost=total_cost+130;
                    p1.vm++;
                    }

                    if(p1.s.equals("large"))
                    {
                        t3.setText("150");
                        p1.cp2=p1.cp2+150;
                        total_cost=total_cost+150;
                        p1.vl++;
                    }
                    p1.p2++;
                   // p1.cp2=p1.cp2+150;
                    p1.item_count1.set(0,p1.p2);

                    //total_cost=total_cost+150;
                }

                if(t1.getText().toString().equals("Non-Veg Pizza"))
                {

                    if(p1.s.equals("small"))
                    {
                        t3.setText("170");
                        p1.cq2=p1.cq2+170;
                        total_cost=total_cost+170;
                        p1.nvs++;
                    }
                    if(p1.s.equals("medium"))
                    {
                        t3.setText("190");
                        p1.cq2=p1.cq2+190;
                        total_cost=total_cost+190;
                        p1.nvm++;
                    }

                    if(p1.s.equals("large"))
                    {
                        t3.setText("210");
                        p1.cq2=p1.cq2+210;
                        total_cost=total_cost+210;
                    p1.nvl++;
                    }

                   // Toast.makeText(this,"Non-Veg",Toast.LENGTH_SHORT).show();
                    p1.q2=p1.item_count1.get(1);
                    p1.q2++;
                    //p1.cq2=p1.cq2+200;

                   // total_cost=total_cost+200;
                    p1.item_count1.set(1,p1.q2);
                }

                if(t1.getText().toString().equals("Beverages"))
                {

                    if(p1.s.equals("small"))
                    {
                        t3.setText("40");
                        p1.cr2=p1.cr2+40;
                        total_cost=total_cost+40;
                        p1.bs++;
                    }
                    if(p1.s.equals("medium"))
                    {
                        t3.setText("60");
                        p1.cr2=p1.cr2+60;
                        total_cost=total_cost+60;
                        p1.bm++;
                    }

                    if(p1.s.equals("large"))
                    {
                        t3.setText("80");
                        p1.cr2=p1.cr2+80;
                        total_cost=total_cost+80;
                    p1.bl++;
                    }

                    // Toast.makeText(this,"Beverage",Toast.LENGTH_SHORT).show();
                    p1.r2=p1.item_count1.get(2);
                    p1.r2++;
                    //p1.cr2=p1.cr2+50;

                  //  total_cost=total_cost+50;
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
