package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinegroceriesapp.R;

public class Search extends AppCompatActivity {
    ImageView shop,explore,cart,favorite,account,small_cart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        shop=findViewById(R.id.shop);
        explore=findViewById(R.id.explore);
        cart=findViewById(R.id.cart);
        favorite=findViewById(R.id.favorite);
        account=findViewById(R.id.account);
        small_cart=findViewById(R.id.small_cart);
        shop.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this,HomeScreen.class);
            startActivity(intent);
        });
        explore.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this,Search.class);
            startActivity(intent);
        });
        cart.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this,MyCart.class);
            startActivity(intent);
        });
        small_cart.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this,MyCart.class);
            startActivity(intent);
        });
        favorite.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this,Favorites.class);
            startActivity(intent);
        });
        account.setOnClickListener(view -> {
            Intent intent = new Intent(Search.this,Account.class);
            startActivity(intent);
        });
    }
}
