package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var currentInput = ""
    private var operator: String? = null
    private var firstNumber: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        buttons.forEach { id ->
            findViewById<Button>(id).setOnClickListener { appendNumber((it as Button).text.toString()) }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener { clear() }
        findViewById<Button>(R.id.btnAdd).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { setOperator("/") }
        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculate() }
    }

    private fun appendNumber(number: String) {
        currentInput += number
        resultTextView.text = currentInput
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstNumber = currentInput.toDouble()
            operator = op
            currentInput = ""
        }
    }

    private fun calculate() {
        if (firstNumber != null && operator != null && currentInput.isNotEmpty()) {
            val secondNumber = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstNumber!! + secondNumber
                "-" -> firstNumber!! - secondNumber
                "*" -> firstNumber!! * secondNumber
                "/" -> if (secondNumber != 0.0) firstNumber!! / secondNumber else "Error"
                else -> ""
            }
            resultTextView.text = result.toString()
            firstNumber = null
            operator = null
            currentInput = ""
        }
    }

    private fun clear() {
        currentInput = ""
        firstNumber = null
        operator = null
        resultTextView.text = "0"
    }
}
