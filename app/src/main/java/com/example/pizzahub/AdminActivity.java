package com.example.pizzahub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void adminlogin(View v)
    {
        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
        String userid=t1.getText().toString();
        String password=t2.getText().toString();
        userid=userid.replace(" ","");
        int flag=0;
        if((userid.equals("")||userid.length()==0)&&password.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter userid and Password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (userid.equals("") || userid.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter userid", Toast.LENGTH_SHORT).show();
            }
            if (password.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter The Password", Toast.LENGTH_SHORT).show();

            }
        }
        if(flag!=1)
        {
            //String urlSuffix = "?userid="+userid+"&password="+password;
            AdminLogin rd = new AdminLogin(this);
            rd.execute(userid,password);
        }
    }

}
