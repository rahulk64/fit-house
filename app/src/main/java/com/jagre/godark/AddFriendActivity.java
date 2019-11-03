package com.jagre.godark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddFriendActivity extends AppCompatActivity {

    Button addButton;
    Button cancelButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        addButton = (Button)findViewById(R.id.runOptionsBtn);
        cancelButton = (Button)findViewById(R.id.cancelOptionsBtn);
        mEdit   = (EditText)findViewById(R.id.editText);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent optionsIntent = new Intent(AddFriendActivity.this, FriendsActivity.class);
                optionsIntent.putExtra("new_friend", mEdit.getText().toString());
                startActivity(optionsIntent);

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                finish();

            }
        });

    }


}
