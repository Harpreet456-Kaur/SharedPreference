package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedpreference.databinding.ActivityGetDataBinding

class GetData : AppCompatActivity() {
    lateinit var binding: ActivityGetDataBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetDataBinding.inflate(layoutInflater)

        sharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
        var name = sharedPreferences.getString("name","")
        binding.name.text = name

        Log.d("TAG--->",binding.name.text.toString())
        System.out.println("ReceiveData , ${binding.name.text}")


        var sharedPreferences = getSharedPreferences("receive", MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        binding.backBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            editor.putString("receive",name)
            editor.apply()
        }

        setContentView(binding.root)
    }
}