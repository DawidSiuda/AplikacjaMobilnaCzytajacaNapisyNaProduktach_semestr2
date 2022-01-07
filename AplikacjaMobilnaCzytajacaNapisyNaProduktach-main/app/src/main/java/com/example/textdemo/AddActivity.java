package com.example.textdemo;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private int duration = Toast.LENGTH_SHORT;
    private Context context;

    DatabaseAccess databaseAccess;
    Button buttonAdd;
    EditText textNumber;
    EditText textName;
    EditText textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        buttonAdd = (Button)findViewById(R.id.buttonId);
        textNumber = (EditText)findViewById(R.id.textNumberId);
        textName = (EditText)findViewById(R.id.textNameId);
        textDescription = (EditText)findViewById(R.id.textDescriptionId);
        databaseAccess = DatabaseAccess.getInstance(this);

        buttonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validation
                Boolean dataOk = true;

                int number = 0;
                try {
                    number = Integer.parseInt(textNumber.getText().toString());
                }
                catch (NumberFormatException e) {
                    dataOk = false;
                    Toast.makeText(context, "Wrong data", duration).show();
                }

                String name = textName.getText().toString();
                String description = textDescription.getText().toString();

                if (dataOk)
                {
                    databaseAccess.open();
                    String output = databaseAccess.addNewIngredient(number, name, description);
                    databaseAccess.close();

                    textNumber.setText("");
                    textName.setText("");
                    textDescription.setText("");
                }
            }
        });

        context = getApplicationContext();
    }
};
