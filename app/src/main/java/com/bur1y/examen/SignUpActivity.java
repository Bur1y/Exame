package com.bur1y.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {

    EditText EditText_Password;
    EditText EditText_PasswordTrust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText_Password = findViewById(R.id.EditText_Password);
        EditText_PasswordTrust = findViewById(R.id.EditText_PasswordTrust);
    }

    public void TrustPassword(View view) {
        if(EditText_Password.getText().toString().equals(EditText_PasswordTrust.getText().toString())){
            Intent SignUpToSignIn = new Intent(this,SignInActivity.class);
            startActivity(SignUpToSignIn);
            finish();
        } else {
            //Toast
        }
    }
}