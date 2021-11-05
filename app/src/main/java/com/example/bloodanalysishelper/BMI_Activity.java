package com.example.bloodanalysishelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.Toast;

import com.jsibbold.zoomage.AutoResetMode;

public class BMI_Activity extends AppCompatActivity {
    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(20, (Color.parseColor("#EE0606"))).setLabel("UnderWeight(0-18.5)"));
        pieData.add(new SliceValue(20, (Color.parseColor("#42C922"))).setLabel("Normal(18.5-25)"));
        pieData.add(new SliceValue(20, (Color.parseColor("#670F9E"))).setLabel("OverWeight(25-30)"));
        pieData.add(new SliceValue(20, (Color.parseColor("#E91795"))).setLabel("Obese(30-35)"));
        pieData.add(new SliceValue(20, (Color.parseColor("#4B4441"))).setLabel("Extremely Obese(35-50)"));


        PieChartData pieChartData=new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(10);
        pieChartData.setHasCenterCircle(true);
        pieChartView.setPieChartData(pieChartData);

    }

    public void result(View view) {
        EditText editTextheight=findViewById(R.id.h);
        EditText editTextweight=findViewById(R.id.w);


        AlertDialog.Builder result = new AlertDialog.Builder(this);
        result.setTitle("Your BMI Test Result:\n");
        result.setCancelable(true);


        if (!editTextweight.getText().toString().equals("")||!editTextheight.getText().toString().equals("")){
            double w =Double.parseDouble(editTextweight.getText().toString());
            double h =Double.parseDouble(editTextheight.getText().toString());
            double bmi_result = w/(h*h);
            double to_be_perfect =25*(h*h);


        if (w<1||w>220||h>3||h<0.5){
             Toast.makeText(this, "Please fill Valid Values ", Toast.LENGTH_SHORT).show();
        }else{
            if (bmi_result<18.5){

                result.setMessage("OPS..!\nYou're Underweight\nYou'r BMI result is "+bmi_result+"\nYou need to be "+to_be_perfect+"KG.");

                result.show();

            }else if (25>=bmi_result&&bmi_result>18.5){

                result.setMessage("OH,Great!\nYou're Normal\n");
                result.show();

            }else if (30>=bmi_result&&bmi_result>25){

                result.setMessage("OPS..!\nYou're Overweight\nYou'r BMI result is"+bmi_result+"\nYou need to be "+to_be_perfect+"KG.");
                result.show();

            }else if (35>=bmi_result&&bmi_result>30){

                result.setMessage("OPS..!\nYou're Obese\nYou'r BMI result is"+bmi_result+"\nYou need to be "+to_be_perfect+"KG.");
                result.show();

            } else if (bmi_result>35){

                result.setMessage("OPS..!\nYou're ExtremelyObese\nYou'r BMI result is"+bmi_result+"\\nYou need to be "+to_be_perfect+"KG.");
                result.show();


            }else if (bmi_result<0||bmi_result>50){
                Toast.makeText(this, "Please fill Valid Values", Toast.LENGTH_SHORT).show();
            }
        }}else {
            Toast.makeText(this, "Please fill Valid Values", Toast.LENGTH_SHORT).show();
        }
    }
}
