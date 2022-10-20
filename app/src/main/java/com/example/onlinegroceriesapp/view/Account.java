package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class Account extends AppCompatActivity {
    ImageView shop,explore,cart,favorite,account;
    Button log_out;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        shop=findViewById(R.id.shop);
        explore=findViewById(R.id.explore);
        cart=findViewById(R.id.cart);
        favorite=findViewById(R.id.favorite);
        account=findViewById(R.id.account);
        log_out=findViewById(R.id.log_out);
        shop.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this,HomeScreen.class);
            startActivity(intent);
        });
        explore.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this,Search.class);
            startActivity(intent);
        });
        cart.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this,MyCart.class);
            startActivity(intent);
        });
        favorite.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this,Favorites.class);
            startActivity(intent);
        });
        account.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this,Account.class);
            startActivity(intent);
        });
        log_out.setOnClickListener(view -> {
            Intent intent = new Intent(Account.this,LogIn.class);
            startActivity(intent);
        });
    }
}
