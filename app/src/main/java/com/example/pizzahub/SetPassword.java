package com.example.pizzahub;

/**
 * Created by jeevansai on 15/10/2016.
 */


import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jeevansai on 02/10/2016.
 */
public class SetPassword extends AsyncTask<String,Void,String> {
    private Context context;
    ProgressDialog loading;
    String userid;

    public SetPassword(Context cxt) {
        context = cxt;
    }

    private static final String GETDATA_URL = "http://kjeevansai999.ml/pizza_app/forgotpassword.php";
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        loading = ProgressDialog.show(context, "Please Wait", "Loading", true, true);

    }

    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub
        BufferedReader br = null;
        StringBuffer sb;
        String s = arg0[0];
        userid=arg0[0];
        try {

            URL url = new URL(GETDATA_URL + "?username="+s);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
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
        String r1 = result;

        //Toast.makeText(context,result, Toast.LENGTH_SHORT).show();
        String res[] = result.split(" ");
        if (res[0].equals("Enter")) {
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        } else if ((res[0].length() == 5) && (res[1].length() == 10)) {
            try {
                String messageToSend = "From PizzaHub ==> Forgot Password  OTP : " + res[0];
                String number = res[1];

                SmsManager smsOperation = SmsManager.getDefault();
                PendingIntent sentPI;
                String sent="SMS_SENT";
                sentPI=PendingIntent.getBroadcast(context,0,new Intent(sent),0);
                smsOperation.sendTextMessage(res[1], null, messageToSend, sentPI, null);

                Toast.makeText(context, "SMS Sent Seuccessfully ", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,OTPVerificationActivity.class);
                i.putExtra("uname",userid);
                i.putExtra("otp",res[0]);
                context.startActivity(i);
                /*SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                // Saving string
                editor.putString("username",userid);
                editor.putString("key_name5",res[0]);

                editor.commit();
               */ // SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
            } catch (Exception e) {
                e.toString();
                Toast.makeText(context, e + "  Message Not Delivered ", Toast.LENGTH_SHORT).show();
            }
        }

    }
}