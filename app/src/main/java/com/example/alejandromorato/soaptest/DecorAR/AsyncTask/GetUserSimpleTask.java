package com.example.alejandromorato.soaptest.DecorAR.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;

import com.example.alejandromorato.soaptest.AsyncTask.WebServiceCall;
import com.example.alejandromorato.soaptest.DecorAR.Activities.DecorARActity;
import com.example.alejandromorato.soaptest.DecorAR.SoapConfig;

import org.ksoap2.serialization.SoapObject;


public class GetUserSimpleTask extends AsyncTask<String, Void, String> {

    private DecorARActity activity;

    private final static String TAG = GetUserSimpleTask.class.getSimpleName();

    public GetUserSimpleTask(DecorARActity activity) {
        this.activity = activity;
    }


    @Override
    protected String doInBackground(String... params) {
        //create a new soap request object
        SoapObject request = new SoapObject(SoapConfig.NAME_SPACE, SoapConfig.METHOD_GET_USER_SIMPLE);

        //request to server and get Soap Primitive response
        return WebServiceCall.callWSThreadSoapPrimitive(SoapConfig.URL, SoapConfig.SOAP_ACTION_GET_USER_SIMPLE, request);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result == null) {
            Log.i(TAG, "cannot get result");
        } else {
            //invoke call back method of Activity
            activity.callBackDataFromAsyncTask_GetUserSimple(result);
        }
    }
}
