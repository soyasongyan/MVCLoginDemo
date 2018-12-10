package com.songyan.mvclogindemo.User;

public interface IUserBiz {

    public void login(String username,String password,OnLoginListener loginListener);
}
