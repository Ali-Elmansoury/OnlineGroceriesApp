package com.example.onlinegroceriesapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.onlinegroceriesapp.R;
import com.example.onlinegroceriesapp.util.Utils;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(() -> {
            boolean isloggedin = Utils.readData(getApplicationContext(),"IS_LOGGED_IN",false);
            if (isloggedin)
            {
                Intent i = new Intent(Splash.this, SelectLocation.class);
                startActivity(i);
            }
            else {
                Intent i = new Intent(Splash.this, OnBoarding.class);
                startActivity(i);
            }
            finish();
        }, 2000);

    }
}