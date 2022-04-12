package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.helloText)
        val editText = findViewById<EditText>(R.id.textName)
        val submitButton = findViewById<Button>(R.id.helloButton)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var name = ""

        submitButton.setOnClickListener {
            name = editText.text.toString()

            if (name == ""){
                Toast.makeText(
                    this@MainActivity,
                    "Please enter a name",
                    Toast.LENGTH_LONG
                ).show()
                greetingTextView.text = "Hello World!"
            }else {
                val message = "Welcome $name"
                greetingTextView.text = message
                editText.text.clear()
                offersButton.visibility = VISIBLE
            }


        }

        offersButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",name)
            startActivity(intent)

        }
    }
}