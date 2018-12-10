package com.songyan.mvclogindemo.User;

public class UserBiz implements IUserBiz {

    @Override
    public void login(String username, String password, OnLoginListener loginListener) {
        //模拟登录耗时操作
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if("songyan".equals(username)&&"123".equals(password)){
            UserBean user=new UserBean();
            user.setUsername(username);
            user.setPassword(username);
            loginListener.loginSuccess(user);
        }else {
            loginListener.loginFailed();
        }
    }
}
