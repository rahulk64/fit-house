package com.jagre.godark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryActivity extends AppCompatActivity {

    Button addButton;
    Button cancelButton;
    EditText mEdit1;
    EditText mEdit2;
    public static double myScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        addButton = (Button)findViewById(R.id.runOptionsBtn);
        cancelButton = (Button)findViewById(R.id.cancelOptionsBtn);
        mEdit1   = (EditText)findViewById(R.id.editText1);
        mEdit2   = (EditText)findViewById(R.id.editText2);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    myScore += Double.parseDouble(mEdit1.getText().toString());
                    myScore += Double.parseDouble(mEdit2.getText().toString());
                }
                catch (Exception e){
                    finish();
                }
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                finish();

            }
        });

    }
}
