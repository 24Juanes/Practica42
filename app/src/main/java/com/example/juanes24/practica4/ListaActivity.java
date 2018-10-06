package com.example.juanes24.practica4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    private PeluchesSQLiteHelper peluchesSQLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;
    private ArrayList <Peluches> listPeluches;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterPeluches adapterPeluches;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        listPeluches = new ArrayList<>();

        adapterPeluches= new AdapterPeluches(listPeluches);
        recyclerView.setAdapter(adapterPeluches);



        loadData();
    }

    private void loadData() {
        peluchesSQLiteHelper= new PeluchesSQLiteHelper(this,
                "peluchesBD",
                null,
                1);

        sqLiteDatabase= peluchesSQLiteHelper.getWritableDatabase();
        cursor= sqLiteDatabase.rawQuery("SELECT * FROM peluches",null);

        if (cursor.moveToFirst()){
            do{
                Peluches peluches= new Peluches(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                listPeluches.add(peluches);
            }while (cursor.moveToNext());
            adapterPeluches.notifyDataSetChanged();


        }else{
            Toast.makeText(this,"Lista Vacía", Toast.LENGTH_SHORT).show();
        }
    }
}
