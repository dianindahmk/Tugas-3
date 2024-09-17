package com.example.kalkulatortugas3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double firstValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setNumberButtonClickListener(R.id.button0, "0");
        setNumberButtonClickListener(R.id.button1, "1");
        setNumberButtonClickListener(R.id.button2, "2");
        setNumberButtonClickListener(R.id.button3, "3");
        setNumberButtonClickListener(R.id.button4, "4");
        setNumberButtonClickListener(R.id.button5, "5");
        setNumberButtonClickListener(R.id.button6, "6");
        setNumberButtonClickListener(R.id.button7, "7");
        setNumberButtonClickListener(R.id.button8, "8");
        setNumberButtonClickListener(R.id.button9, "9");

        setOperatorButtonClickListener(R.id.buttonAdd, "+");
        setOperatorButtonClickListener(R.id.buttonSubtract, "-");
        setOperatorButtonClickListener(R.id.buttonMultiply, "*");
        setOperatorButtonClickListener(R.id.buttonDivide, "/");

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void setNumberButtonClickListener(int buttonId, final String value) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += value;
                display.setText(currentInput);
            }
        });
    }

    private void setOperatorButtonClickListener(int buttonId, final String op) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentInput.equals("")) {
                    firstValue = Double.parseDouble(currentInput);
                    operator = op;
                    currentInput = "";
                    display.setText("");
                }
            }
        });
    }

    private void calculate() {
        if (!currentInput.equals("") && !operator.equals("")) {
            double secondValue = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "*":
                    result = firstValue * secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result = firstValue / secondValue;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            currentInput = "";
            operator = "";
        }
    }
}
