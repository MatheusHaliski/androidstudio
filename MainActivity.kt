package com.example.myintentapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myintentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Registrando um ActivityResultLauncher para receber o resultado da SecondActivity
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val name = data?.getStringExtra("name")
            val password = data?.getStringExtra("password")

            // Atualizar os TextViews com os dados recebidos
            binding.registeredUsernameTextView.text = "Registered Username: $name"
            binding.registeredPasswordTextView.text = "Registered Password: $password"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Configurar o clique do botão para redirecionar para a SecondActivity
        binding.registerButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}
