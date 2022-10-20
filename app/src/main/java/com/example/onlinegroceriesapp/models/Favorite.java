package com.example.onlinegroceriesapp.models;

public class Favorite {
    public String title;
    public String image;
    public double price;

    public Favorite(String title, String image, double price){
        this.image=image;
        this.title=title;
        this.price=price;
    }
}
