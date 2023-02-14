package com.example.loginandregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class register : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var email: EditText
    private lateinit var singup: Button
    private lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        uname = findViewById(R.id.ID)
        pword = findViewById(R.id.pw)
        email = findViewById(R.id.email)
        singup = findViewById(R.id.singin)
        db = DBHelper(this)

        singup.setOnClickListener{
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val emailtext = email.text.toString()
            val savedata = db.insertdata(unametext,pwordtext)

            if (TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(emailtext)){
                Toast.makeText(this, "Add username, Password & Conform password", Toast.LENGTH_SHORT).show()

            }
            else{
                if (pwordtext.equals(emailtext)){
                    if (savedata == true){
                        Toast.makeText(this, "Singup Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent (applicationContext, Login::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "User Exists", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Password not Match", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}