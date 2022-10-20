package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class Filter extends AppCompatActivity {
    Button apply_filter;
    ImageView exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
        apply_filter=findViewById(R.id.apply_filter);
        exit=findViewById(R.id.exit);
        apply_filter.setOnClickListener(view -> {
            Intent intent = new Intent(Filter.this, Category.class);
            startActivity(intent);
        });
        exit.setOnClickListener(view -> {
            finish();
        });
    }
}
