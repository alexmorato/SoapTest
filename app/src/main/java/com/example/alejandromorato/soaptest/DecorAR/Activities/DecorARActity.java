package com.example.alejandromorato.soaptest.DecorAR.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alejandromorato.soaptest.DTOs.UserSimple;
import com.example.alejandromorato.soaptest.DecorAR.AsyncTask.GetUserSimpleTask;
import com.example.alejandromorato.soaptest.DecorAR.AsyncTask.SumaTask;
import com.example.alejandromorato.soaptest.DecorAR.SoapConfig;
import com.example.alejandromorato.soaptest.R;
import com.google.gson.Gson;

public class DecorARActity extends Activity {

    private EditText inputA;
    private EditText inputB;
    private View btnSuma;
    private View btnGetSimple;

    private TextView textViewSuma;
    private TextView textViewResultGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor_ar);

        inputA = (EditText) findViewById(R.id.editTest_DecorAR_A);
        inputB = (EditText) findViewById(R.id.editTest_DecorAR_B);

        btnSuma = (View) findViewById(R.id.button_DecorAR_suma);
        btnGetSimple = (View) findViewById(R.id.button_DecorAR_GetSimple);

        btnSuma.setOnClickListener(onSumaClick());
        btnGetSimple.setOnClickListener(onGetSimpleClick());

        textViewSuma = (TextView) findViewById(R.id.textView_ResultSuma);
        textViewResultGet = (TextView) findViewById(R.id.textView_resultGet);
    }

    private OnClickListener onSumaClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                invokeAsyncTask_Suma(SoapConfig.SOAP_ACTION_ADD, SoapConfig.METHOD_ADD);
            }
        };
    }

    //change Fahrenheit to Celsius degree
    private OnClickListener onGetSimpleClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                invokeAsyncTask_GetUserSimple();
            }
        };
    }

    private void PruebasJSON()
    {
        UserSimple userObject = new UserSimple("Norman", "norman@futurestud.io", 26, true);

        Gson gson = new Gson();

        String userJson = gson.toJson(userObject);

        textViewResultGet.setText(userJson);
    }

    //create and execute asynctask to get response from W3school server
    private void invokeAsyncTask_Suma(String soapAction, String methodName) {
        new SumaTask(this, soapAction, methodName)
                .execute(inputA.getText().toString().trim(), inputB.getText().toString().trim());
    }

    //create and execute asynctask to get response from W3school server
    private void invokeAsyncTask_GetUserSimple() {
        new GetUserSimpleTask(this).execute();
    }

    //call back data from background thread and set to views
    public void callBackDataFromAsyncTask(String result) {
        textViewSuma.setText("Resultado " + result);
    }

    //call back data from background thread and set to views
    public void callBackDataFromAsyncTask_GetUserSimple(String result) {
        textViewResultGet.setText(result);
    }
}
