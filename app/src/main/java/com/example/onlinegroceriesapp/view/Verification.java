package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class Verification extends AppCompatActivity {
    ImageView next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification);
        next = findViewById(R.id.next);
        next.setOnClickListener(view -> {
            Intent intent = new Intent(this,SignUp.class);
            startActivity(intent);
        });
    }
}
