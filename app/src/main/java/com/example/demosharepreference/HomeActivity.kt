package com.example.demosharepreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demosharepreference.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("InfoLogin", Context.MODE_PRIVATE) // Get from MainActivity
        if (sharedPreferences != null) {

            var username = sharedPreferences.getString("Username", "defaultUserName") // Default: Khi key rỗng
            var password = sharedPreferences.getString("Password", "defaultPassword")

            // Thông báo các key-value trong SharePrefs đã bị remove (clear) hoàn toàn
            if (username.equals("defaultUserName") && password.equals("defaultPassword")) {
                Toast.makeText(this@HomeActivity, "Null key-value !", Toast.LENGTH_SHORT).show()
            } else {
                binding.tvUserName.text = username
                binding.tvPassword.text = password
                Log.d("Pass in Home", password!!)
            }
        } else {
            // Do somthing
            Toast.makeText(this@HomeActivity, "Null sharepreferences !", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            var prefs = getSharedPreferences("InfoLogin", Context.MODE_PRIVATE)
            if (prefs != null) {
                prefs.edit().clear().commit() // Xóa gói SharePref lấy được
                prefs.edit().remove("Username").commit()
                prefs.edit().remove("Password").commit()
                // Chỉ hỗ trợ xóa key value của gói
            }
        }
    }
}