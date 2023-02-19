package com.example.demosharepreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demosharepreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    //lateinit var a: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //a = ArrayList()
        sharedPreferences = getSharedPreferences("InfoLogin", Context.MODE_PRIVATE) // InfoLogin: Là key của gói dữ liệu

        binding.btnLogin.setOnClickListener {
            var username = binding.edtUserName.text
            var password = binding.edtPassword.text

            Log.d("Pass", password.toString())

            if (sharedPreferences != null) {
                var editor = sharedPreferences.edit()
                editor.putString("Username", username.toString()) // Boolean, char,...
                editor.putString("Password", password.toString())
                editor.apply()

                var intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                var editor = getSharedPreferences("InfoLogin", Context.MODE_PRIVATE).edit()
                editor.putString("Username", username.toString()) // Boolean, char,...
                editor.putString("Password", password.toString())
                editor.apply()

                var intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}