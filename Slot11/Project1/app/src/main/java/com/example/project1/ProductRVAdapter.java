package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProductRVAdapter extends RecyclerView.Adapter<ViewHolder> {
    // variable for our array list and context
    private ArrayList<ProductModal> productModalArrayList;
    private Context context;

    // constructor
    public ProductRVAdapter(ArrayList<ProductModal> courseModalArrayList, Context context) {
        this.productModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModal modal = productModalArrayList.get(position);
        holder.getProductNameTV().setText(modal.getName());

        holder.getProductDescriptionTV().setText(modal.getDescription());

        holder.getProductPriceTV().setText(String.valueOf(modal.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateProduct.class);
                // below we are passing all our values.
                i.putExtra("name", modal.getName());
                i.putExtra("description", modal.getDescription());
                i.putExtra("price", modal.getPrice());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        if (productModalArrayList == null) {
            return 0;
        }
        return productModalArrayList.size();
    }
}

