package com.example.loginandregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    private lateinit var loginbtn: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbtn = findViewById(R.id.login)
        edituser = findViewById(R.id.ID)
        editpword = findViewById(R.id.pw)
        dbh = DBHelper(this)

        loginbtn.setOnClickListener{
            val userdtx = edituser.text.toString()
            val passedx = editpword.text.toString()

            if (TextUtils.isEmpty(userdtx) || TextUtils.isEmpty(passedx)){
                Toast.makeText(this, "Add Username & Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(userdtx, passedx )
                if (checkuser==true){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Login, Success::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Wrong username & password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}