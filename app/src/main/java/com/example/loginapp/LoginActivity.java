package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private TextView loginTextView;
    private TextView passwordTextView;
    private TextView statusTextView;
    private final List<User> users = new ArrayList<>(); // так называемая бд, хоть и локальная
    private User user; // прослойка для переноса данных

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginTextView = findViewById(R.id.login_plain_text);
        passwordTextView = findViewById(R.id.password);
        statusTextView = findViewById(R.id.status_text_view);
    }

    public void click_login_button(View view) {
        /* загрузка данных или заполнение */
        users.add(new User("kravets123", "123123", "Кравець Владислав", "ПЗС-2144"));
        users.add(new User("mikityk123", "123321", "Микитюк Наташа", "ПЗС-2255"));

        switch (authUser(loginTextView.getText().toString(), passwordTextView.getText().toString())) {
            case SUCCESS:
                statusTextView.setText("Виконується вхід!");
                redirectToMainActivity(user);
                break;
            case FAILED_PASSWORD:
                statusTextView.setText("Не правильний пароль!");
                break;
            case FAILED_LOGIN:
                statusTextView.setText("Такого логіну не існує в базі даних!");
                break;
        }
    }

    private LoginStatus authUser(String login, String password) {
        for (User res : users) {
            if (login.equals(res.getLogin())) {
                if (password.equals(res.getPassword())) {
                    user = res; // заносим данные в прослоку для последующего перехода
                    return LoginStatus.SUCCESS;
                } else {
                    return LoginStatus.FAILED_PASSWORD;
                }
            }
        }
        return LoginStatus.FAILED_LOGIN;
    }

    private void redirectToMainActivity(User user) {
        Intent intent = new Intent(this, MainWindowActivity.class);
        intent.putExtra(User.class.getSimpleName(), user); // передаю обьект на другой activity
        startActivity(intent);
        finish(); // закрываю прошлый activity (увидел где-то в гайде, возможно это лишнее)
    }
}