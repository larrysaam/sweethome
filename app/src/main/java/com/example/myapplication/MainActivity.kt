// This code is written in Kotlin programming language and is used to implement Google Sign-In
// authentication in an Android application using Firebase Authentication.

package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Home
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


/**this is the main activity
*
* it handles the authentication of the users
* authentication is through google auth only
 **/
class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var client: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentification)

        /** getting the id token to use the authentication service
         *Firebase google auth service provides the request id token.
         *The app generates a six-digit code that changes every 30 seconds and is based on a unique key and the current time134.
         *The code is needed to log in to an account or service from an unfamiliar device,
         *which Google can detect by its unique address
         **/
        var options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        client = GoogleSignIn.getClient(this, options)

        /*client or user clicks on the google auth button
         */
        textView = findViewById(R.id.signinWithGoogle)

        /*onclick, the
         */
        textView.setOnClickListener{
            Toast.makeText(this, "task.exception?.message", Toast.LENGTH_SHORT).show()
            var intent = client.signInIntent

            startActivityForResult(intent, 10001)
            Toast.makeText(this, "task.exception?.message", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==10001){

            /**this code gets the all google accounts stored in the users phone
             *thereafter it gets the credentials and passes it to firebase for a quick google
             *check to see if it is really the owner of the account
            **/
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)
            var account = task.getResult(ApiException::class.java)
            var credentials = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credentials)
                .addOnCompleteListener{task->

                    /**
                     * if credentials are correct, the user is taken to the home page/ intent of the application
                     *else, an error message pops up.
                     **/
                    if(task.isSuccessful){

                        var i = Intent(this,Home::class.java )
                        startActivity(i)

                    }else{
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }

    override fun onStart() {
        super.onStart()
        if(FirebaseAuth.getInstance().currentUser != null){
            var i = Intent(this,Home::class.java )
            startActivity(i)
        }
    }

}