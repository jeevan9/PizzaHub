package com.example.pizzahub;

/**
 * Created by jeevansai on 20/10/2016.
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
import android.util.Log;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class  SendAddress extends AsyncTask<String,Void,String>{
    private Context context;
    public static String s1="";
    //public static String logged_in_user="";
    ProgressDialog loading;
    public SendAddress(Context cxt)
    {
        context=cxt;
    }
    private static final String login_url_b="http://kjeevansai999.ml/pizza_app/address.php";

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
        String address=arg0[1];
        String s="?username="+username+"&address="+address;
        try
        {

            URL url=new URL(login_url_b+s);
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
        s1=result;
        super.onPostExecute(result);
        loading.dismiss();
        //Toast.makeText(context, res[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
try {
    String res[] = s1.split(" ");
    String number = res[1];
    //Log.d("number",res[1]);
    String order_number = res[2];

    String messageToSend = "From PizzaHub Your order is successful  and Your Order Number is :" + res[2];

    if (res[0].equals("Order-Successful")) {

        SmsManager smsOperation = SmsManager.getDefault();
        PendingIntent sentPI;
        String sent = "SMS_SENT";
        sentPI = PendingIntent.getBroadcast(context, 0, new Intent(sent), 0);
        smsOperation.sendTextMessage(number, null, messageToSend, sentPI, null);
        Toast.makeText(context, "Order-Successful SMS Sent Seuccessfully ", Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(context, OTPVerificationActivity.class);

    }
}catch(Exception e) {

    e.toString();
    Toast.makeText(context, e + "  Message Not Delivered ", Toast.LENGTH_SHORT).show();
}//  String res[]=result.split(" ");
            //logged_in_user=res[1];
       /* if(result.equals("Order Successful"))
        {
            //context.startActivity(new Intent(context, NavigationActivity.class));
        }*/
        }


}