package com.example.myintentapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myintentapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        binding.finishButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            
            Toast.makeText(this, "Username: $name\nPassword: $password", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
