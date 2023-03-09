package com.example.cleanupapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanupapp.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class dashboard_activity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.dashSignout.setOnClickListener {
            firebaseAuth.signOut();
            startActivity(Intent(this,login::class.java))
        }


    }
}