package com.example.hong.practice6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    TextView t[] = new TextView[7];
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t[0] = (TextView) findViewById(R.id.restaurant_name);
        t[1] = (TextView) findViewById(R.id.menu1);
        t[2] = (TextView) findViewById(R.id.menu2);
        t[3] = (TextView) findViewById(R.id.menu3);
        t[4] = (TextView) findViewById(R.id.restaurant_tel);
        t[5] = (TextView) findViewById(R.id.restaurant_homepage);
        t[6] = (TextView) findViewById(R.id.restaurant_date);
        image = (ImageView) findViewById(R.id.restaurant_image);
        Intent intent = getIntent();
        ArrayList<restaurant_info> u = (ArrayList<restaurant_info>) intent.getSerializableExtra("restaurant");
        int position = (int) intent.getIntExtra("position", 1);
        int size = u.get(position).resaurant_array().length;
        for(int i=0;i<size-1;i++){
            t[i].setText(u.get(position).resaurant_array()[i]);
        }

        if (u.get(position).kind.equals("한식")) {
            image.setImageResource(R.drawable.bossam);
        } else if (u.get(position).kind.equals("일식")) {
            image.setImageResource(R.drawable.susi);
        } else if (u.get(position).kind.equals("중식")) {
            image.setImageResource(R.drawable.china);
        } else {
            image.setImageResource(R.drawable.spagetti);
        }

    }public void onClick(View v){
        switch (v.getId()){
            case R.id.gotocall:
                String tel = "tel:/"+t[4].getText().toString()+"";
                Intent in1 = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
                startActivity(in1);
                break;
            case R.id.gotohompage:
                String homepage = "http://"+t[5].getText().toString();
                Intent in2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(homepage));
                startActivity(in2);
                break;
            case R.id.back:
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
                break;

        }
    }
}
