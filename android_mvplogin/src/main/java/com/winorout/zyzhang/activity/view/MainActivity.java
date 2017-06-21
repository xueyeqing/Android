package com.winorout.zyzhang.activity.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEdit, passwrodEdit;
    private Button loginButton;
    ProgressDialog pd;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                break;
        }
    }
}
