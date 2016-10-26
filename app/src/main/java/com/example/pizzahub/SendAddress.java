package com.example.pizzahub;

/**
 * Created by jeevansai on 20/10/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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
    public static String ordermsg="";
    public static String s1="";
    String username="";
    Login inman=new Login();
    public static String order_no="";
    public static ArrayList<Integer> prodi=new ArrayList<Integer>();
   public static ArrayList<String> prods=new ArrayList<String>();
    public static ArrayList<String> prodsfinal=new ArrayList<String>();
    public static ArrayList<String> prodsfinalstr=new ArrayList<String>();
    public static ArrayList<Integer> prodsfinali=new ArrayList<Integer>();
    //public static String logged_in_user="";
    ProgressDialog loading;
    public SendAddress(Context cxt)
    {
        context=cxt;
    }
    public SendAddress(){}
    private static final String login_url_b="http://kjeevansai999.ml/pizza_app/address.php";

    PizzaTypeAdapter pta=new PizzaTypeAdapter();
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
        username=arg0[0];
        String address=arg0[1];
        pta.svs=String.valueOf(pta.vs);
        pta.svm=String.valueOf(pta.vm);
        pta.svl=String.valueOf(pta.vl);
        pta.snvs=String.valueOf(pta.nvs);
        pta.snvm=String.valueOf(pta.nvm);
        pta.snvl=String.valueOf(pta.nvl);
        pta.sbs=String.valueOf(pta.bs);
        pta.sbm=String.valueOf(pta.bm);
        pta.sbl=String.valueOf(pta.bl);
        String s="?username="+username+"&address="+address+"&vs="+pta.svs+"&vm="+pta.svm+"&vl="+pta.svl+"&nvs="+pta.snvs+"&nvm="+pta.snvm+"&nvl="+pta.snvl+"&bs="+pta.sbs+"&bm="+pta.sbm+"&bl="+pta.sbl;

        int i=0;
        prodi.add(0,pta.vs);
        prodi.add(1,pta.vm);
        prodi.add(2,pta.vl);
        prodi.add(3,pta.nvs);
        prodi.add(4,pta.nvm);
        prodi.add(5,pta.nvl);
        prodi.add(6,pta.bs);
        prodi.add(7,pta.bm);
        prodi.add(8,pta.bl);
        prods.add(0,pta.svs);
        prods.add(1,pta.svm);
        prods.add(2,pta.svl);
        prods.add(3,pta.snvs);
        prods.add(4,pta.snvm);
        prods.add(5,pta.snvl);
        prods.add(6,pta.sbs);
        prods.add(7,pta.sbm);
        prods.add(8,pta.sbl);
        int cr=0;

            if(prodi.get(0)>0)
            {

                prodsfinal.add(cr,"Veg Pizza Small : "+prods.get(0));
                prodsfinalstr.add(cr,"vs");
                prodsfinali.add(cr,prodi.get(0));

            cr++;
            }
            if(prodi.get(1)>0)
            {
                prodsfinalstr.add(cr,"vm");
                prodsfinali.add(cr,prodi.get(1));
                prodsfinal.add(cr,"Veg Pizza Medium : "+prods.get(1));
                cr++;
            }
            if(prodi.get(2)>0)
            {
                prodsfinalstr.add(cr,"vl");
                prodsfinali.add(cr,prodi.get(2));
                prodsfinal.add(cr,"Veg Pizza Large : "+prods.get(2));
                cr++;
            }
            if(prodi.get(3)>0)
            {
                prodsfinalstr.add(cr,"nvs");
                prodsfinali.add(cr,prodi.get(3));
                prodsfinal.add(cr,"Non-Veg Pizza Small : "+prods.get(3));
                cr++;
            }
            if(prodi.get(4)>0)
            {
                prodsfinalstr.add(cr,"nvm");
                prodsfinali.add(cr,prodi.get(4));
                prodsfinal.add(cr,"Non-Veg Pizza Medium : "+prods.get(4));
                cr++;
            }
            if(prodi.get(5)>0)
            {
                prodsfinalstr.add(cr,"nvl");
                prodsfinali.add(cr,prodi.get(5));
                prodsfinal.add(cr,"Non-Veg Pizza Large : "+prods.get(5));
                cr++;
            }
            if(prodi.get(6)>0)
            {
                prodsfinalstr.add(cr,"bs");
                prodsfinali.add(cr,prodi.get(6));
                prodsfinal.add(cr,"Beverage Small : "+prods.get(6));
                cr++;
            }
            if(prodi.get(7)>0)
            {
                prodsfinalstr.add(cr,"bm");
                prodsfinali.add(cr,prodi.get(7));
                prodsfinal.add(cr,"Beverage Medium"+prods.get(7));
                cr++;
            }
            if(prodi.get(8)>0)
            {
                prodsfinalstr.add(cr,"bl");
                prodsfinali.add(cr,prodi.get(8));
                prodsfinal.add(cr,"Beverage Large : "+prods.get(8));
                cr++;
            }





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
    String adminno=res[3];
    int j=0;


    for(j=0;j<prodsfinal.size();j++)
    {
        ordermsg+=prodsfinal.get(j);
    }

    String messageToSend = "From PizzaHub Your order is placed  and Your Order Number is : " + res[2]+" Your orders are : "+ordermsg;
   // String messageToSend1 = "PizzaHub Customer "+username+"  Order Number is : " + res[2]+"Orders : "+ordermsg+"http://kjeevansai999.ml/pizza_app/accept.php?adminusername=jeevansai&username="+inman.logged_in_user+"vs="+pta.vs+"vm="+pta.vm+"vl="+pta.vl+"nvs="+pta.nvs+"nvm="+pta.nvm+"nvl="+pta.nvl+"bs="+pta.bs+"bm="+pta.bm+"bl="+pta.bl;
    String messageToSend1 = "http://kjeevansai999.ml/pizza_app/accept.php?adminusername=jeevansai&username="+inman.logged_in_user+"&ordernumber="+res[2]+"&vs="+pta.svs+"&vm="+pta.svm+"&vl="+pta.svl+"&nvs="+pta.snvs+"&nvm="+pta.snvm+"&nvl="+pta.snvl+"&bs="+pta.sbs+"&bm="+pta.sbm+"&bl="+pta.sbl;

    order_no=res[2];
    if (res[0].equals("Order-Successful")) {

        SmsManager smsOperation = SmsManager.getDefault();
        PendingIntent sentPI;
        String sent = "SMS_SENT";
        sentPI = PendingIntent.getBroadcast(context, 0, new Intent(sent), 0);
        smsOperation.sendTextMessage(number, null, messageToSend, sentPI, null);
        smsOperation.sendTextMessage(adminno, null, messageToSend1, sentPI, null);
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