package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_catogeries.*
import kotlinx.android.synthetic.main.activity_createaccountpage.*

private val emailLiveData = MutableLiveData<String>()
private val usernameLiveData = MutableLiveData<String>()
private val passwordLiveData = MutableLiveData<String>()
private val isValidateLiveData = MediatorLiveData<Boolean>().apply {
    addSource(emailLiveData){ email ->
        val password = passwordLiveData.value
        val username = usernameLiveData.value
        this.value = validateCreateAccount(email,username,password)
    }
    addSource(passwordLiveData){ password ->
        val email = emailLiveData.value
        val username = usernameLiveData.value
        this.value = validateCreateAccount(email,password,username)
    }
}

fun validateCreateAccount(email: String?, password: String?,username:String?): Boolean? {
    val isValideEmail = email != null && email.isNotBlank() && email.contains("@")
    val isValidePassword = password != null && password.isNotBlank() && password.length <= 6
    val isValideUsername = username != null && username.isNotBlank()
    return isValideEmail && isValidePassword && isValideUsername
}

class createaccountpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccountpage)

        val emailLayout = findViewById<TextInputLayout>(R.id.txtEmailCreateLayout)
        val passwordLayout =findViewById<TextInputLayout>(R.id.txtPasswordCreateLayout)
        val usernameLayout = findViewById<TextInputLayout>(R.id.txtUsernameCreateLayout)
        val btnLogin = findViewById<Button>(R.id.btnSign)

        emailLayout.editText?.doOnTextChanged{text,_,_,_ ->
            emailLiveData.value = text?.toString()

            passwordLayout.editText?.doOnTextChanged{text,_,_,_ ->
                passwordLiveData.value = text?.toString()
            }

            usernameLayout.editText?.doOnTextChanged{text,_,_,_ ->
                usernameLiveData.value =text?.toString()
            }
        }

        isValidateLiveData.observe(this){isValide ->
            btnSign.isEnabled = isValide
        }

        btnBackCreateAcc.setOnClickListener(){
            val intent = Intent(this,welcomeScreen::class.java)
            startActivity(intent)
        }

        btnHomeCreateAcc.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryCreateAcc.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleCreateAcc.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

    }
}