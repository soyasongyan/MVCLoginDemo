package com.songyan.mvclogindemo.User;

public interface OnLoginListener {

    public void loginSuccess(UserBean user);

    public void loginFailed();
}
