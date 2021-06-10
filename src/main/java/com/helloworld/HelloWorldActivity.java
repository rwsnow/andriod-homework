package com.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText userNameEditText = findViewById(R.id.userNameEditText);
        final TextInputEditText passwordEditText = findViewById(R.id.passwordEditText);

        //登录按钮点击操作
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String userName = userNameEditText.getText().toString();
                        String password = passwordEditText.getText().toString();
                        if ("sky".equals(userName) && "123".equals(password)) {
                            Toast.makeText(HelloWorldActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(HelloWorldActivity.this,RecyclerViewActivity.class);
                            startActivity(intent);
                        } else {
                            AlertDialog.Builder loginFailedBuilder = new AlertDialog.Builder(HelloWorldActivity.this);
                            loginFailedBuilder.setTitle("登录失败");
                            loginFailedBuilder.setMessage("你的用户名或密码输错啦！");
                            loginFailedBuilder.show();
                        }
                    }
                }
        );
    }
}