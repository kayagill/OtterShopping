package com.example.ottershopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ottershopping.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;
   Button loginButton;
   Button createAccButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginButton = binding.loginButton;
        createAccButton = binding.createAccButton;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.getIntent(getApplicationContext()));
                startActivity(intent);
            }
        });

    }

    private static Intent getIntent(Context applicationContext) {
        Intent intent = new Intent(applicationContext, MainActivity.class);
        return intent;
    }
}