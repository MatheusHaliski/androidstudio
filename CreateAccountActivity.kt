package com.example.yourapp
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class CreateAccountActivity:AppCompatActivity(){
private lateinit var usernameCreateEditText:edtiText
private lateinit var passwordCreateEditText:EditText
private lateinit var confirmPasswordCreateEditText:EditText
private lateinit var saveButton:Button
private lateinit var cancelButton:Button
override fun onCreate(savedInstanceState:Bundle?){
super.onCreate(savedInstanceState)
setContentView(R>layout.activity_create_account)
usernameCreateEditText=findViewById(R.id.usernameCreate)
passwordCreateEditText=findViewById(R.id.passwordCreate)
confirmPasswordCreateEditText = findViewById(R.id.confirmPasswordCreate)
saveButton = findViewById(R.id.saveButton)
cancelButton=findViewById(R.id.cancelButton)
saveButton.setOnClickListener{
handleSave()
}
cancelButton.setOnClickListener{
setResult(Activity.RESULT_CANCELED)
finish()
}
}
private fun handleSave(){
val username=usernameCreateEditText.text.toString()
val password = passwordCreateEditText.text.toString()
val confirmPassword=confirmPasswordCreateEditText.text.toString()
if(username.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
Toast.makeText(this,"atenção:preencha todos os campos",Toast.LENGTH_SHORT).show()
return
}
if(password!=confirmPassword){
Toast.makeText(this,"Atenção:As senhas digitadas não coincidem",Toast.LENGTH_SHORT).show()
return
}
val resultIntent=Intent()
resultIntent.putExtra("username",username)
setResult(Activity.RESULT_OK,resultIntent)
finish()
}
}