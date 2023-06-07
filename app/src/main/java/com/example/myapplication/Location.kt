package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Location: AppCompatActivity() {

    private lateinit var publish: Button
    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location)

        publish = findViewById(R.id.publish)
        imageView =findViewById(R.id.map)

        imageView.setImageResource(R.drawable.map)

        publish.setOnClickListener {

            var i = Intent(this,Home::class.java )
            startActivity(i)
        }

    }

}