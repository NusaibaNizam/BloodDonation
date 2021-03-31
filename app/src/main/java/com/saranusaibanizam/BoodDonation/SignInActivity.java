package com.saranusaibanizam.BoodDonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {

    TextInputEditText emailET;
    TextInputEditText passwordET;
    TextInputLayout passLayout;
    TextInputLayout emailLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        emailET=findViewById(R.id.userNameET);
        passwordET=findViewById(R.id.passwordET);
        passLayout=findViewById(R.id.layout_password);
        emailLayout=findViewById(R.id.layout_username);
        emailET.addTextChangedListener(getWatcher(emailLayout));
        passwordET.addTextChangedListener(getWatcher(passLayout));
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void SignIn(View view) {
        if(TextUtils.isEmpty(emailET.getText().toString())||TextUtils.isEmpty(passwordET.getText().toString())) {
            if (TextUtils.isEmpty(emailET.getText().toString())) {
                emailLayout.setError("Username or Email is required!");
            }
            if (TextUtils.isEmpty(passwordET.getText().toString())) {
                passLayout.setError("Password is required!");
            }
        }else{
            String email= emailET.getText().toString();
            String pass= passwordET.getText().toString();
            emailLayout.setError(null);
            passLayout.setError(null);
            Toast.makeText(this,"Valid",Toast.LENGTH_LONG).show();
        }
    }

    public void gotoSignUp(View view) {
        Intent intent =new Intent(SignInActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
    public TextWatcher getWatcher(TextInputLayout layout){
        TextWatcher watcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                layout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        return watcher;
    }
}