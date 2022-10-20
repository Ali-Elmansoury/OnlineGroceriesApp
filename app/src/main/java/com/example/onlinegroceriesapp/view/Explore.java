package com.example.onlinegroceriesapp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinegroceriesapp.R;
import com.example.onlinegroceriesapp.adapters.CategoryListAdapter;
import com.example.onlinegroceriesapp.adapters.ClickListener;
import com.example.onlinegroceriesapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class Explore extends AppCompatActivity {
    public List<Category> data = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);
        data.add(new Category("electronics","https://st2.depositphotos.com/4177785/9860/v/950/depositphotos_98600432-stock-illustration-consumer-electronics-icons-set.jpg"));
        data.add(new Category("jewelery","https://png.pngtree.com/element_our/20190601/ourmid/pngtree-icon-black-and-white-jewelry-icon-image_1363455.jpg"));
        data.add(new Category("men's clothing","https://www.seekpng.com/png/detail/789-7898151_70s-fashion-men-90s-fashion-men-png.png"));
        data.add(new Category("women's clothing","https://p.kindpng.com/picc/s/746-7466002_womens-wear-png-transparent-png.png"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Explore.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        ClickListener listener = new ClickListener() {
            @Override
            public void click(int index) {
                super.click(index);
                Intent intent = new Intent(Explore.this, com.example.onlinegroceriesapp.view.Category.class);
                intent.putExtra("category_type",data.get(index).category);
                startActivity(intent);
            }
        };
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(data,listener);
        recyclerView.setAdapter(categoryListAdapter);
        categoryListAdapter.notifyDataSetChanged();
    }
}
