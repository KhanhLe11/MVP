package com.example.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mvp.databinding.ActivityLoginBinding
import com.example.mvp.login.ILoginPresenter
import com.example.mvp.login.LoginPresenter
import com.example.mvp.view.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginPresenter: ILoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginPresenter = LoginPresenter(this)
        binding.btnLogin.setOnClickListener {
            var username = binding.edtUsernameLogin.text.toString()
            var password = binding.edtPasswordLogin.text.toString()
            loginPresenter.login(username, password)
        }

    }

    override fun loginFail() {
        Toast.makeText(
            this, "Login Fail!!",
            Toast.LENGTH_SHORT
        ).show();
    }

    override fun loginSuccessful() {
        Toast.makeText(
            this, "Login Thanh Cong!!",
            Toast.LENGTH_SHORT
        ).show();
    }

    override fun goHome() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}