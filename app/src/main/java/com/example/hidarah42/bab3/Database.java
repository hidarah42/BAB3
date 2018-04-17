package com.example.hidarah42.bab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hidarah42 on 16/04/18.
 */

public class Database extends SQLiteOpenHelper {

    //Variabel Global
    private static final String TAG = "Databasenya";
    private static final String TABLE_NAME = "DB";
    private static final String Col1 = "ID";
    private static final String Col2 = "nama";
    private static final String Col3 = "pekerjaan";

    public Database(Context context) {
        super(context, TABLE_NAME ,null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String buatdb = "CREATE TABLE "+TABLE_NAME+" ("+Col1+" varchar(44), "+Col2+" varchar(44), "+Col3+" varchar(44))";
        db.execSQL(buatdb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXITS "+TABLE_NAME);
        onCreate(db);
    }

    //Method menambahkan data
    public void add(String item1, String item2, String item3){
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1,item1);
        contentValues.put(Col2,item2);
        contentValues.put(Col3,item3);

        try{
            db.insert(TABLE_NAME,null,contentValues);
            Log.d(TAG,"Data "+item1+" "+item2+" "+item3+" "+" berhasil dimasukan ke "+TABLE_NAME);
        }catch (Exception e){
            Log.d("error",""+e);
        }
    }

    //Method mengambil data
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        Log.d("isidata",""+res);

        return res;
    }
}
