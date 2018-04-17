package com.example.hidarah42.bab3;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    //Variabel global dan Objek
    private ListView LV_DB;
    private Database DB;
    private Cursor DATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //inisialisasi
        LV_DB =(ListView)findViewById(R.id.lv_db);
        DB = new Database(this);

        ArrayList <String> list = new ArrayList<>();
        DATA = DB.getData();

        if(DATA.getCount()==0){
            Toast.makeText(this, "Database error", Toast.LENGTH_SHORT).show();
        }else{
            while(DATA.moveToNext()){
                list.add(DATA.getString(0));
                list.add(DATA.getString(1));
                list.add(DATA.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
                LV_DB.setAdapter(listAdapter);
            }
        }

    }
}
