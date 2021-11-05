package com.example.bloodanalysishelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class search extends AppCompatActivity {
    EditText et_search;
    Intent go;
    ArrayList<Analysis> AllAnalysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        et_search = findViewById(R.id.et_search);

    }

    public void search(View view) {
        String SearchKeyWord = et_search.getText().toString().trim();
        if(!SearchKeyWord.equals("")){
        go = new Intent(this,SearchResult.class);
        go.putExtra("SearchKeyWord",SearchKeyWord);
        startActivity(go);
        }else {
            Toast.makeText(this,"Please Enter a correct Value",Toast.LENGTH_LONG).show();
        }
    }

        public void viewall(View view){
            go = new Intent(this,SearchResult.class);
            String ViewAll ="ViewAll";
            go.putExtra("ViewAll",ViewAll);
            startActivity(go);

        }

}
