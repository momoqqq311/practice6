package com.example.hong.practice6;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button b1;
    ListView listView;
    ArrayList<restaurant_info> restaurant = new ArrayList<restaurant_info>();
    static final int _RESULT_MSG_CODE = 100;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.add);
        listView = (ListView) findViewById(R.id.listview);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("restaurant", restaurant);
        startActivityForResult(intent, _RESULT_MSG_CODE);//양방향
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == _RESULT_MSG_CODE) {
            if (resultCode == RESULT_OK) {
                restaurant = (ArrayList) data.getSerializableExtra("add");
                //Toast.makeText(getApplicationContext(),restaurant.toString(),Toast.LENGTH_SHORT).show();
                setListview(restaurant.get(restaurant.size() - 1).getName());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void setListview(String name) {
        data.add(name);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
                dlg.setTitle("삭제 확인 ");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMessage("선택한 맛집을 삭제하겠습니까?");
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        restaurant.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(),"삭제되었습니다",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent.putExtra("restaurant", restaurant);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
