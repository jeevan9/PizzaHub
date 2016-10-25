package com.example.pizzahub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8;

    VegPizza vp=new VegPizza();
    PizzaTypeAdapter pa=new PizzaTypeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        /*t1=(TextView) findViewById(R.id.counter1);
        t2=(TextView) findViewById(R.id.counter2);
        t3=(TextView) findViewById(R.id.counter3);
        t4=(TextView) findViewById(R.id.counter4);
        */
        t1=(TextView) findViewById(R.id.value1);
        t2=(TextView) findViewById(R.id.value2);
        t3=(TextView) findViewById(R.id.value3);
        t4=(TextView) findViewById(R.id.value4);

        t5=(TextView) findViewById(R.id.cost1);
        t6=(TextView) findViewById(R.id.cost2);
        t7=(TextView) findViewById(R.id.cost3);
        t8=(TextView) findViewById(R.id.cost4);


        t1.setText(String.valueOf(pa.p2));
        t2.setText(String.valueOf(pa.q2));
        t3.setText(String.valueOf(pa.r2));
        t4.setText(String.valueOf(vp.c));
        t5.setText(String.valueOf(pa.cp2));
        t6.setText(String.valueOf(pa.cq2));
        t7.setText(String.valueOf(pa.cr2));
        t8.setText(String.valueOf(vp.total_cost));



        Toast.makeText(this,"vs="+pa.vs+"vm="+pa.vm+"vl="+pa.vl+"nvs="+pa.nvs+"nvm="+pa.nvm+"nvl="+pa.nvl+"bs="+pa.bs+"bm="+pa.bm+"bl="+pa.bl,Toast.LENGTH_SHORT).show();

        //t1.setText("Veg Pizza :"+pa.p2+"Non-Veg - Pizza: "+pa.q2+" Beverages : "+pa.r2+" Total Items : "+String.valueOf(vp.c));

    }
    public void enteraddress(View v)
    {

        Intent i=new Intent(this,SendCustomerActivity.class);
        startActivity(i);
    }
}
