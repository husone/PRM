package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProduct extends AppCompatActivity {

    ProductRepository res;
    private EditText productNameEdt, productPriceEdt, productDescriptionEdt;
    private Button updateProductBtn, deleteProductBtn;
    String productName, productDesc;
    Integer productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        productNameEdt = findViewById(R.id.idEdtProductName);
        productDescriptionEdt = findViewById(R.id.idEdtProductDescription);
        productPriceEdt = findViewById(R.id.idEdtProductPrice);
        updateProductBtn = findViewById(R.id.idBtnUpdateProduct);
        deleteProductBtn = findViewById(R.id.idBtnDeleteProduct);
        productName = getIntent().getStringExtra("name");
        productDesc = getIntent().getStringExtra("description");
        productPrice = getIntent().getIntExtra("price", 0);
        productNameEdt.setText(productName);
        productDescriptionEdt.setText(productDesc);
        productPriceEdt.setText(String.valueOf(productPrice));
        res = new ProductRepository(getApplication());
        //Adding on click listener to update product button
        updateProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling a method to update our product
                Product product = new Product(productNameEdt.getText().toString(), productDescriptionEdt.getText().toString(), Integer.parseInt(productPriceEdt.getText().toString()));
                product.setId(getIntent().getIntExtra("id", 0));
                res.update(product);
                Toast.makeText(UpdateProduct.this, "Product  Updated.. ", Toast.LENGTH_SHORT).show();
                //Launching our main activity.
                Intent i = new Intent(UpdateProduct.this, MainActivity.class);
                startActivity(i);
            }
        });

        deleteProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling a method to delete our product.
                Product product = new Product(productNameEdt.getText().toString(), productDescriptionEdt.getText().toString(), Integer.parseInt(productPriceEdt.getText().toString()));
                product.setId(getIntent().getIntExtra("id", 0));
                res.delete(product);
                Toast.makeText(UpdateProduct.this, "Deleted the  product", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateProduct.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}