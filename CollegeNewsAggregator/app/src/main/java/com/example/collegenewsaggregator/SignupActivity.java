package com.example.collegenewsaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText signuser,signpass,regno,email,course;
    Button btnsign,tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        BindUIElements();

        btnsign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                String username=signuser.getText().toString();
                String password=signpass.getText().toString();
                String regnum=regno.getText().toString();
                String emailid=email.getText().toString();
                String courses=course.getText().toString();

                String specialCharRegex=".*[@#$!%^&+=].*";
                String upperCaseRegex=".*[A-Z].*";
                String numberRegex=".*[0-9].*";
                String lowerCaseRegex=".*[a-z].*";

                if(username.length() <=0 && password.length() <=0){
                    Toast.makeText(SignupActivity.this,"Username or Password cannot be empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!password.matches(specialCharRegex)){
                        Toast.makeText(SignupActivity.this,"Password should contain special characters",Toast.LENGTH_SHORT).show();
                    }
                    else if(!password.matches(upperCaseRegex)){
                        Toast.makeText(SignupActivity.this,"Password should contain uppercase letters",Toast.LENGTH_SHORT).show();
                    }
                    else if(!password.matches(numberRegex)){
                        Toast.makeText(SignupActivity.this,"Password should contain numbers",Toast.LENGTH_SHORT).show();
                    }
                    else if(!password.matches(lowerCaseRegex)){
                        Toast.makeText(SignupActivity.this,"Password should contain lower case letters",Toast.LENGTH_SHORT).show();
                    }
                    else if(password.length()<8){
                        Toast.makeText(SignupActivity.this,"Password should be more than 8 characters",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Bundle bundle=new Bundle();
                        bundle.putString("Username",username);
                        bundle.putString("Password",password);

                        Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the login activity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    private void BindUIElements(){
        signuser=(EditText) findViewById(R.id.uname);
        signpass=(EditText) findViewById(R.id.pass);
        regno=(EditText)findViewById(R.id.regnum);
        email=(EditText)findViewById(R.id.email);
        course=(EditText)findViewById(R.id.course);
        btnsign=(Button) findViewById(R.id.signbtn);
        tvLogin=(Button) findViewById(R.id.directlogin);
    }
}