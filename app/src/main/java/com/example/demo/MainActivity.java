package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button incre,Res,Remove;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = findViewById(R.id.text1);
        incre = findViewById(R.id.bt1);
        Res = findViewById(R.id.bt2);
        Remove = findViewById(R.id.bt3);


        sharedPreferences = getSharedPreferences("Name" ,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        incre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer c = sharedPreferences.getInt("mark",0);
                c = c+1;
                editor.putInt("mark",c);
                editor.commit();
                Toast.makeText(getApplicationContext(), String.valueOf(c), Toast.LENGTH_SHORT).show();

                }
            });

        Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer c = 100;
                editor.putInt("mark",c);
                editor.commit();
                Toast.makeText(getApplicationContext(), "hello2", Toast.LENGTH_SHORT).show();
            }
        });

        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("mark");
                editor.commit();
            }
        });

    }
}