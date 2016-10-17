package com.example.pizzahub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    String name,username,password,email,mobileno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }
    public void signup(View v)
    {
        e1= (EditText) findViewById(R.id.editText1);
        e2= (EditText) findViewById(R.id.editText2);
        e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editText4);
        e5= (EditText) findViewById(R.id.editText5);
        name=e1.getText().toString();
        username=e2.getText().toString();
        password=e3.getText().toString();
        email=e4.getText().toString();
        mobileno=e5.getText().toString();
        int flag=0;
        if(name.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
        }

        else if(username.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();
        }

        else if(password.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
        }

        else if(email.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please enter your email",Toast.LENGTH_LONG).show();
        }

        else if(mobileno.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please enter your mobileno",Toast.LENGTH_LONG).show();
        }

        if(flag!=1)
        {
            SignUp rd=new SignUp(this);
            rd.execute(name,username,password,email,mobileno);
        }

    }
}
