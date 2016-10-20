package com.example.pizzahub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendCustomerActivity extends AppCompatActivity {
    Login lu=new Login();
    String user;
    EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_customer);

    }
    public void deliverto(View v)
    {
        user=lu.logged_in_user;
        t1= (EditText) findViewById(R.id.editText1);
        String s1=t1.getText().toString();
        SendAddress s=new SendAddress(this);
        s.execute(lu.logged_in_user,s1);
    }
    public void logout(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
