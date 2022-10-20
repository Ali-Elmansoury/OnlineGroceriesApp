package com.example.onlinegroceriesapp.network;

import com.example.onlinegroceriesapp.models.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsApi {
    String BASE_URL = "https://fakestoreapi.com/";

    @GET("products")
    Call<List<Products>> getProducts();

    @GET("products/category/jewelery")
    Call<List<Products>> getJewelery();

    @GET("products/category/electronics")
    Call<List<Products>> getElectronics();

    @GET("products/category/men's clothing")
    Call<List<Products>> getMen();

    @GET("products/category/women's clothing")
    Call<List<Products>> getWomen();
}
