package com.example.alejandromorato.soaptest.DecorAR.AsyncTask;

/**
 * Created by alejandro.morato on 26/01/2017.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.example.alejandromorato.soaptest.AsyncTask.WebServiceCall;
import com.example.alejandromorato.soaptest.DecorAR.Activities.DecorARActity;
import com.example.alejandromorato.soaptest.DecorAR.SoapConfig;

import org.ksoap2.serialization.SoapObject;


public class SumaTask extends AsyncTask<String, Void, String> {

    private DecorARActity activity;
    private String soapAction;
    private String methodName;

    private final static String TAG = SumaTask.class.getSimpleName();

    public SumaTask(DecorARActity activity, String soapAction, String methodName) {
        this.activity = activity;
        this.methodName = methodName;
        this.soapAction = soapAction;
    }


    @Override
    protected String doInBackground(String... params) {
        //create a new soap request object
        SoapObject request = new SoapObject(SoapConfig.NAME_SPACE, methodName);
        //add properties for soap object
        request.addProperty(SoapConfig.METHOD_ADD_PARAM_A, params[0]);
        request.addProperty(SoapConfig.METHOD_ADD_PARAM_B, params[1]);

        //request to server and get Soap Primitive response
        return WebServiceCall.callWSThreadSoapPrimitive(SoapConfig.URL, soapAction, request);
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
