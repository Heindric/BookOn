package com.example.bookon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_register.*


class Register : AppCompatActivity(), View.OnClickListener {
    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mAuth = FirebaseAuth.getInstance()

        if(mAuth.currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        register_btn.setOnClickListener{
            signUpUser()

        }
        loginhere_tv.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
       }
    }

    fun signUpUser(){
        if (username_et.text.toString().isEmpty()){
            username_et.error = "Please enter name"
            username_et.requestFocus()
            return
        }
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
        if (confirmpassword_et.text.toString().isEmpty()){
            confirmpassword_et.error = "Please enter password"
            confirmpassword_et.requestFocus()
           return
        }

        mAuth.createUserWithEmailAndPassword(email_et.text.toString(), password_et.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@Register, "User Created", Toast.LENGTH_SHORT).show()
                    updateProfile()
                    updateEmail()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    private fun updateProfile() {

        val user = mAuth.currentUser
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(username_et.text.toString()).build()
        user!!.updateProfile(profileUpdates)
    }
    private fun updateEmail() {
        val user = mAuth.currentUser
        user!!.updateEmail(email_et.text.toString())
    }
}