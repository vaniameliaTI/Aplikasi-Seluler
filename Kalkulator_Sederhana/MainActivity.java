package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private double operand1 = 0;
    private String operator = "";
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Angka
        setNumberButton(R.id.btn0, "0");
        setNumberButton(R.id.btn1, "1");
        setNumberButton(R.id.btn2, "2");
        setNumberButton(R.id.btn3, "3");
        setNumberButton(R.id.btn4, "4");
        setNumberButton(R.id.btn5, "5");
        setNumberButton(R.id.btn6, "6");
        setNumberButton(R.id.btn7, "7");
        setNumberButton(R.id.btn8, "8");
        setNumberButton(R.id.btn9, "9");

        // Operator
        setOperatorButton(R.id.btnAdd, "+");
        setOperatorButton(R.id.btnSubtract, "-");
        setOperatorButton(R.id.btnMultiply, "*");
        setOperatorButton(R.id.btnDivide, "/");

        // Sama dengan
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());

        // Clear
        findViewById(R.id.btnClear).setOnClickListener(v -> clear());
    }

    private void setNumberButton(int id, String number) {
        Button btn = findViewById(id);
        btn.setOnClickListener(v -> {
            if (isNewInput) {
                currentInput = number;
                isNewInput = false;
            } else {
                currentInput += number;
            }
            resultTextView.setText(currentInput);
        });
    }

    private void setOperatorButton(int id, String op) {
        Button btn = findViewById(id);
        btn.setOnClickListener(v -> {
            try {
                operand1 = Double.parseDouble(currentInput);
            } catch (NumberFormatException e) {
                operand1 = 0;
            }
            operator = op;
            isNewInput = true;
        });
    }

    private void calculateResult() {
        try {
            double operand2 = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+": result = operand1 + operand2; break;
                case "-": result = operand1 - operand2; break;
                case "*": result = operand1 * operand2; break;
                case "/": result = operand2 != 0 ? operand1 / operand2 : 0; break;
            }

            resultTextView.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            isNewInput = true;

        } catch (NumberFormatException e) {
            resultTextView.setText("Error");
        }
    }

    private void clear() {
        currentInput = "";
        operand1 = 0;
        operator = "";
        isNewInput = true;
        resultTextView.setText("0");
    }
}
