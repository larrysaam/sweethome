// This code is written in Kotlin programming language

package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Homedetails: AppCompatActivity() {

    // Declare ImageView variables
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView1: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homedetails)

        /**
         *  Initialize ImageView variables with corresponding views from the layout
          **/
        imageView1 = findViewById(R.id.apartment)
        imageView2 = findViewById(R.id.ownerprofile)
        imageView3 = findViewById(R.id.mapview)

        /**
         *   Set images for the ImageViews
         **/

        imageView1.setImageResource(R.drawable.appartment_mittagspitze_esstisch_kueche)
        imageView2.setImageResource(R.drawable.pexels_photo_771742)
        imageView3.setImageResource(R.drawable.map)

        /**
         *   Set a click listener for imageView3
         **/
        imageView3.setOnClickListener {
            // Create an intent to start the Loca activity
            var i = Intent(this,Loca::class.java )
            // Start the Loca activity
            startActivity(i)
        }
    }
}