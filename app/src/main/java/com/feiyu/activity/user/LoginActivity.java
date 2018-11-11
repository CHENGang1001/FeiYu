package com.feiyu.activity.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.feiyu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    @BindView(R.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_forgot)
    TextView tvForgot;
    @BindView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_login_register, R.id.tv_forgot, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_register:
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forgot:
                Intent intent2 = new Intent(this,ForgotActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_login:
                break;
        }
    }
}

