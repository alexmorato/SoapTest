package com.example.alejandromorato.soaptest.DecorAR.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alejandromorato.soaptest.DTOs.UserSimple;
import com.example.alejandromorato.soaptest.DecorAR.AsyncTask.GetUserSimpleTask;
import com.example.alejandromorato.soaptest.DecorAR.AsyncTask.SumaTask;
import com.example.alejandromorato.soaptest.DecorAR.SoapConfig;
import com.example.alejandromorato.soaptest.Helpers.EncrypterService;
import com.example.alejandromorato.soaptest.Helpers.ToastService;
import com.example.alejandromorato.soaptest.R;
import com.google.gson.Gson;

public class DecorARActity extends Activity {

    private EditText editText_suma_A;
    private EditText editText_suma_B;
    private EditText editText_Password;
    private View btnSuma;
    private View btnGetSimple;
    private View btnToMD5;

    private TextView textViewSuma;
    private TextView textViewResultGet;
    private TextView textViewResultMD5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor_ar);

        editText_suma_A = (EditText) findViewById(R.id.editTest_DecorAR_A);
        editText_suma_B = (EditText) findViewById(R.id.editTest_DecorAR_B);
        editText_Password = (EditText) findViewById(R.id.editText_DecorAR_Password);

        btnSuma = (View) findViewById(R.id.button_DecorAR_suma);
        btnGetSimple = (View) findViewById(R.id.button_DecorAR_GetSimple);
        btnToMD5 = (View) findViewById(R.id.button_DecorAR_MD5);

        btnSuma.setOnClickListener(onSumaClick());
        btnGetSimple.setOnClickListener(onGetSimpleClick());
        btnToMD5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordMD5clicked();
            }
        });

        textViewSuma = (TextView) findViewById(R.id.textView_ResultSuma);
        textViewResultGet = (TextView) findViewById(R.id.textView_resultGet);
        textViewResultMD5 = (TextView) findViewById(R.id.textView_DecorAR_ResultMd5);
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
                .execute(editText_suma_A.getText().toString().trim(), editText_suma_B.getText().toString().trim());
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

        Gson gson = new Gson();
        UserSimple userJson = gson.fromJson(result, UserSimple.class);

        textViewResultGet.setText(result);
    }

    private void PasswordMD5clicked()
    {
        ToastService.ShowMessage(this.getApplicationContext(), "yeeja");

        String md5 = EncrypterService.MD5(editText_Password.getText().toString());
        textViewResultMD5.setText(md5);
    }
}
