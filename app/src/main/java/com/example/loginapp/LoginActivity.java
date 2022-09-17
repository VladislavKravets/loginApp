package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView loginTextView;
    private TextView passwordTextView;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginTextView = findViewById(R.id.login_plain_text);
        passwordTextView = findViewById(R.id.password);
        statusTextView = findViewById(R.id.status_text_view);
    }

    public void click_login_button(View view) {
        if (loginTextView.getText().toString().equals("admin")) { // очень плохой пример проверки
            if (passwordTextView.getText().toString().equals("admin")) {
                User user = new User(loginTextView.getText().toString(), passwordTextView.getText().toString());
                Intent intent = new Intent(this, MainWindowActivity.class);
                intent.putExtra(User.class.getSimpleName(), user); // передаю обьект на другой activity
                startActivity(intent);
                finish(); // закрываю прошлый activity (увидел где-то в гайде, возможно это лишнее)
            } else {
                statusTextView.setText("Invalid Password");
            }
        } else {
            statusTextView.setText("Invalid Login");
        }
    }
}