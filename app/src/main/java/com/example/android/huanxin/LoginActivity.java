package com.example.android.huanxin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

/**
 * 登陆注册
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener {

    private EditText editName;
    private EditText editPwd;
    private Button btnRegister;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editName = (EditText) findViewById(R.id.edit_name);
        editPwd = (EditText) findViewById(R.id.edit_pwd);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_register:
                register();
                break;
        }
    }

    private void register() {
        Toast.makeText(this, "aaaa", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(editName.getText().toString().trim(),
                            editPwd.getText().toString().trim());
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    Log.i("LG", "注册失败， " + e.getErrorCode() + e.getMessage());
                }
            }
        }).start();
    }

    private void login() {
        EMClient.getInstance().login(editName.getText().toString().trim(),
                editPwd.getText().toString().trim(), new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        //登陆成功
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onError(int i, String s) {
                        Log.i("LG", "登陆失败， " + i + s);
                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
    }
}
