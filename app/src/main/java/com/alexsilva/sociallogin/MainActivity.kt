package com.alexsilva.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
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
        }

        passwordInput.editText?.addTextChangedListener {
            viewButtonLogin()
        }

        loginButton.setOnClickListener {
            validateEmail()
            validatePassword()
            isSuccessLogin()
            }
        }

    private fun viewButtonLogin() {
        val emailText = emailInput.editText?.text.toString()
        val passwordText = passwordInput.editText?.text.toString()
        val isValid = emailText.isNotEmpty() && passwordText.isNotEmpty()

        loginButton.apply {
            isEnabled = isValid
            if (isValid) {
                setBackgroundColor(ContextCompat.getColor(context, R.color.primary_button_enabled))
                setTextColor(ContextCompat.getColor(context, R.color.primary_text))
            }
        }
    }
    private fun isEmailInvalid(email: String): Boolean {
        val emailText = emailInput.editText?.text.toString()
        val emailRegex = Regex("^[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")
        return emailRegex.matches(emailText)
    }
    private fun validateEmail() {
        val emailText = emailInput.editText?.text.toString()
        if (!isEmailInvalid(emailText)) {
            emailInput.error = "Email inválido"
        } else {
            emailInput.error = ""
        }
    }

    private fun validatePassword() {
        val passwordText = passwordInput.editText?.text.toString()
        if (passwordText.length < 5) {
            passwordInput.error = "Senha deve ter mais de 4 caracteres"
        } else {
            passwordInput.error = ""
        }
    }

    private fun isSuccessLogin() {
        Snackbar.make(
            findViewById(android.R.id.content),
            R.string.login_succeeded, Snackbar.LENGTH_SHORT
        ).show()
    }
}

