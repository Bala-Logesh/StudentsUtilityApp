package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText mTextUsername,mTextPassword;
    Button mButtonLogin,mButtonRegister;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db=new DatabaseHelper(this);
        mTextUsername=(EditText)findViewById(R.id.lun);
        mTextPassword=(EditText)findViewById(R.id.lp);
        mButtonLogin=(Button) findViewById(R.id.login);
        mButtonRegister = (Button) findViewById(R.id.register);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user = mTextUsername.getText().toString();
                    String pwd = mTextPassword.getText().toString();

                    if(user.equals("abcd") && pwd.equals("1234"))
                    {
                        Intent a= new Intent(LoginActivity.this,RegisterOptions.class);
                        startActivity(a);
                    }
                    else {
                        Boolean res = db.checkUser(user, pwd);
                        if (res == true) {
                            Intent a = new Intent(LoginActivity.this, options.class);
                            startActivity(a);
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(a);
            }
        });


    }
}
