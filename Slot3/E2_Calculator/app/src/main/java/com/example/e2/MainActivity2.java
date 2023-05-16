package com.example.e2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText num1;
    private EditText num2;
    private TextView result;
    private Double a;
    private Double b;
    private Button sub, add, mul, div;

    private boolean getNum() {
        try {
            a = Double.parseDouble(num1.getText().toString());
            b = Double.parseDouble(num2.getText().toString());
            return true;
        } catch (Exception e) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        sub = findViewById(R.id.sub);
        add = findViewById(R.id.add);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNum()) {
                    result.setText("Result: " + String.valueOf(a - b));
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNum()) {
                    result.setText("Result: " + String.valueOf(a + b));
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNum()) {
                    result.setText("Result: " + String.valueOf(a * b));
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getNum()) {
                    result.setText("Result: " + String.valueOf(a / b));
                }
            }
        });
    }
}