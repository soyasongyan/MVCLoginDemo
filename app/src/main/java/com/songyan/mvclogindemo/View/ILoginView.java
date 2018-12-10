package com.songyan.mvclogindemo.View;

public interface ILoginView {

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity();

    void showFailedError();

    void clearUserName();

    void clearPassword();
}
