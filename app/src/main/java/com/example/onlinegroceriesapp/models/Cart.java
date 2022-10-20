package com.example.onlinegroceriesapp.models;

public class Cart {
    public String title;
    public String image;
    public double price;
    public String quantity;

    public Cart(String title, String image, double price, String quantity){
        this.image=image;
        this.title=title;
        this.price=price;
        this.quantity=quantity;
    }
}
