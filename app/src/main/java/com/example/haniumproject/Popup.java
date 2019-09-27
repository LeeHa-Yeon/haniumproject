package com.example.haniumproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.Button;
import android.widget.PopupWindow;

public class Popup extends Activity {

    private PopupWindow pwindo;
    private int mWidthPixels, mHeightPixels;
    Button btnClosePopup;
    Button btnmemo;
    Button btnenroll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        btnClosePopup = (Button) findViewById(R.id.close);
        btnmemo = (Button) findViewById(R.id.memo);
        btnenroll = (Button) findViewById(R.id.enrollproduct);

        btnClosePopup.setOnClickListener(cancel_button_click_listener);
        btnenroll.setOnClickListener(btn_click_enroll);

    }
    public View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };


    public View.OnClickListener btn_click_enroll = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent myIntent=new Intent(getApplicationContext(),EnrollStuffActivity.class);
            startActivity(myIntent);
        }
    };

}
