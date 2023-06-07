

package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Addpicture: AppCompatActivity()  {

    // Declare variables
    private  lateinit var button: Button
    private lateinit var vbox: LinearLayout
    private lateinit var imageview: ImageView
    private lateinit var next: Button

    // Define a companion object to hold constants
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    // Override the onCreate method
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landlord)

        // Initialize variables
        button = findViewById(R.id.addImage)
        next = findViewById(R.id.gotoRoomBtn)
        imageview = findViewById(R.id.houseimg)

        // Set a click listener for the "Add Image" button
        button.setOnClickListener{
            pickImageGalery()
        }

        // Set a click listener for the "Next" button
        next.setOnClickListener {
            var i = Intent(this,Rooms::class.java )
            startActivity(i)
        }
    }

    // Define a function to pick an image from the gallery
    private fun pickImageGalery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    // Override the onActivityResult method to set the selected image as the ImageView source
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageview.layoutParams = LinearLayout.LayoutParams(400, 300)
            imageview.setImageURI(data?.data)
        }
    }
}