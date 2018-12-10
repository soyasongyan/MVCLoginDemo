package com.songyan.mvclogindemo.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.songyan.mvclogindemo.Presenter.UserLoginPresenter;
import com.songyan.mvclogindemo.R;
import com.songyan.mvclogindemo.User.IUserBiz;

public class UserLoginActivity extends Activity implements ILoginView {

    private EditText mEtUsername,mEtPassword;

    private Button mBtLogin,mBtClear;

    private ProgressBar mPbLoading;

    //持有一个Presenter层对象
    private UserLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        mEtUsername=findViewById(R.id.username_edit);
        mEtPassword=findViewById(R.id.password_edit);
        mBtLogin=findViewById(R.id.login);
        mBtClear=findViewById(R.id.clear);
        mPbLoading=findViewById(R.id.progress_login);

        presenter=new UserLoginPresenter(this);

        //绑定点击事件
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

        mBtClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(this,"login successful!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"login failed!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }
}
