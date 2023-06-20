package com.example.project1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        this.productNameTV =  itemView.findViewById(R.id.idTVProductName);
        this.productPriceTV = itemView.findViewById(R.id.idTVProductPrice);
        this.productDescriptionTV = itemView.findViewById(R.id.idTVProductDescription);
    }
}
