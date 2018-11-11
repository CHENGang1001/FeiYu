package com.feiyu.activity.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.feiyu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends Activity {

    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_verify)
    EditText etVerify;
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.tv_show)
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_login, R.id.tv_verify, R.id.bt_register, R.id.tv_show})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                break;
            case R.id.tv_verify:
                break;
            case R.id.bt_register:
                break;
            case R.id.tv_show:
                break;
        }
    }
}
