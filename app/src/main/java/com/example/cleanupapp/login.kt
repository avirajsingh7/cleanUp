package com.example.cleanupapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanupapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class login : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.siginSignup.setOnClickListener{
            val join_intent = Intent(this,join_movement::class.java)
            startActivity(join_intent)
        }

        binding.signinBtn.setOnClickListener {
            val email = binding.siginEmail.text.toString()
            val password = binding.siginPass.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                         startActivity(Intent(this,dashboard_activity::class.java))
                         finish()
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"Enter Details Correctly", Toast.LENGTH_LONG).show()
            }
        }

    }
}