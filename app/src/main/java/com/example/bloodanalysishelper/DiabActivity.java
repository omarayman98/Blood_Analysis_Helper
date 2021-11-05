package com.example.bloodanalysishelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DiabActivity extends AppCompatActivity {
    EditText Age, Weight;
    CheckBox male, female;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diab);
        Age = findViewById(R.id.Age_text);
        Weight = findViewById(R.id.weight_Text);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        button = findViewById(R.id.Bnt_result);

    }

    public void result(View view) {
        AlertDialog.Builder result = new AlertDialog.Builder(this);
        result.setTitle("Diabetes Safe Range:\n");
        result.setCancelable(true);
        if (!Age.getText().toString().trim().equals("")
                && !Weight.getText().toString().trim().equals("")
                && ((male.isChecked()&&!female.isChecked())||(!male.isChecked()&&female.isChecked()))) {
            int age = Integer.parseInt(Age.getText().toString());
            if (age <= 16) {
                // the Safe Range is 60 - 100 mg/dL
                result.setMessage("The safe Glucose Range is 60 - 100 mg/dL\n\n");
                result.show();
            } else if ( age<120) {
                // The safe Range is 70-150 mg/dL
                result.setMessage("The safe Glucose Range is 70-150 mg/dL\n\n");
                result.show();

            }else {
                Toast.makeText(this, "Please add correct Age", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Please fill Valid data", Toast.LENGTH_SHORT).show();
        }
    }
}

