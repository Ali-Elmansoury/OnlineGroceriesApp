package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinegroceriesapp.R;
import com.example.onlinegroceriesapp.adapters.CategoryListAdapter;
import com.example.onlinegroceriesapp.adapters.ClickListener;
import com.example.onlinegroceriesapp.adapters.ProductsListAdapter;
import com.example.onlinegroceriesapp.adapters.RectangularListAdapter;
import com.example.onlinegroceriesapp.models.Products;
import com.example.onlinegroceriesapp.viewModel.HomeScreenViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    List<com.example.onlinegroceriesapp.models.Category> data = new ArrayList<>();
    ImageView shop,explore,cart,favorite,account,categories;
    HomeScreenViewModel model,model2,model3;
    TextView country,city;
    String c,cc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        country=findViewById(R.id.country);
        city=findViewById(R.id.area);
        c=getIntent().getStringExtra("country");
        cc=getIntent().getStringExtra("city");
        country.setText(c);
        city.setText(","+cc);
        shop=findViewById(R.id.shop);
        explore=findViewById(R.id.explore);
        cart=findViewById(R.id.cart);
        favorite=findViewById(R.id.favorite);
        account=findViewById(R.id.account);
        categories=findViewById(R.id.category_home);
        shop.setOnClickListener(view -> {
            Intent intent = new Intent(HomeScreen.this,HomeScreen.class);
            startActivity(intent);
        });
        explore.setOnClickListener(view -> {
            Intent intent = new Intent(HomeScreen.this,Search.class);
            startActivity(intent);
        });
        cart.setOnClickListener(view -> {
            Intent intent = new Intent(HomeScreen.this,MyCart.class);
            startActivity(intent);
        });
        favorite.setOnClickListener(view -> {
            Intent intent = new Intent(HomeScreen.this,Favorites.class);
            startActivity(intent);
        });
        account.setOnClickListener(view -> {
            Intent intent = new Intent(HomeScreen.this,Account.class);
            startActivity(intent);
        });
        categories.setOnClickListener(view -> {
            Intent intent = new Intent(HomeScreen.this,Explore.class);
            startActivity(intent);
        });
        model = new ViewModelProvider(this).get(HomeScreenViewModel.class);
        model.getData();
        model.listMutableLiveData.observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreen.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index) {
                        super.click(index);
                        Intent intent = new Intent(HomeScreen.this,ProductDetails.class);
                        intent.putExtra("id",index);
                        startActivity(intent);
                    }
                };
                ProductsListAdapter productsListAdapter = new ProductsListAdapter(products,listener);
                recyclerView.setAdapter(productsListAdapter);
                productsListAdapter.notifyDataSetChanged();
            }
        });

        model2 = new ViewModelProvider(this).get(HomeScreenViewModel.class);
        model2.getData();
        model2.listMutableLiveData.observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                List<Products>productsList = new ArrayList<Products>(products);
                for (int i=0;i<productsList.size();i++)
                {
                    for (int j=i+1;j<productsList.size();j++)
                    {
                        if (productsList.get(i).rating.rate<productsList.get(j).rating.rate)
                        {
                            Collections.swap(productsList,i,j);
                        }
                    }
                }
                RecyclerView recyclerView = findViewById(R.id.best_seller);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreen.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index) {
                        super.click(index);
                        Intent intent = new Intent(HomeScreen.this,ProductDetails.class);
                        intent.putExtra("id",productsList.get(index).id-1);
                        startActivity(intent);
                    }
                };
                ProductsListAdapter productsListAdapter = new ProductsListAdapter(productsList,listener);
                recyclerView.setAdapter(productsListAdapter);
                productsListAdapter.notifyDataSetChanged();
            }
        });


        model3 = new ViewModelProvider(this).get(HomeScreenViewModel.class);
        model3.getData();
        model3.listMutableLiveData.observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                List<Products> products1 = new ArrayList<Products>(products);
                Collections.reverse(products1);
                RecyclerView recyclerView = findViewById(R.id.recyclerView2);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreen.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                ClickListener listener = new ClickListener() {
                    @Override
                    public void click(int index) {
                        super.click(index);
                        Intent intent = new Intent(HomeScreen.this,ProductDetails.class);
                        intent.putExtra("id",products1.get(index).id-1);
                        startActivity(intent);
                    }
                };
                ProductsListAdapter productsListAdapter = new ProductsListAdapter(products1,listener);
                recyclerView.setAdapter(productsListAdapter);
                productsListAdapter.notifyDataSetChanged();
            }
        });


        data.add(new com.example.onlinegroceriesapp.models.Category("electronics","https://st2.depositphotos.com/4177785/9860/v/950/depositphotos_98600432-stock-illustration-consumer-electronics-icons-set.jpg"));
        data.add(new com.example.onlinegroceriesapp.models.Category("jewelery","https://png.pngtree.com/element_our/20190601/ourmid/pngtree-icon-black-and-white-jewelry-icon-image_1363455.jpg"));
        data.add(new com.example.onlinegroceriesapp.models.Category("men's clothing","https://www.seekpng.com/png/detail/789-7898151_70s-fashion-men-90s-fashion-men-png.png"));
        data.add(new com.example.onlinegroceriesapp.models.Category("women's clothing","https://p.kindpng.com/picc/s/746-7466002_womens-wear-png-transparent-png.png"));
        RecyclerView recyclerView = findViewById(R.id.categories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeScreen.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ClickListener listener = new ClickListener() {
            @Override
            public void click(int index) {
                super.click(index);
                Intent intent = new Intent(HomeScreen.this, com.example.onlinegroceriesapp.view.Category.class);
                intent.putExtra("category_type",data.get(index).category);
                startActivity(intent);
            }
        };
        RectangularListAdapter rectangularListAdapter = new RectangularListAdapter(data,listener);
        recyclerView.setAdapter(rectangularListAdapter);
        rectangularListAdapter.notifyDataSetChanged();
    }
}
