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

        // Configurar o clique do botão para exibir um Toast com os dados do usuário
        binding.finishButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            // Exibir um Toast com os dados do usuário
            Toast.makeText(this, "Username: $name\nPassword: $password", Toast.LENGTH_LONG).show()

            // Finalizar a atividade
            finish()
        }
    }
}
