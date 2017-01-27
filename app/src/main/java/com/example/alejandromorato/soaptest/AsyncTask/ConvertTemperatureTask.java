package com.example.alejandromorato.soaptest.AsyncTask;

/**
 * Created by alejandro.morato on 26/01/2017.
 */

import org.ksoap2.serialization.SoapObject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.alejandromorato.soaptest.MainActivity;
import com.example.alejandromorato.soaptest.ServiceUtils.ConstantString;


public class ConvertTemperatureTask extends AsyncTask<String, Void, String> {

    private MainActivity activity;
    private String soapAction;
    private String methodName;
    private String paramsName;

    private final static String TAG = ConvertTemperatureTask.class.getSimpleName();

    public ConvertTemperatureTask(MainActivity activity, String soapAction, String methodName,
                                  String paramsName) {
        this.activity = activity;
        this.methodName = methodName;
        this.soapAction = soapAction;
        this.paramsName = paramsName;
    }


    @Override
    protected String doInBackground(String... params) {
        //create a new soap request object
        SoapObject request = new SoapObject(ConstantString.NAME_SPACE, methodName);
        //add properties for soap object
        request.addProperty(paramsName, params[0]);

        //request to server and get Soap Primitive response
        return WebServiceCall.callWSThreadSoapPrimitive(ConstantString.URL, soapAction, request);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result == null) {
            Log.i(TAG, "cannot get result");
        } else {
            //invoke call back method of Activity
            activity.callBackDataFromAsyncTask(result);
        }
    }
}
