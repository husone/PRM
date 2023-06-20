package com.example.project1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText productNameEdt, productPriceEdt, productDescriptionEdt;
    private Button addCourseBtn, readProductBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing all our variables
        productNameEdt = findViewById(R.id.idEdtProductName);
        productPriceEdt = findViewById(R.id.idEdtProductPrice);
        productDescriptionEdt = findViewById(R.id.idEdtProductDescription);
        addCourseBtn = findViewById(R.id.idBtnAddProduct);
        readProductBtn = findViewById(R.id.idBtnReadProduct);
        dbHandler = new DBHandler(MainActivity.this);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String productName = productNameEdt.getText().toString();
                String productDes = productDescriptionEdt.getText().toString();
                Integer productPrice = 0;
                try {
                    productPrice = Integer.valueOf(productPriceEdt.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter number for price", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (productName.isEmpty() && productDes.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewProduct(productName, productDes, productPrice);
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                productNameEdt.setText("");
                productDescriptionEdt.setText("");
                productPriceEdt.setText("");
            }
        });

        readProductBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Opening ViewCourses activity via a intent
                Intent i = new Intent(MainActivity.this, ViewProducts.class);
                startActivity(i);
            }
        });
    }
}

