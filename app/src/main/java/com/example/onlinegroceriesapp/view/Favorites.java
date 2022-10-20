package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinegroceriesapp.R;
import com.example.onlinegroceriesapp.adapters.FavoriteListAdapter;
import com.example.onlinegroceriesapp.models.Favorite;

import java.util.ArrayList;
import java.util.List;

public class Favorites extends AppCompatActivity {
    ImageView shop,explore,cart,favorite,account;
    Button add_all_to_cart;
    static List<Favorite> data = new ArrayList<>();
    String title,image;
    Double price;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);
        Intent intent1 = getIntent();
        title=intent1.getStringExtra("title");
        image=intent1.getStringExtra("image");
        price=intent1.getDoubleExtra("price",0);
        add_all_to_cart=findViewById(R.id.add_all_to_cart);
        shop=findViewById(R.id.shop);
        explore=findViewById(R.id.explore);
        cart=findViewById(R.id.cart);
        favorite=findViewById(R.id.favorite);
        account=findViewById(R.id.account);
        shop.setOnClickListener(view -> {
            Intent intent = new Intent(Favorites.this,HomeScreen.class);
            startActivity(intent);
        });
        explore.setOnClickListener(view -> {
            Intent intent = new Intent(Favorites.this,Search.class);
            startActivity(intent);
        });
        cart.setOnClickListener(view -> {
            Intent intent = new Intent(Favorites.this,MyCart.class);
            startActivity(intent);
        });
        favorite.setOnClickListener(view -> {
            Intent intent = new Intent(Favorites.this,Favorites.class);
            startActivity(intent);
        });
        account.setOnClickListener(view -> {
            Intent intent = new Intent(Favorites.this,Account.class);
            startActivity(intent);
        });
        add_all_to_cart.setOnClickListener(view -> {
            Intent intent = new Intent(Favorites.this,MyCart.class);
            startActivity(intent);
        });
        data.add(new Favorite(title,image,price));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Favorites.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        FavoriteListAdapter favoriteListAdapter = new FavoriteListAdapter(data);
        recyclerView.setAdapter(favoriteListAdapter);
        favoriteListAdapter.notifyDataSetChanged();
    }
}
