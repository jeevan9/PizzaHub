package com.example.pizzahub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }
    public void getlink(View v)
    {
        GetLinks gl=new GetLinks(this);
        gl.execute();
     }

    public void accept(View v)
    {
        AdminAccept a=new AdminAccept(this);
        a.execute();

    }
}
