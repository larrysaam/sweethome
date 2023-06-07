package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Regis:AppCompatActivity() {


    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        button = findViewById(R.id.HostBtn)

        button.setOnClickListener {
            var i = Intent(this,Addpicture::class.java )
            startActivity(i)
        }

    }
}