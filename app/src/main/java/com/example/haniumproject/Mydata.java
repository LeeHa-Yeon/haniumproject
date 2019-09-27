package com.example.haniumproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Mydata extends AppCompatActivity {

    String testurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);

        testurl = "http://54.180.42.62//insert0.php";
        URLConnector task = new URLConnector(testurl);

        task.start();

        try{
            //쓰레드가 끝나기 전까지 join에 머무르도록 한다.
            task.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = task.getResult();
        String[] array = result.split(",");





    }
}
