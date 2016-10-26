package com.example.pizzahub;

/**
 * Created by jeevansai on 26/10/2016.
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

public class  GetLinks extends AsyncTask<String,Void,String>{
    private Context context;
    public static String userlink="";
    ProgressDialog loading;
    public GetLinks(Context cxt)
    {
        context=cxt;
    }
    private static final String login_url_e="http://kjeevansai999.ml/pizza_app/orderlinks.php";

    public GetLinks()
    {

    }
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

        String s="?adminusername=jeevansai";
        try
        {

            URL url=new URL(login_url_e+s);
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
        userlink=result;
        Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
    }


}