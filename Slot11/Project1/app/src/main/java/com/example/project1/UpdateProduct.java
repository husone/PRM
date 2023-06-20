package com.example.project1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProduct extends AppCompatActivity {
    private EditText productNameEdt,  productPriceEdt, productDescriptionEdt;
    private Button updateProductBtn, deleteProductBtn;
    private DBHandler dbHandler;
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
        //Initialing our dbhandler class.
        dbHandler = new DBHandler(UpdateProduct.this);
        //Getting data which we passed in our adapter class
        productName = getIntent().getStringExtra("name");
        productDesc = getIntent().getStringExtra("description");
        productPrice = getIntent().getIntExtra("price", 0);
        //Setting data to edit text of our update activity
        productNameEdt.setText(productName);
        productDescriptionEdt.setText(productDesc);
        productPriceEdt.setText(String.valueOf(productPrice));
        //Adding on click listener to update product button
        updateProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling a method to update our product
                dbHandler.updateProduct(productName, productNameEdt.getText().toString(), productDescriptionEdt.getText().toString(), Integer.parseInt(productPriceEdt.getText().toString()));
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
                dbHandler.deleteProduct(productName);
                Toast.makeText(UpdateProduct.this, "Deleted the  product", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateProduct.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}