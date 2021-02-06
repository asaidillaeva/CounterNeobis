package com.example.counter

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var result: String = "0000"
    var counter: Int = 0
    var counterTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterTextView = findViewById(R.id.textView)

    }

    fun onCountClicked(view: View) {
        counter++
        when (counter.toString().length) {
            1 -> result = "000$counter"
            2 -> result = "00$counter"
            3 -> result = "0$counter"
            4 -> result = "$counter"
        }
        counterTextView!!.text = result
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("result", result)
        outState.putInt("counter", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        result = savedInstanceState.getString("result").toString()
        counter = savedInstanceState.getInt("counter")

        counterTextView!!.text = result
    }

}