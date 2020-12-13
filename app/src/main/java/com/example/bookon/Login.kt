package com.example.bookon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Register_tv.setOnClickListener {
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
        mAuth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener{
            doLogin()
        }
    }

    private fun doLogin() {
        if (email_et.text.toString().isEmpty()){
            email_et.error = "Please enter email"
            email_et.requestFocus()
            return
        }
        if (password_et.text.toString().isEmpty()){
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
    }

    private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(baseContext, "Login failed",
                Toast.LENGTH_SHORT).show()
        }
    }
}