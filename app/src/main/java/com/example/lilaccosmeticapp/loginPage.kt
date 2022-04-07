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
import kotlinx.android.synthetic.main.activity_login_page.*

private val emailLiveData = MutableLiveData<String>()
private val passwordLiveData = MutableLiveData<String>()
private val isValidateLiveData = MediatorLiveData<Boolean>().apply {
    addSource(emailLiveData){ email ->
        val password = passwordLiveData.value
        this.value = validateForm(email,password)
    }
    addSource(passwordLiveData){ password ->
        val email = emailLiveData.value
        this.value = validateForm(email,password)
    }
}

fun validateForm(email: String?, password: String?): Boolean? {
    val isValideEmail = email != null && email.isNotBlank() && email.contains("@")
    val isValidePassword = password != null && password.isNotBlank() && password.length <= 10
    return isValideEmail && isValidePassword
}

class loginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val emailLayout = findViewById<TextInputLayout>(R.id.txtEmailLayout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.txtPasswordLayout)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        emailLayout.editText?.doOnTextChanged { text, _, _, _ ->
            emailLiveData.value = text?.toString()

            passwordLayout.editText?.doOnTextChanged { text, _, _, _ ->
                passwordLiveData.value = text?.toString()
            }
        }

        isValidateLiveData.observe(this) { isValide ->
            btnLogin.isEnabled = isValide

            btnBackLogin.setOnClickListener() {
                val intent = Intent(this, welcomeScreen::class.java)
                startActivity(intent)
            }

            btnHomeLogin.setOnClickListener() {
                val intent = Intent(this, home::class.java)
                startActivity(intent)
            }

            btnCategoryLogin.setOnClickListener() {
                val intent = Intent(this, catogeries::class.java)
                startActivity(intent)
            }

            btnSaleLogin.setOnClickListener() {
                val intent = Intent(this, sales::class.java)
                startActivity(intent)
            }
        }

    }
}