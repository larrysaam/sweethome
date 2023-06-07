// This code is written in Kotlin programming language and is used to implement Google Sign-In
// authentication in an Android application using Firebase Authentication.

package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class Main : AppCompatActivity() {
    // Declare variables
    private lateinit var textView: TextView
    private lateinit var client: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentification)

        // Set Google Sign-In options
        var options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        // Create a Google Sign-In client
        client = GoogleSignIn.getClient(this, options)

        // Find the TextView for signing in with Google
        textView = findViewById(R.id.signinWithGoogle)

        // Set a click listener for the TextView
        textView.setOnClickListener{
            // Display a toast message
            Toast.makeText(this, "task.exception?.message", Toast.LENGTH_SHORT).show()

            // Create a sign-in intent and start the sign-in flow
            var intent = client.signInIntent
            startActivityForResult(intent, 10001)

            // Display a toast message
            Toast.makeText(this, "task.exception?.message", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==10001){
            // Get the result of the sign-in flow
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)

            // Get the signed-in account
            var account = task.getResult(ApiException::class.java)

            // Get the Google Sign-In credentials
            var credentials = GoogleAuthProvider.getCredential(account.idToken, null)

            // Sign in to Firebase with the Google Sign-In credentials
            FirebaseAuth.getInstance().signInWithCredential(credentials)
                .addOnCompleteListener{task->
                    if(task.isSuccessful){
                        // If sign-in is successful, start the Home activity
                        var i = Intent(this,Home::class.java )
                        startActivity(i)

                    }else{
                        // If sign-in fails, display a toast message with the error message
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if the user is already signed in
        if(FirebaseAuth.getInstance().currentUser != null){
            // If the user is already signed in, start the Home activity
            var i = Intent(this,Home::class.java )
            startActivity(i)
        }
    }
}