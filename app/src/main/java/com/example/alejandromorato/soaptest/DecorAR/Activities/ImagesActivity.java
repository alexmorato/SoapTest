package com.example.alejandromorato.soaptest.DecorAR.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.alejandromorato.soaptest.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImagesActivity extends AppCompatActivity {

    ImageView image01;
    ProgressBar progessBar01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        image01 = (ImageView)findViewById(R.id.imageView_Images_01);
        progessBar01 = (ProgressBar)findViewById(R.id.Images_progressBar_01);

        new FetchImageTask() {
            @Override
            protected void onPostExecute(Bitmap result) {
                if (result != null) {
                    progessBar01.setVisibility(View.GONE);
                    image01.setImageBitmap(result);
                }
            }
        }.execute("http://192.168.2.138/DecorAR/Captura.PNG", "");
    }

    private class FetchImageTask extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... arg0) {
            Bitmap b = null;
            try {
                b = BitmapFactory.decodeStream((InputStream) new URL(arg0[0]).getContent());
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return b;
        }
    }

}


