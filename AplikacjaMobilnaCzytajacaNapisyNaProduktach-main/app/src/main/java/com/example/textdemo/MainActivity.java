package com.example.textdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    private Button runButton;
    private Button showButton;
    private Button aboutButton;
    private Button addButton;
    private Button exitButtonm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runButton = (Button)findViewById(R.id.runButtonId);
        showButton = (Button)findViewById(R.id.showButtonId);
        aboutButton = (Button)findViewById(R.id.aboutButtonId);
        addButton = (Button)findViewById(R.id.addButtonId);
        exitButtonm = (Button)findViewById(R.id.exitButtonmId);

        runButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent (MainActivity.this, RunActivity.class);
                startActivityForResult(myIntent, 660);
            }
        });

        showButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent (MainActivity.this, ShowActivity.class);
                startActivityForResult(myIntent, 661);
            }
        });

        aboutButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent (MainActivity.this, AboutActivity.class);
                startActivityForResult(myIntent, 662);
            }
        });

        addButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent (MainActivity.this, AddActivity.class);
                startActivityForResult(myIntent, 663);
            }
        });

        exitButtonm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        context = getApplicationContext();
    }
}