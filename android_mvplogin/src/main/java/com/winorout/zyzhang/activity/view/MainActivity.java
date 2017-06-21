package com.winorout.zyzhang.activity.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.winorout.zyzhang.activity.view.presenter.ILoginPresenter;
import com.winorout.zyzhang.activity.view.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILogin {

    private EditText usernameEdit, passwrodEdit;
    private Button loginButton;
    ProgressDialog pd;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        pd = new ProgressDialog(this);

        usernameEdit = (EditText) findViewById(R.id.username);
        passwrodEdit = (EditText) findViewById(R.id.pass);
        loginButton = (Button) findViewById(R.id.login);

        loginButton.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                loginPresenter.Login(usernameEdit.getText().toString(), passwrodEdit.getText().toString());
                break;
        }
    }


    @Override
    public void showProgress() {
        pd.show();
    }

    @Override
    public void hideProgress() {
        pd.cancel();
    }

    @Override
    public void setPasswordError() {
        passwrodEdit.setError("passwrod error");
    }

    @Override
    public String getUsername() {
        return usernameEdit.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwrodEdit.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }
}
