package com.jagre.godark;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    int clickCounter=0;
    private ListView mListView;
    public static ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

                        .setAction("Action", null).show();
            }
        });

        mListView = (ListView) findViewById(R.id.list);

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listItems);
        mListView.setAdapter(adapter);

        Intent intent1 = getIntent();
        String action = intent1.getAction();
        String type = intent1.getType();
        if (intent1.hasExtra("new_friend")) {
            //do something
            listItems.add(intent1.getExtras().getString("new_friend"));
            adapter.notifyDataSetChanged();
        }
    }



}
