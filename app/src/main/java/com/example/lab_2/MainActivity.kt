package com.example.lab_2

import android.content.Intent
import android.content.pm.PackageManager.NameNotFoundException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


   private val inputType = InputType.TYPE_CLASS_NUMBER or
            InputType.TYPE_CLASS_TEXT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sunBtn.setOnClickListener{operations("+")}
        minusBtn.setOnClickListener{operations("-")}
        multyBtn.setOnClickListener{operations("*")}
        divBtn.setOnClickListener{operations("/")}
        enterNums.inputType = inputType

        clearBtn.setOnClickListener{
            enterNums.setText("")
        }

        resBtn.setOnClickListener{
            var res = Double.NaN
            try {
                val ex = ExpressionBuilder(enterNums.text.toString()).build()
                res = ex.evaluate()
            }catch (_:Exception){ }
            startActivity(Intent(
                this, ResultActivity::class.java).apply {
                    putExtra("result", res)
            })
        }
    }

    fun operations(op: String){
        enterNums.append(op)
    }

}