package com.example.pizzahub;

/**
 * Created by jeevansai on 15/10/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class  Login extends AsyncTask<String,Void,String>{
    private Context context;
    ProgressDialog loading;
    public Login(Context cxt)
    {
        context=cxt;
    }
    private static final String login_url_a="http://kjeevansai999.ml/pizza_app/login.php";

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        loading=ProgressDialog.show(context, "Please Wait","Loading", true, true);

    }
    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub
        BufferedReader br=null;
        StringBuffer sb;
        String username=arg0[0];
        String password=arg0[1];
        String s="?username="+username+"&password="+password;
        try
        {

            URL url=new URL(login_url_a+s);
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
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        loading.dismiss();
        Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
        String res[]=result.split(" ");
        if(res[0].equals("Welcome"))
        {
            context.startActivity(new Intent(context, NavigationActivity.class));
        }

    }


}