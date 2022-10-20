package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class OnBoarding extends AppCompatActivity {
    Button getStarted;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);
        getStarted = findViewById(R.id.getStarted);
        getStarted.setOnClickListener(view -> {
            Intent intent = new Intent(this,SignIn.class);
            startActivity(intent);
        });
    }
}
