package com.example.textdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.textdemo.R;

public class AboutActivity extends Activity implements View.OnClickListener {

    private TextView textAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textAbout = (TextView)findViewById(R.id.textAboutId);

        textAbout.setText(" Author:\n     Dawid Siuda\n\n"
                +" Index:\n     235069\n\n"
                +" Description: \n     Application to scan product\n     ingredients and shwo information\n     about them, \n\n"
                +" Used libraries: \n     com.google.firebase\n     com.readystatesoftware.sqliteasset.SQLiteAssetHelper");
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}