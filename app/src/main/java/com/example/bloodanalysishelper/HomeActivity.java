package com.example.bloodanalysishelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btn_Analisys, btn_Bmi, btn_Dnb,btn_Bp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_Analisys= findViewById(R.id.analisys);
        btn_Bmi=findViewById(R.id.bmi);
        btn_Dnb=findViewById(R.id.diab);
        btn_Bp=findViewById(R.id.bp);
    }


    public void swap(View view) {
        int id = 0;
        Intent go;
        switch (view.getId()){
            case R.id.analisys:
                go=new Intent(this,search.class);
                startActivity(go);
                break;
            case R.id.bmi:
                go=new Intent(this,BMI_Activity.class);
                startActivity(go);
                break;
            case R.id.diab:
                go=new Intent(this,DiabActivity.class);
                startActivity(go);
                break;
            case R.id.bp :
                go=new Intent(this,BP_Activity.class);
                startActivity(go);
                break;
        }

    }
}
