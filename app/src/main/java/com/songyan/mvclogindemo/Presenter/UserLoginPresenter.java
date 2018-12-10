package com.songyan.mvclogindemo.Presenter;

import com.songyan.mvclogindemo.User.IUserBiz;
import com.songyan.mvclogindemo.User.OnLoginListener;
import com.songyan.mvclogindemo.User.UserBean;
import com.songyan.mvclogindemo.User.UserBiz;
import com.songyan.mvclogindemo.View.ILoginView;

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private ILoginView loginView;

    public UserLoginPresenter(ILoginView loginView){
        userBiz=new UserBiz();
        this.loginView=loginView;
    }

    public void login(){
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                loginView.toMainActivity();
                loginView.hideLoading();
            }

            @Override
            public void loginFailed() {
                loginView.showFailedError();
                loginView.hideLoading();
            }
        });
    }

    public void clear(){
        loginView.clearUserName();
        loginView.clearPassword();
    }
}
