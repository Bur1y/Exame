package com.bur1y.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void SignInToSignUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void SignInToStartScreen(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}