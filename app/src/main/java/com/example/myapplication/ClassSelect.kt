package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class ClassSelect: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.class_selector)

        val AutoComplete = findViewById<AutoCompleteTextView>(R.id.classdropdown)
        val items = listOf("class 1A", "Class 1B")

        val adapter = ArrayAdapter(this, R.layout.list, items)
        AutoComplete.setAdapter(adapter)
    }


}