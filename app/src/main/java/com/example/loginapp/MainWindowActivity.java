package com.example.loginapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainWindowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        TextView loginText = findViewById(R.id.login_text);
        Bundle arguments = getIntent().getExtras();
        User user = (User) arguments.getSerializable(User.class.getSimpleName());
        loginText.setText("hello " + user.getLogin());
    }
}