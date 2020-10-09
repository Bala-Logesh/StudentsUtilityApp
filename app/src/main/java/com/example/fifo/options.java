package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class options extends AppCompatActivity {

    TextView option1,option2,option3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        option1=(TextView)findViewById(R.id.op1);
        option2=(TextView)findViewById(R.id.op2);
        option3=(TextView)findViewById(R.id.op3);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a=new Intent(options.this,Option1.class);
                startActivity(a);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent b=new Intent(options.this,Option2.class);
                startActivity(b);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent c=new Intent(options.this,Option3.class);
                startActivity(c);
            }
        });
    }
}
