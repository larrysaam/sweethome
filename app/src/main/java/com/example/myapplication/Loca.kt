package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.maps.*
import com.google.firebase.database.FirebaseDatabase


/**
*this class uses google map api to display the location of the house
 **/
class Loca : AppCompatActivity(){

    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)

        imageView = findViewById(R.id.imagemap)

        imageView.setImageResource(R.drawable.screenshot_20230510_062621)



    }


    fun useGoogleMapService() {
        /**
         * This function uses the Google Maps service to retrieve location data.
         *
         * Parameters:
         * None
         *
         * Returns:
         * None
         */
        try {
            // Use the Google Maps API to retrieve location data
            val mapsApi = GeoApiContext.Builder()
                .apiKey("YOUR_API_KEY_HERE")
                .build()
            val location = GeocodingApi.geocode(mapsApi, "1600 Amphitheatre Parkway Mountain View, CA 94043").await()[0]

            // Log the location data
            println("Location: ${location.formattedAddress}, Lat: ${location.geometry.location.lat}, Lng: ${location.geometry.location.lng}")
        } catch (e: Exception) {
            // Log the error
            println("Error: ${e.message}")
        }



        fun storeDataInFirebase(data: Map<String, Any>, path: String) {
            /**
             * This function stores data in Firebase Realtime Database.
             *
             * Parameters:
             * data (Map<String, Any>): The data to be stored in Firebase
             * path (String): The path to the location in Firebase where the data will be stored
             */
            try {
                // Initialize Firebase with your project credentials
                val database = FirebaseDatabase.getInstance()

                // Get a reference to the location in Firebase where the data will be stored
                val ref = database.getReference(path)

                // Store the data in Firebase
                ref.setValue(data)
            } catch (e: Exception) {
                // Log the error
                println("Error: ${e.message}")
            }
        }

    }