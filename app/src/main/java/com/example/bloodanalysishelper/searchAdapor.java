package com.example.bloodanalysishelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class searchAdapor extends ArrayAdapter<Analysis> {
    public searchAdapor(@NonNull Context context, @NonNull ArrayList<Analysis> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from((getContext())).inflate(R.layout.row, parent, false);
        ConstraintLayout row =convertView.findViewById(R.id.row);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        tv_name.setText(getItem(position).getName());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getContext(),details.class);
                Bundle b=new Bundle();
                b.putString("Analysis_name",getItem(position).getName());
                b.putInt("Analysis_Image",getItem(position).getImage());
                go.putExtras(b);
                v.getContext().startActivity(go);
            }
        });


        return convertView;
    }}
