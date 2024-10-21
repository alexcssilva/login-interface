package com.betrybe.sociallogin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val emailInput: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val passwordInput: TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }
    private val loginButton: Button by lazy { findViewById(R.id.login_button) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput.editText?.addTextChangedListener {
            viewButtonLogin()
            validateEmail()
        }

        passwordInput.editText?.addTextChangedListener {
            viewButtonLogin()
        }

        loginButton.setOnClickListener {
            validateEmail()
        }
    }

    private fun viewButtonLogin() {
        val emailText = emailInput.editText?.text.toString()
        val passwordText = passwordInput.editText?.text.toString()

        loginButton.isEnabled = emailText.isNotEmpty() && passwordText.isNotEmpty() }

    private fun isValidEmail(email: String): Boolean {
        val emailText = emailInput.editText?.text.toString()
        val emailRegex = Regex("^[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")
        return emailRegex.matches(emailText)
    }
    private fun validateEmail() {
        val emailText = emailInput.editText?.text.toString()
        if (!isValidEmail(emailText)) {
            emailInput.error = "Email inválido"
        } else {
            emailInput.error = ""
        }
    }
}
