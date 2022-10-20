package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class OrderAccepted extends AppCompatActivity {
    TextView back_to_home;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_accepted);
        back_to_home=findViewById(R.id.back_to_home);
        back_to_home.setOnClickListener(view -> {
            Intent intent = new Intent(OrderAccepted.this,HomeScreen.class);
            startActivity(intent);
        });
    }
}
