package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterOptions extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_options);

        t1=(TextView)findViewById(R.id.tdadd);
        t2=(TextView)findViewById(R.id.tdview);
        t3=(TextView)findViewById(R.id.contadd);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(RegisterOptions.this,RegisterActivity.class);
                startActivity(a);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(RegisterOptions.this,Option1.class);
                startActivity(b);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c=new Intent(RegisterOptions.this,Option2.class);
                startActivity(c);
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(RegisterOptions.this,Option3.class);
                startActivity(d);
            }
        });
    }


}