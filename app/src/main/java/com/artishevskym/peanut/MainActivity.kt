package com.artishevskym.peanut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            validateInputForm()
        }
    }

    private fun validateInputForm() {
        val password = passwordInputField.text.toString()
        if (password.length < 5) {
            passwordInputField.error = getString(R.string.login_password_error)
        }
    }
}
