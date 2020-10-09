package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText mTextUsername,mTextPassword,mTextcPassword,fname,lname,dept,year;
    Button mButtonRegister;
    TextView mTextViewLogin;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        db=new DatabaseHelper(this);
        mTextUsername=(EditText)findViewById(R.id.run);
        mTextPassword=(EditText)findViewById(R.id.rp);
        mTextcPassword=(EditText)findViewById(R.id.rcp);
        fname=(EditText)findViewById(R.id.rfn);
        lname=(EditText)findViewById(R.id.rln);
        dept=(EditText)findViewById(R.id.rd);
        year=(EditText)findViewById(R.id.ry);
        mButtonRegister=(Button) findViewById(R.id.register);
        mTextViewLogin=(TextView)findViewById(R.id.rlogin);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextcPassword.getText().toString().trim();
                String fn=fname.getText().toString().trim();
                String ln=lname.getText().toString().trim();
                String d=dept.getText().toString().trim();
                String y=year.getText().toString().trim();


                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd,fn,ln,d,y);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }

        });

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
