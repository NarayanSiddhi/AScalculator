package com.example.collegenewsaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText loginuser,loginpass;
    Button loginbtn,tvSignUp;
    Integer clickCount=0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle bundle=getIntent().getExtras();
        String signupUsername = bundle.getString("Username");
        String signupPassword = bundle.getString("Password");
        BindUIElements();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginUsername = loginuser.getText().toString();
                String loginPassword = loginpass.getText().toString();
                if(clickCount < 2) {
                    if(loginUsername.equals(signupUsername) && loginPassword.equals(signupPassword)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(LoginActivity.this, NewsFeedActivity.class);
                                startActivity(intent);
                            }
                        },2000);
                    }
                    else {
                        clickCount++;
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, "Failed Login Attempt", Toast.LENGTH_SHORT).show();
                    loginbtn.setEnabled(false);
                }
            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the sign-up activity
                Intent intent = new Intent(LoginActivity.this, NewsFeedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void BindUIElements() {
        loginuser = (EditText) findViewById(R.id.uname);
        loginpass = (EditText) findViewById(R.id.pass);
        loginbtn = (Button) findViewById(R.id.logbtn);
        tvSignUp=(Button) findViewById(R.id.directsignup);
    }
}
