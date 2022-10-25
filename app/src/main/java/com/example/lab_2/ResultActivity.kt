package com.example.lab_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result:Double = intent.getDoubleExtra("result", Double.NaN)
        if (!result.isNaN())
            resView.text = result.toString()

        closeBtn.setOnClickListener{
            this.finish()
        }
    }
}