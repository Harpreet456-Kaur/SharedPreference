package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        sharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        binding.goBtn.setOnClickListener {
            editor.putString("name",binding.name.text.toString())
                editor.apply()
            val intent = Intent(this,GetData::class.java)
            startActivity(intent)
            Log.d("TAG--->",binding.name.text.toString())
            System.out.println("SendData , ${binding.name.text}")
        }

        var sharedPreferences = getSharedPreferences("receive", MODE_PRIVATE)
        var receive = sharedPreferences.getString("receive","")
        binding.name.setText(receive)
        setContentView(binding.root)
    }
}