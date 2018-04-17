package com.example.hidarah42.bab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variabel Global
    private EditText ID,Nama,Pekerjaan;
    private Button Login,View;

    private Database databasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisisialisasi
        ID = (EditText)findViewById(R.id.et_id);
        Nama = (EditText)findViewById(R.id.et_nama);
        Pekerjaan = (EditText)findViewById(R.id.et_pekerjaan);
        Login = (Button)findViewById(R.id.btn_insert);
        View = (Button)findViewById(R.id.btn_view);
        databasenya = new Database(this);

        //Login
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = ID.getText().toString();
                String nama = Nama.getText().toString();
                String pekerjaan = Pekerjaan.getText().toString();

                if (id.isEmpty()||nama.isEmpty()||pekerjaan.isEmpty()){
                    Toast.makeText(MainActivity.this, "Harap isi field yang kosong", Toast.LENGTH_SHORT).show();
                }else{
                    databasenya.add(id,nama,pekerjaan);
                    ID.setText("");
                    Nama.setText("");
                    Pekerjaan.setText("");
                    Toast.makeText(MainActivity.this, "Database berhasil disimpan", Toast.LENGTH_SHORT).show();
                    Log.d("Status", "berhasil");
                }
            }
        });

        //View
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewActivity.class));
            }
        });


    }
}
