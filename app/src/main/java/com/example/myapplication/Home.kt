// This code is written in Kotlin language and is an implementation of an Android app screen
package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Home: AppCompatActivity() {

    // Declare image views for displaying images
    private lateinit var imageview1: ImageView
    private lateinit var imageview2: ImageView
    private lateinit var imageview3: ImageView
    private lateinit var imageview4: ImageView
    private lateinit var imageview5: ImageView
    private lateinit var imageview6: ImageView
    private lateinit var imageview7: ImageView
    private lateinit var imageview8: ImageView
    private lateinit var imageview9: ImageView

    // Declare linear layouts for displaying views
    private lateinit var linearLayout: LinearLayout
    private lateinit var linearLayout2: LinearLayout
    private lateinit var linearLayout3: LinearLayout
    private lateinit var linearLayout4: LinearLayout

    // Declare a text view for adding a new item
    private lateinit var add: TextView

    // Override the onCreate method to initialize the app screen
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // Find the add button by its ID
        add = findViewById(R.id.host)

        // Find the linear layouts by their IDs
        linearLayout = findViewById(R.id.viewMap1)
        linearLayout2 = findViewById(R.id.viewMap2)
        linearLayout3 = findViewById(R.id.viewMap3)
        linearLayout4 = findViewById(R.id.viewMap4)

        // Find the image views by their IDs
        imageview1 = findViewById(R.id.house1)
        imageview2 = findViewById(R.id.house2)
        imageview3 = findViewById(R.id.house3)
        imageview4 = findViewById(R.id.house4)
        imageview5 = findViewById(R.id.house5)
        imageview6 = findViewById(R.id.house6)
        imageview7 = findViewById(R.id.house7)
        imageview8 = findViewById(R.id.house8)
        imageview9 = findViewById(R.id.house9)

        // Set the images for the image views
        imageview1.setImageResource(R.drawable.appartment_mittagspitze_esstisch_kueche)
        imageview2.setImageResource(R.drawable.appart8)
        imageview3.setImageResource(R.drawable.appart7)
        imageview4.setImageResource(R.drawable.appart6)
        imageview5.setImageResource(R.drawable.appart5)
        imageview6.setImageResource(R.drawable.appart4)
        imageview7.setImageResource(R.drawable.appart1)
        imageview8.setImageResource(R.drawable.apart2)
        imageview9.setImageResource(R.drawable.appart3)

        // Set a click listener for the add button
        add.setOnClickListener {
            var i = Intent(this,Regis::class.java )
            startActivity(i)
        }

        // Set click listeners for the linear layouts
        linearLayout.setOnClickListener {
            var i = Intent(this,Homedetails::class.java )
            startActivity(i)
        }

        linearLayout2.setOnClickListener {
            var i = Intent(this,Details2::class.java )
            startActivity(i)
        }
        linearLayout3.setOnClickListener {
            var i = Intent(this,Details3::class.java )
            startActivity(i)
        }
    }
}