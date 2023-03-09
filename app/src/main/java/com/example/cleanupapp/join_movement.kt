package com.example.cleanupapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanupapp.databinding.ActivityJoinMovementBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class join_movement : AppCompatActivity() {

    private lateinit var binding: ActivityJoinMovementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJoinMovementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.joinMovementBtn.setOnClickListener {
            val signup_intent = Intent(this,signup::class.java)
            startActivity(signup_intent)
        }

    }
}