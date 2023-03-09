package com.example.cleanupapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanupapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {

    private  lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivitySignupBinding.inflate(layoutInflater)
            setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpSingin.setOnClickListener {
            val login_intent = Intent(this,login::class.java)
            startActivity(login_intent)
        }

        binding.signUpButton.setOnClickListener {
            val email = binding.signUpEmail.text.toString()
            val password = binding.signUpPassword.text.toString()
            val name = binding.signUpName.toString()

            if(email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val login_intent = Intent(this,login::class.java)
                        startActivity(login_intent)
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"Enter Details Correctly",Toast.LENGTH_LONG).show()
            }
        }

    }
}