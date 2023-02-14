package com.example.loginandregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    private  lateinit var btnregis : Button
    private  lateinit var btnlogin : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnregis = findViewById(R.id.btnsingin)
        btnlogin = findViewById(R.id.btnlogin)

        btnregis.setOnClickListener{
            val intent = Intent(this@MainActivity, register::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener{
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
        }
    }
}