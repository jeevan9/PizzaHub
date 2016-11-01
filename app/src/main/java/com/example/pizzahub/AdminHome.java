package com.example.pizzahub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AdminHome extends AppCompatActivity {
    private List<Pizza_Order> pizza_order;
    private RecyclerView rv;
    AdminLogin a1=new AdminLogin();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeAdapter();

    }
  /*  public void getlink(View v)
    {
        GetLinks gl=new GetLinks(this);
        gl.execute();
     }

    public void accept(View v)
    {
        AdminAccept a=new AdminAccept(this);
        a.execute();

    }*/


    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(AdminLogin.orders,this);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
