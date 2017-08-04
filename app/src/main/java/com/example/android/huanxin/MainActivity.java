package com.example.android.huanxin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

/**
 * 发起聊天
 */
public class MainActivity extends AppCompatActivity {

    private Button btnStar;
    private Button btnExit;
    private EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStar = (Button) findViewById(R.id.btn_star);
        btnExit = (Button) findViewById(R.id.btn_exit);

        editName = (EditText) findViewById(R.id.edit_name);

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开启聊天
                startChat();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //退出登陆
                exitChat();
            }
        });

    }

    private void startChat(){

    }

    private void exitChat(){
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                //退出成功
                finish();
                Toast.makeText(MainActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(MainActivity.this, "退出失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
