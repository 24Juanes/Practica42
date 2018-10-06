package com.example.juanes24.practica4;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EliminarFragment extends Fragment {
    private EditText eNombre;
    private Button bEliminar;
    private PeluchesSQLiteHelper peluchesSQLiteHelper;
    private SQLiteDatabase sqLiteDatabase;


    public EliminarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_eliminar, container, false);

        eNombre= view.findViewById(R.id.eEliminar);
        bEliminar =view.findViewById(R.id.bEliminar);

        bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int band= sqLiteDatabase.delete("peluches","nombre='" +eNombre.getText().toString()+"'",null);
                if (band==0){
                    Toast.makeText(getActivity(),"Peluche no existe", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Peluche borrado", Toast.LENGTH_SHORT).show();
                }
                Log.d("band",String.valueOf(band));
                limpiarWidgets();


            }
        });
        return view;
    }

    private void limpiarWidgets() {
        eNombre.setText("");

    }

}
