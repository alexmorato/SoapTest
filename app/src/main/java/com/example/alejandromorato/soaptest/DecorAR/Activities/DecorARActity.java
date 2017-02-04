package com.example.alejandromorato.soaptest.DecorAR.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alejandromorato.soaptest.DecorAR.AsyncTask.SumaTask;
import com.example.alejandromorato.soaptest.DecorAR.SoapConfig;
import com.example.alejandromorato.soaptest.R;
import com.example.alejandromorato.soaptest.ServiceUtils.ConstantString;

public class DecorARActity extends Activity {

    private EditText inputA;
    private EditText inputB;
    private View btnSuma;
    private View btnHello;

    private TextView textViewSuma;
    private TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor_ar);

        inputA = (EditText) findViewById(R.id.editTest_DecorAR_A);
        inputB = (EditText) findViewById(R.id.editTest_DecorAR_B);

        btnSuma = (View) findViewById(R.id.button_DecorAR_suma);
        btnHello = (View) findViewById(R.id.button_DecorAR_Hello);

        btnSuma.setOnClickListener(onSumaClick());
        btnHello.setOnClickListener(onHelloClick());

        textViewSuma = (TextView) findViewById(R.id.textView_ResultSuma);
        textViewHello = (TextView) findViewById(R.id.textView_resultHello);
    }

    private OnClickListener onSumaClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                invokeAsyncTask(SoapConfig.SOAP_ACTION_ADD, SoapConfig.METHOD_ADD);
            }
        };
    }

    //change Fahrenheit to Celsius degree
    private OnClickListener onHelloClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                invokeAsyncTask(SoapConfig.SOAP_ACTION_ADD, SoapConfig.METHOD_ADD);
            }
        };
    }

    //create and execute asynctask to get response from W3school server
    private void invokeAsyncTask(String soapAction, String methodName) {
        new SumaTask(this, soapAction, methodName)
                .execute(inputA.getText().toString().trim(), inputB.getText().toString().trim());
    }

    //call back data from background thread and set to views
    public void callBackDataFromAsyncTask(String result) {
        textViewSuma.setText("Resultado " + result);
    }
}
