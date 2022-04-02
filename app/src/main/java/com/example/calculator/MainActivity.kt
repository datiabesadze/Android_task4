package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeoutException

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""
    private var clearButton: TextView? = null
    private var delButton: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result_text_view)
        clearButton = findViewById(R.id.Clear)
        delButton = findViewById(R.id.del)


        delButton?.setOnClickListener{
            resultTextView.setBackgroundResource(android.R.drawable.screen_background_dark_transparent)

            resultTextView.text = ""
        }



        clearButton?.setOnClickListener{

            resultTextView.setBackgroundResource(android.R.drawable.screen_background_dark_transparent)

            resultTextView.text = ""

        }
    }


    fun numberClick(view: View) {
        if (view is TextView) {
            var number: String = view.text.toString()
            var result = resultTextView.text.toString()
            if (result == "0") {
                result = ""
            }
            if (result == ".") {
                result = ""
            }

            resultTextView.text = result + number
        }
    }

    fun operationClick(view: View) {
        if (view is TextView) {
            operand = resultTextView.text.toString().toDouble()
            resultTextView.text = ""
            operation = view.text.toString()
        }
    }


    fun equalsClick(view: View) {
        var secOperand: Double = resultTextView.text.toString().toDouble()
        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
        }
    }

}
