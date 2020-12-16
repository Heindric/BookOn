package com.example.bookon

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.user_profile.*

class Login : AppCompatActivity() {
    val TAG = "Activity"
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Register_tv.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        mAuth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener {
            doLogin()
        }
    }


    private fun doLogin() {
        if (email_et.text.toString().isEmpty()) {
            email_et.error = "Please enter email"
            email_et.requestFocus()
            return
        }
        if (password_et.text.toString().isEmpty()) {
            password_et.error = "Please enter password"
            password_et.requestFocus()
            return
        }
        mAuth.signInWithEmailAndPassword(email_et.text.toString(), password_et.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        updateUI(user)
                    } else {
                        updateUI(null)
                    }
                }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        updateUI(currentUser)
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStart")
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            startActivity(Intent(this, BookingActivity::class.java))
        } else {
            Toast.makeText(baseContext, "Login failed",
                    Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume(){
        super.onResume()
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show()
    }
}