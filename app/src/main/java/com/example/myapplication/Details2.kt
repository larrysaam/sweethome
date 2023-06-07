package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Details2: AppCompatActivity() {


    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homedetails)

        imageView1 = findViewById(R.id.apartment)
        imageView2 = findViewById(R.id.ownerprofile)
        imageView3 = findViewById(R.id.mapview)


        imageView1.setImageResource(R.drawable.appartment_mittagspitze_esstisch_kueche)
        imageView2.setImageResource(R.drawable.pexels_photo_771742)
        imageView3.setImageResource(R.drawable.map)


        imageView3.setOnClickListener {
            var i = Intent(this,Loca::class.java )
            startActivity(i)
        }
    }
}