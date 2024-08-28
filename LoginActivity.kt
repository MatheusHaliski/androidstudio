package com.example.yourapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class LoginActivity:AppCompatActivity(){
	private lateinit var usernameEditText: EditText
	private lateinit var passwordEditText:EditText
	private lateinit var loginButton:Button
	private lateinit var createAccountButton:Button
	override fun onCreate(savedInstanceState:Bundle?){
		super.onCreate(savedInstanceState:Bundle?){
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
		usernameEditText=findViewById(R.id.username)
		passwordEditText=findViewById(R.id.password)
		loginButton = findViewById(R.id.loginButton)
		createAccountButton = findViewById(R.id.createAccountButton)
		loginButton.setOnClickListener{
			handleLogin()
		}
		createAccountButton.setOnClickListener{
			val intent=Intent(this,CreateAccountActivity::class.java)
			startActivityForResult(intent,1)
		}}
		private fun handlelogin(){
			val username=usernameEditText.text.toString()
			val password=passwordEditText.text.toString()
			if(username.isEmpty() || password.isEmpty()){
			Toast.makeText(this,"Atenção:preencha todos os campos",Toast.LENGTH_SHORT).show()
			return
			}
			Toast.makeText(this,"Bem-Vindo,$username!",Toast.LENGTH_SHORT).show()

			override fun onActivityResult(requestCode:Int,resultCode:Int,data:Intent?){
			super.onActivityResult(requestCode,resultCode,data)
			if(requestCode==1 && resultCode==RESULT_OK){
			val username=data?.getStringExtra("username")
			usernameEditText.setText(username)
}
}
}