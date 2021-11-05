package com.example.bloodanalysishelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BP_Activity extends AppCompatActivity {
    EditText AGE;
    CheckBox Male, Female;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bp_);
        AGE = findViewById(R.id.Age_text);
        Male = findViewById(R.id.Male);
        Female=findViewById(R.id.Female);
        button2=findViewById(R.id.Bnt_result);
    }

    public void bp_result(View view) {
        AlertDialog.Builder result = new AlertDialog.Builder(this);
        result.setTitle("blood pressure Safe Range:\n");
        result.setCancelable(true);

        if (!AGE.getText().toString().trim().equals("")
                &&((Male.isChecked()&&!Female.isChecked())||(!Male.isChecked()&&Female.isChecked()))) {
            int age = Integer.parseInt(AGE.getText().toString());
            if (age <= 1){
                result.setMessage("The safe Blood Pressure Range is 70/50 TO 90/65 mmHg\n\n");
                result.show();}
            else if ((age<3||age==3)){
                result.setMessage("The safe Blood Pressure Range is 90/55 To 105/70 mmHg\n\n");
                result.show();}
            else if (age>3&&age<6||age==6){
                result.setMessage("The safe Blood Pressure Range is 95/60 To 110/75 mmHg\n\n");
                result.show();}
            else if (age>6&&age<12||age==12){
                result.setMessage("The safe Blood Pressure Range is 100/60 To 120/75 mmHg\n\n");
                result.show();}
            else if (age>12&&age<=120||age==120){
                result.setMessage("The safe Blood Pressure Range is 100/70 To 120/80 mmHg\n\n");
                result.show();}
            else {
                Toast.makeText(this, "Please fill Valid data", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Please fill Valid data", Toast.LENGTH_SHORT).show();
        }
}
}
