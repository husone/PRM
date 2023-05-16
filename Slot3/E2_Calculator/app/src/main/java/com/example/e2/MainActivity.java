package com.example.e2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText num1;
    private EditText num2;

    private TextView result;

    private Double a;
    private Double b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
    }

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

    public void onAdd(View view) {
        if (getNum()) {
            result.setText("Result: " + String.valueOf(a + b));
        }
    }

    public void onSub(View view) {
        if (getNum()) {
            result.setText("Result: " + String.valueOf(a - b));
        }
    }

    public void onMul(View view) {
        if (getNum()) {
            result.setText("Result: " + String.valueOf(a * b));
        }
    }

    public void onDiv(View view) {
        if (getNum()) {
            if (b == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            } else
                result.setText("Result: " + String.valueOf(a / b));
        }
    }
}