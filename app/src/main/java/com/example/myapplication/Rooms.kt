package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Rooms: AppCompatActivity() {

    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rooms)

        next = findViewById(R.id.gotoLocationBtn)


        next.setOnClickListener{
            var i = Intent(this,Location::class.java )
            startActivity(i)
        }

    }


}