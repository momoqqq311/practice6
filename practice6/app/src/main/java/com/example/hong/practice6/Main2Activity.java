package com.example.hong.practice6;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2, e3, e4, e5, e6;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (Button) findViewById(R.id.cancel);
        b2 = (Button) findViewById(R.id.add);
        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.tel);
        e3 = (EditText) findViewById(R.id.menu1);
        e4 = (EditText) findViewById(R.id.menu2);
        e5 = (EditText) findViewById(R.id.menu3);
        e6 = (EditText) findViewById(R.id.homepage);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                Intent in = new Intent();
                setResult(RESULT_CANCELED, in);
                finish();
                break;
            case R.id.add:
                Intent intent = getIntent();
                ArrayList<restaurant_info> u = (ArrayList<restaurant_info>)intent.getSerializableExtra("restaurant");
                String name = e1.getText().toString();
                String tel = e2.getText().toString();
                String menu1 = e3.getText().toString();
                String menu2 = e4.getText().toString();
                String menu3 = e5.getText().toString();
                String homepage = e6.getText().toString();
                rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String kind = rb.getText().toString();
                String date = GetCurrentTime();
                u.add(new restaurant_info(name, kind, tel, menu1, menu2, menu3, homepage,date));
                intent.putExtra("add",u);
                setResult(RESULT_OK,intent);
                finish();
                break;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    String GetCurrentTime() {
        String time = "";
        Calendar cal = Calendar.getInstance();
        time = String.format("%04d%02d%02d",
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        return time;
    }
}
