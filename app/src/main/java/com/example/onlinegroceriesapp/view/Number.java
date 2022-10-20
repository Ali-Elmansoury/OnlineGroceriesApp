package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class Number extends AppCompatActivity {
    ImageView next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number);
        next = findViewById(R.id.next);
        next.setOnClickListener(view -> {
            Intent intent = new Intent(this,Verification.class);
            startActivity(intent);
        });
    }
}
