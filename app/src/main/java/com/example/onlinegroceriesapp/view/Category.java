package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.onlinegroceriesapp.adapters.CategoryItemListAdapter;
import com.example.onlinegroceriesapp.adapters.ClickListener;
import com.example.onlinegroceriesapp.adapters.ProductsListAdapter;
import com.example.onlinegroceriesapp.models.Products;
import com.example.onlinegroceriesapp.viewModel.CategoryViewModel;
import com.example.onlinegroceriesapp.viewModel.HomeScreenViewModel;

import java.util.List;

public class Category extends AppCompatActivity {
    ImageView filter,back,item_add;
    TextView category;
    String cat;
    CategoryViewModel model,model1,model2,model3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        filter=findViewById(R.id.filter);
        back=findViewById(R.id.back);
        category=findViewById(R.id.category);
        cat=getIntent().getStringExtra("category_type");
        category.setText(cat);
        filter.setOnClickListener(view -> {
            Intent intent = new Intent(Category.this,Filter.class);
            startActivity(intent);
        });
        back.setOnClickListener(view -> {
            finish();
        });
        switch (cat)
        {
            case "jewelery":
                model = new ViewModelProvider(this).get(CategoryViewModel.class);
                model.getData();
                model.listMutableLiveData.observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(Category.this,2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        ClickListener listener = new ClickListener() {
                            @Override
                            public void click(int index) {
                                super.click(index);
                                Intent intent = new Intent(Category.this,ProductDetails.class);
                                intent.putExtra("id",products.get(index).id-1);
                                startActivity(intent);
                            }
                        };
                        CategoryItemListAdapter categoryItemListAdapter = new CategoryItemListAdapter(products,listener);
                        recyclerView.setAdapter(categoryItemListAdapter);
                        categoryItemListAdapter.notifyDataSetChanged();
                    }
                });
                break;
            case "electronics":
                model1 = new ViewModelProvider(this).get(CategoryViewModel.class);
                model1.getData1();
                model1.listMutableLiveData1.observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(Category.this,2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        ClickListener listener = new ClickListener() {
                            @Override
                            public void click(int index) {
                                super.click(index);
                                Intent intent = new Intent(Category.this,ProductDetails.class);
                                intent.putExtra("id",products.get(index).id-1);
                                startActivity(intent);
                            }
                        };
                        CategoryItemListAdapter categoryItemListAdapter = new CategoryItemListAdapter(products,listener);
                        recyclerView.setAdapter(categoryItemListAdapter);
                        categoryItemListAdapter.notifyDataSetChanged();
                    }
                });
                break;
            case "men's clothing":
                model2 = new ViewModelProvider(this).get(CategoryViewModel.class);
                model2.getData2();
                model2.listMutableLiveData2.observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(Category.this,2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        ClickListener listener = new ClickListener() {
                            @Override
                            public void click(int index) {
                                super.click(index);
                                Intent intent = new Intent(Category.this,ProductDetails.class);
                                intent.putExtra("id",products.get(index).id-1);
                                startActivity(intent);
                            }
                        };
                        CategoryItemListAdapter categoryItemListAdapter = new CategoryItemListAdapter(products,listener);
                        recyclerView.setAdapter(categoryItemListAdapter);
                        categoryItemListAdapter.notifyDataSetChanged();
                    }
                });
                break;
            case "women's clothing":
                model3 = new ViewModelProvider(this).get(CategoryViewModel.class);
                model3.getData3();
                model3.listMutableLiveData3.observe(this, new Observer<List<Products>>() {
                    @Override
                    public void onChanged(List<Products> products) {
                        RecyclerView recyclerView = findViewById(R.id.recyclerView);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(Category.this,2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        ClickListener listener = new ClickListener() {
                            @Override
                            public void click(int index) {
                                super.click(index);
                                Intent intent = new Intent(Category.this,ProductDetails.class);
                                intent.putExtra("id",products.get(index).id-1);
                                startActivity(intent);
                            }
                        };
                        CategoryItemListAdapter categoryItemListAdapter = new CategoryItemListAdapter(products,listener);
                        recyclerView.setAdapter(categoryItemListAdapter);
                        categoryItemListAdapter.notifyDataSetChanged();
                    }
                });
                break;
        }
    }
}
