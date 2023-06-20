package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText productNameEdt, productPriceEdt, productDescriptionEdt;
    private Button addProductBtn, readProductBtn;
    ProductRepository res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productNameEdt = findViewById(R.id.idEdtProductName);
        productPriceEdt = findViewById(R.id.idEdtProductPrice);
        productDescriptionEdt = findViewById(R.id.idEdtProductDescription);
        addProductBtn = findViewById(R.id.idBtnAddProduct);
        readProductBtn = findViewById(R.id.idBtnReadProduct);
        res = new ProductRepository(getApplication());
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addCourse();
            }
        });
        readProductBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Opening ViewCourses activity via a intent
                Intent i = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(i);
            }
        });
    }

    public void addCourse() {
        //Getting data from all edit text fields

        String productName = productNameEdt.getText().toString();
        String productDes = productDescriptionEdt.getText().toString();
        Integer productPrice = 0;
        try {
            productPrice = Integer.valueOf(productPriceEdt.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Please enter number for price", Toast.LENGTH_SHORT).show();
            return;
        }
        Product product = new Product(productName, productDes, productPrice);
        //Adding a new course to sqlite data and pass all our values to it.
        res.insert(product);
        //After adding the data we are displaying a toast message
        Toast.makeText(MainActivity.this, "Product has been added.", Toast.LENGTH_SHORT).show();
        productNameEdt.setText("");
        productDescriptionEdt.setText("");
        productPriceEdt.setText("");
    }
}