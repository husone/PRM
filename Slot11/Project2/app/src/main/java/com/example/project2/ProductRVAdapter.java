package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRVAdapter extends
        RecyclerView.Adapter<ProductRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<Product> productModalArrayList;
    private Context context;

    // constructor
    public ProductRVAdapter(ArrayList<Product>
                                    productModalArrayList, Context context) {
        this.productModalArrayList = productModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                 parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int
            position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Product modal = productModalArrayList.get(position);
        holder.productNameTV.setText(modal.getName());

        holder.productDescriptionTV.setText(modal.getDescription());
        holder.productPriceTV.setText(String.valueOf(modal.getPrice()));
        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new
                                                   View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View v) {
                                                             // on below line we are calling an intent.
                                                               Intent i = new Intent(context, UpdateProduct.class);
                                                               i.putExtra("id", modal.getId());
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
        return productModalArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView productNameTV, productPriceTV, productDescriptionTV;

        public TextView getProductNameTV() {
            return productNameTV;
        }

        public void setProductNameTV(TextView productNameTV) {
            this.productNameTV = productNameTV;
        }

        public TextView getProductPriceTV() {
            return productPriceTV;
        }

        public void setProductPriceTV(TextView productPriceTV) {
            this.productPriceTV = productPriceTV;
        }

        public TextView getProductDescriptionTV() {
            return productDescriptionTV;
        }

        public void setProductDescriptionTV(TextView productDescriptionTV) {
            this.productDescriptionTV = productDescriptionTV;
        }

        public ViewHolder(@NonNull View view) {
            super(view);
            this.productNameTV = itemView.findViewById(R.id.idTVProductName);
            this.productPriceTV = itemView.findViewById(R.id.idTVProductPrice);
            this.productDescriptionTV = itemView.findViewById(R.id.idTVProductDescription);
        }
    }
}