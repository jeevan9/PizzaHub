package com.example.pizzahub;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jeevansai on 15/10/2016.
 */

public class SignUp extends AsyncTask<String,Void,String>{
    private Context context;
    ProgressDialog loading;
    public SignUp(Context cxt)
    {
        context=cxt;
    }
    private static final String signup_url_a="http://kjeevansai999.ml/pizza_app/register.php";

    @Override
    protected void onPreExecute() {
        loading=ProgressDialog.show(context, "Please Wait","Loading", true, true);
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String name,username,password,email,mobileno;
        name=params[0];
        username=params[1];
        password=params[2];
        email=params[3];
        mobileno=params[4];
        BufferedReader br=null;
        StringBuffer sb;
        String s ="?name="+name+"&username="+username+"&password="+password+"&email="+email+"&mobileno="+mobileno;
        try
        {

            URL url=new URL(signup_url_a+s);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            br=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            sb=new StringBuffer();
            while((line=br.readLine())!=null)
            {
                sb.append(line+"\n");
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            return e.toString();
        }

        return sb.toString().trim();


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        loading.dismiss();
        super.onPostExecute(s);
        Toast.makeText(context,s, Toast.LENGTH_SHORT).show();
    }
}
