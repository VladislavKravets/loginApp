package com.example.loginapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainWindowActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        TextView loginText = findViewById(R.id.login_text);
        TextView full_name = findViewById(R.id.full_name_text);
        TextView group = findViewById(R.id.group_name_text);
        final Bundle arguments = getIntent().getExtras();
        User user = (User) arguments.getSerializable(User.class.getSimpleName());
        loginText.setText("Привіт: " + user.getLogin());
        full_name.setText("Вас звати: " + user.getFull_name());
        group.setText("Ваша група: " + user.getGroup());
    }

    public void click_logout_button(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}