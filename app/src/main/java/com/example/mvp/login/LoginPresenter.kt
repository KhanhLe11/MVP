package com.example.mvp.login

import com.example.mvp.view.ILoginView

class LoginPresenter(var loginViewInit: ILoginView) : ILoginPresenter {
    override fun login(username: String, password: String) {
        if (username.equals("admin", ignoreCase = true)
            && password.equals("admin", ignoreCase = true)
        ) {
            loginViewInit.loginSuccessful();
            loginViewInit.goHome();
        } else {
            loginViewInit.loginFail();
        }
    }
}