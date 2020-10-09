package com.example.fifo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Option1 extends AppCompatActivity {
    float incredits = 0;
    float ingrade = 0, g = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);

        final TextView credit = findViewById(R.id.credittext);
        TextView grade = findViewById(R.id.gradetext);
        credit.setText("Credits");
        grade.setText("Grades");

        final ArrayList<String> sub = new ArrayList<String>();
        final ArrayAdapter adaptersub = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sub);
        final ListView listViewgpa = (ListView) findViewById(R.id.subs);
        listViewgpa.setAdapter(adaptersub);

        final Spinner spin = (Spinner) findViewById(R.id.credit);
        String[] credits = {"1", "2", "3", "4"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, credits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        final Spinner spin2 = (Spinner) findViewById(R.id.grade);
        String[] grades = {"O", "A+", "A", "B+", "B"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, grades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);

        final TextView gpa = (TextView)findViewById(R.id.gpa);

        Button addsub = (Button) findViewById(R.id.addsub);
        addsub.setText("Add the subject");
        addsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub.add("Credit : " + String.valueOf(spin.getSelectedItem()) + " and Grade : " + String.valueOf(spin2.getSelectedItem()));
                adaptersub.notifyDataSetChanged();
                incredits = Integer.valueOf(String.valueOf(spin.getSelectedItem()));
                switch (String.valueOf(spin2.getSelectedItem())){
                    case "O":
                        g = 10;
                        break;
                    case "A+":
                        g = 9;
                        break;
                    case "A":
                        g = 8;
                        break;
                    case "B+":
                        g = 7;
                        break;
                    case "B":
                        g = 6;
                        break;
                }
                incredits += Integer.valueOf(String.valueOf(spin.getSelectedItem()));
                ingrade += (g*Integer.valueOf(String.valueOf(spin.getSelectedItem())));
            }
        });

        Button calc = (Button) findViewById(R.id.calcgpa);
        calc.setText("Calculate the GPA");
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gpa.setText("The GPA is " + (ingrade/incredits));
            }
        });
    }
}
