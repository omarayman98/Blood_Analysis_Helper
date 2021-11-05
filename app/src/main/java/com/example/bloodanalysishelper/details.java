package com.example.bloodanalysishelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class details extends AppCompatActivity {
    Intent go;
    Bundle bundle;
    TextView tv_Aname;
    ImageView iv_Aname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv_Aname =findViewById(R.id.tv_Aname);
        iv_Aname=findViewById(R.id.iv_Aname);
        bundle = getIntent().getExtras();
        int image =bundle.getInt("Analysis_Image");
        String name = bundle.getString("Analysis_name");
        tv_Aname.setText(""+name);
        iv_Aname.setImageResource(image);


    }
}
