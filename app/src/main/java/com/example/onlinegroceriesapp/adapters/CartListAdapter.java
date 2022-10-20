package com.example.onlinegroceriesapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onlinegroceriesapp.R;
import com.example.onlinegroceriesapp.models.Cart;
import com.example.onlinegroceriesapp.models.Favorite;

import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder>{
    public List<Cart> data;

    public CartListAdapter(List<Cart> data) {
        this.data=data;
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cart_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.name.setText(data.get(position).title);
        holder.price.setText(data.get(position).price +"$");
        holder.quantity.setText(data.get(position).quantity);
        Glide.with(holder.photo).load(data.get(position).image).into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,price,quantity;
        public ImageView photo;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_detail_price);
            photo = itemView.findViewById(R.id.product_image);
            quantity = itemView.findViewById(R.id.quantity);
            view = itemView;
        }
    }
}
