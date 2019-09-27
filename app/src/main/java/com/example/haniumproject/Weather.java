package com.example.haniumproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.ExecutionException;

public class Weather extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        String result = "값이 없음";
        String textresult = "값이 없음";
        final String result1;

        TextView textview = (TextView)findViewById(R.id.weathertext);
        final ImageView imageview = (ImageView)findViewById(R.id.imageviews);


        try{
            result = new Weatherget().execute().get();
            textresult = new Weatherget2().execute().get();
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        textview.setText(textresult);
        result1 = result;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url = new URL("http://openweathermap.org/img/w/" + result1 + ".png");
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageview.setImageBitmap(bm);
                        }
                    });
                    imageview.setImageBitmap(bm);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
