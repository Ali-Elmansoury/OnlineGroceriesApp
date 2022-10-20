package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.onlinegroceriesapp.R;
import com.example.onlinegroceriesapp.models.Products;
import com.example.onlinegroceriesapp.viewModel.ProductDetailsViewModel;

import java.util.List;

public class ProductDetails extends AppCompatActivity {
    Button add_to_basket;
    ImageView back,product_image,plus,minus,fav;
    TextView name,price,description,stock,quantity,rate;
    ProductDetailsViewModel model;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        add_to_basket=findViewById(R.id.add_to_basket);
        product_image=findViewById(R.id.product_detail_image);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        name=findViewById(R.id.product_detail_name);
        price=findViewById(R.id.product_detail_price);
        description=findViewById(R.id.description);
        stock=findViewById(R.id.stock);
        rate=findViewById(R.id.rate);
        quantity=findViewById(R.id.product_quantity);
        back=findViewById(R.id.back);
        fav=findViewById(R.id.fav);
        Intent intenty = getIntent();
        int id = intenty.getIntExtra("id",0);
        back.setOnClickListener(view -> {
            finish();
        });
        model = new ViewModelProvider(this).get(ProductDetailsViewModel.class);
        model.getData();
        model.listMutableLiveData.observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                final int[] counter = {Integer.parseInt(quantity.getText().toString())};
                Glide.with(ProductDetails.this).load(products.get(id).image).into(product_image);
                name.setText(products.get(id).title);
                price.setText("$"+String.valueOf(products.get(id).price));
                description.setText(products.get(id).description);
                stock.setText("Stock: "+products.get(id).rating.count+" Pieces");
                rate.setText("   "+String.valueOf(products.get(id).rating.rate));
                plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (counter[0] < products.get(id-1).rating.count) {
                            ++counter[0];
                            quantity.setText(String.valueOf(counter[0]));
                        }
                    }
                });
                minus.setOnClickListener(view -> {
                    --counter[0];
                    if (counter[0] < 0){
                        counter[0] = 0;
                    }else {
                        quantity.setText(String.valueOf(counter[0]));
                    }
                });
                fav.setOnClickListener(view -> {
                    Intent intent = new Intent(ProductDetails.this,Favorites.class);
                    intent.putExtra("title",products.get(id).title);
                    intent.putExtra("image",products.get(id).image);
                    intent.putExtra("price",products.get(id).price);
                    startActivity(intent);
                });
                add_to_basket.setOnClickListener(view -> {
                    Intent intent = new Intent(ProductDetails.this,MyCart.class);
                    intent.putExtra("title",products.get(id).title);
                    intent.putExtra("image",products.get(id).image);
                    intent.putExtra("price",products.get(id).price);
                    intent.putExtra("quantity", String.valueOf(quantity));
                    startActivity(intent);
                });
            }
        });

    }
}
