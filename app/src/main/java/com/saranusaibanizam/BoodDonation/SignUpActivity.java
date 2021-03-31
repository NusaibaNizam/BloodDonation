package com.saranusaibanizam.BoodDonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText userET;
    TextInputEditText emailET;
    TextInputEditText passET;
    TextInputLayout userLayout;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;
    TextView letUsTV;
    TextView provideTV;
    boolean second;
    boolean third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userET=findViewById(R.id.userNameET);
        emailET=findViewById(R.id.emailET);
        passET=findViewById(R.id.passwordET);
        userLayout=findViewById(R.id.layout_username);
        emailLayout=findViewById(R.id.layout_email);
        passLayout=findViewById(R.id.layout_password);
        userET.addTextChangedListener(getWatcher(userLayout));
        emailET.addTextChangedListener(getWatcher(emailLayout));
        passET.addTextChangedListener(getWatcher(passLayout));
        letUsTV=findViewById(R.id.letUsTV);
        provideTV=findViewById(R.id.provideTV);

        Intent reIntent=getIntent();
        second=reIntent.getBooleanExtra("1stNext",false);
        third=reIntent.getBooleanExtra("address",false);
        if(second){
            letUsTV.setText("Contact Information");
            provideTV.setText("Please proved correct phone no. This information will keep safe");
            userLayout.setHint("Phone No");
            userET.setInputType(InputType.TYPE_CLASS_PHONE);
            emailLayout.setHint("Alternative Phone No");
            emailET.setInputType(InputType.TYPE_CLASS_PHONE);
            passLayout.setHint("Social(Optional)");
            passLayout.setPasswordVisibilityToggleEnabled(false);
            passET.setInputType(InputType.TYPE_CLASS_TEXT);
        }else if(third){
            letUsTV.setText("Where Do you Live?");
            provideTV.setText("Please proved correct phone no. This information will keep safe");
            userLayout.setHint("Street Address");
            userET.setInputType(InputType.TYPE_CLASS_TEXT);
            emailLayout.setHint("City");
            emailET.setInputType(InputType.TYPE_CLASS_TEXT);
            passLayout.setHint("Postal Code");
            passLayout.setPasswordVisibilityToggleEnabled(false);
            passET.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void SignUp(View view) {
        if(TextUtils.isEmpty(emailET.getText().toString())||TextUtils.isEmpty(userET.getText().toString())
                ||(TextUtils.isEmpty(passET.getText().toString()) && !second)) {
            if (TextUtils.isEmpty(emailET.getText().toString())) {
                emailLayout.setError("Required!");
            }
            if (TextUtils.isEmpty(passET.getText().toString()) && !second) {
                passLayout.setError("Required!");
            }
            if (TextUtils.isEmpty(userET.getText().toString())) {
                userLayout.setError("Required!");
            }

        }else if(third){
            addressInfo();
        }
        else if(second) {
                contactInfo();
        }
        else {
            emailPassInfo();
        }
    }

    private void addressInfo() {
        emailLayout.setError(null);
        userLayout.setError(null);
        passLayout.setError(null);
        Intent intent=new Intent(SignUpActivity.this,AgeActivity.class);
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
    void emailPassInfo(){
        userLayout.setError(null);
        String user=userET.getText().toString();
        String email=emailET.getText().toString();
        String pass=passET.getText().toString();
        Pattern specialChar = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = specialChar.matcher(pass);
        if(!email.contains("@")||!email.contains(".")){
            emailLayout.setError("Invalid Email");
        }else {
            emailLayout.setError(null);
            if (pass.length() < 8) {
                passLayout.setError("Password must have at least 8 characters!");
            } else if (!pass.matches(".*[a-z].*")) {
                passLayout.setError("Password must have at least 1 small letter!");
            } else if (!pass.matches(".*[A-Z].*")) {
                passLayout.setError("Password must have at least 1 capital letter!");
            } else if (!pass.matches(".*[0-9].*")) {
                passLayout.setError("Password must have at least 1 number!");
            } else if (!m.find()) {
                passLayout.setError("Password must have at least 1 special character!");
            } else {
                passLayout.setError(null);
                Intent intent=new Intent(SignUpActivity.this,SignUpActivity.class);
                intent.putExtra("1stNext",true);
                startActivity(intent);
            }
        }
    }
    void contactInfo(){
        emailLayout.setError(null);
        userLayout.setError(null);
        Intent intent=new Intent(SignUpActivity.this,BloodGroupActivity.class);
        startActivity(intent);
    }
}