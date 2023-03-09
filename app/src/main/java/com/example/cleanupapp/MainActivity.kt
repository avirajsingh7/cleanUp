package com.example.cleanupapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if(user!=null){
                val dashboardIntent = Intent(this,dashboard_activity::class.java)
                startActivity(dashboardIntent)
            }
            else{
                val SignInIntent = Intent(this,login::class.java)
                startActivity(SignInIntent)
            }
        },2000)

    }
}