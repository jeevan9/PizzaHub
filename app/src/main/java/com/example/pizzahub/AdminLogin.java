package com.example.pizzahub;

/**
 * Created by jeevansai on 25/10/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class  AdminLogin extends AsyncTask<String,Void,String>{
    private Context context;
    public static String admin_user="";
    public static int count1 = 0;

    public static ArrayList<Pizza_Order> orders=new ArrayList<Pizza_Order>();
    public static ArrayList<String> uo=new ArrayList<String>();

    Login l1=new Login();
   // public static String logged_in_user="";
    ProgressDialog loading;
    public AdminLogin(Context cxt)
    {
        context=cxt;
    }
    private static final String login_url_c="http://kjeevansai999.ml/pizza_app/adminlogin.php";

    public AdminLogin()
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
        String username=arg0[0];
        String password=arg0[1];
        String s="?username="+username+"&password="+password;
        admin_user=username;
        try
        {

            URL url=new URL(login_url_c+s);
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
        //Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
       // logged_in_user=res[1];
        if(result.equals("Invalid Credentials"))
        {
            Toast.makeText(context,"Invalid Credentials", Toast.LENGTH_SHORT).show();
        }

        else if(result.equals("No-Orders"))
       {
            Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
           context.startActivity(new Intent(context, AdminHome.class));
       }
        else
        {
           // count1=0;
            try {
            JSONObject jo = new JSONObject(result);
            JSONArray ja = jo.getJSONArray("server_response");

                while (count1 < ja.length()) {
                    JSONObject jo2 = ja.getJSONObject(count1);
                    int vs=jo2.getInt("vs");
                    int vm=jo2.getInt("vm");
                    int vl=jo2.getInt("vl");
                    int nvs=jo2.getInt("nvs");
                    int nvm=jo2.getInt("nvm");
                    int nvl=jo2.getInt("nvl");
                    int bs=jo2.getInt("bs");
                    int bm=jo2.getInt("bm");
                    int bl=jo2.getInt("bl");
                    String or="";
                    if(vs>0)
                    {
                        or+="   VegPizza Small : "+vs;
                    }
                    if(vm>0)
                    {
                        or+="  VegPizza Medium : "+vm;
                    }
                    if(vl>0)
                    {
                        or+="   VegPizza Large : "+vl;
                    }
                    if(nvs>0)
                    {
                        or+="   Non-VegPizza Small : "+nvs;
                    }
                    if(nvm>0)
                    {
                        or+="   Non-VegPizza Medium : "+nvm;
                    }
                    if(nvl>0)
                    {
                        or+="   Non-VegPizza Large : "+nvl;
                    }
                    if(bs>0)
                    {
                        or+="   Beverage Small : "+bs;
                    }if(bm>0)
                    {
                        or+="   Beverage Medium : "+bm;
                    }
                    if(bl>0)
                    {
                        or+="   Beverage Large : "+bl;
                    }


                    String username=jo2.getString("username");
                    String ordernum=jo2.getString("ordernumber");
                    uo.add(count1,username+" "+ordernum);
                    orders.add(new Pizza_Order("Username : "+jo2.getString("username")+"  Address : "+jo2.getString("address")+"   Order-Number : "+jo2.getString("ordernumber")+or+" status : "+jo2.getString("status")));
                    //orders.add(new Pizza_Order(jo2.getString("username")));

                    count1++;
                }

            context.startActivity(new Intent(context, AdminHome.class));
        } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }


}