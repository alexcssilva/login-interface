package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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
        }

        passwordInput.editText?.addTextChangedListener {
            viewButtonLogin()
        }
    }

    private fun viewButtonLogin() {
        val emailText = emailInput.editText?.text.toString()
        val passwordText = passwordInput.editText?.text.toString()
        loginButton.isEnabled = emailText.isNotEmpty() && passwordText.isNotEmpty()
    }
}
