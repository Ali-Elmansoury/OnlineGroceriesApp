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
import com.example.onlinegroceriesapp.adapters.CartListAdapter;
import com.example.onlinegroceriesapp.adapters.FavoriteListAdapter;
import com.example.onlinegroceriesapp.models.Cart;
import com.example.onlinegroceriesapp.models.Favorite;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {
    ImageView shop,explore,cart,favorite,account;
    Button checkout;
    static List<Cart> data = new ArrayList<>();
    String title,image,quantity;
    Double price;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cart);
        Intent intent1 = getIntent();
        title=intent1.getStringExtra("title");
        image=intent1.getStringExtra("image");
        price=intent1.getDoubleExtra("price",0);
        quantity=intent1.getStringExtra("quantity");
        shop=findViewById(R.id.shop);
        explore=findViewById(R.id.explore);
        cart=findViewById(R.id.cart);
        favorite=findViewById(R.id.favorite);
        account=findViewById(R.id.account);
        checkout=findViewById(R.id.go_to_checkout);
        shop.setOnClickListener(view -> {
            Intent intent = new Intent(MyCart.this,HomeScreen.class);
            startActivity(intent);
        });
        explore.setOnClickListener(view -> {
            Intent intent = new Intent(MyCart.this,Search.class);
            startActivity(intent);
        });
        cart.setOnClickListener(view -> {
            Intent intent = new Intent(MyCart.this,MyCart.class);
            startActivity(intent);
        });
        favorite.setOnClickListener(view -> {
            Intent intent = new Intent(MyCart.this,Favorites.class);
            startActivity(intent);
        });
        account.setOnClickListener(view -> {
            Intent intent = new Intent(MyCart.this,Account.class);
            startActivity(intent);
        });
        checkout.setOnClickListener(view -> {
            Intent intent = new Intent(MyCart.this,Checkout.class);
            startActivity(intent);
        });
        data.add(new Cart(title,image,price,quantity));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyCart.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        CartListAdapter cartListAdapter = new CartListAdapter(data);
        recyclerView.setAdapter(cartListAdapter);
        cartListAdapter.notifyDataSetChanged();
    }
}
