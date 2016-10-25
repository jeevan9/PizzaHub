package com.example.pizzahub;

/**
 * Created by jeevansai on 25/10/2016.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class  AdminAccept extends AsyncTask<String,Void,String>{
    private Context context;
    PizzaTypeAdapter apt=new PizzaTypeAdapter();
    Login l2=new Login();
    AdminLogin adminLogin=new AdminLogin();
    Login lin=new Login();

    SendAddress saacc=new SendAddress();
    String username="";
    //public static String logged_in_user="";
    ProgressDialog loading;
    public AdminAccept(Context cxt)
    {
        context=cxt;
    }
    private static final String login_url_d="http://kjeevansai999.ml/pizza_app/accept.php";

    public AdminAccept()
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
        int i=0;
        username=lin.logged_in_user;
        /*String ss1[]=saacc.prodsfinalstr.get(0).split("-");
        String ss2[]=saacc.prodsfinalstr.get(1).split("-");
        String ss3[]=saacc.prodsfinalstr.get(2).split("-");
        String ss4[]=saacc.prodsfinalstr.get(3).split("-");
        String ss5[]=saacc.prodsfinalstr.get(4).split("-");
        String ss6[]=saacc.prodsfinalstr.get(5).split("-");
        String ss7[]=saacc.prodsfinalstr.get(6).split("-");
        String ss8[]=saacc.prodsfinalstr.get(7).split("-");*/
        String orderaccept="?adminusername="+adminLogin.admin_user+"&username="+username;
        for(i=0;i<saacc.prodi.size();i++)
        {
            orderaccept+="&"+saacc.prods.get(i)+"="+saacc.prodi.get(i);
        }
        try
        {

            URL url=new URL(login_url_d+orderaccept);
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
        Toast.makeText(context,"Your order number : "+saacc.order_no+" "+result, Toast.LENGTH_SHORT).show();
       // logged_in_user=res[1];
        if(result.equals("Your order is successful"))
        {
            try {
                String messageToSend="From PizzaHub : Your order is successful and your order number is  "+saacc.order_no+" and Your orders are "+saacc.ordermsg;
                SmsManager smsOperation = SmsManager.getDefault();
                PendingIntent sentPI;
                String sent="SMS_SENT";
                sentPI=PendingIntent.getBroadcast(context,0,new Intent(sent),0);
                smsOperation.sendTextMessage(lin.logged_in_user, null, messageToSend, sentPI, null);
                Toast.makeText(context, "SMS Sent Seuccessfully ", Toast.LENGTH_SHORT).show();
                 } catch (Exception e) {
                e.toString();
                Toast.makeText(context, e + "  Message Not Delivered ", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
        }

    }


}
