package com.example.juanes24.practica4;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment {
    private EditText eBuscar;
    private Button bBuscar;
    private TextView tNombre, tCantidad, tPrecio;
    private PeluchesSQLiteHelper peluchesSQLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;


    public BuscarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_buscar, container, false);
        eBuscar= view.findViewById(R.id.eBuscar);
        tNombre=view.findViewById(R.id.tNombre);
        tCantidad=view.findViewById(R.id.tCantidad);
        tPrecio=view.findViewById(R.id.tPrecio);
        bBuscar=view.findViewById(R.id.bBuscar);

        peluchesSQLiteHelper= new PeluchesSQLiteHelper(getActivity(),
                "peluchesBD",
                null,
                1);

        sqLiteDatabase= peluchesSQLiteHelper.getWritableDatabase();

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor= sqLiteDatabase.rawQuery("SELECT * FROM peluches WHERE nombre='"+eBuscar.getText().toString()+"'", null);

                if (cursor.moveToFirst()){
                    tCantidad.setText(cursor.getString(2));
                    tPrecio.setText(cursor.getString(3));


                }else{
                    Toast.makeText(getActivity(),"Peluche no encontrado", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

}
