package com.example.juanes24.practica4;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {
    private EditText eNombre, eCantidad, ePrecio;
    private Button bGuardar;
    private PeluchesSQLiteHelper peluchesSQLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private ContentValues dataBD;


    public AgregarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_agregar, container, false);
        eNombre = view.findViewById(R.id.eName);
        eCantidad = view.findViewById(R.id.eCant);
        ePrecio = view.findViewById(R.id.ePrecio);
        bGuardar= view.findViewById(R.id.bGuardar);

        peluchesSQLiteHelper= new PeluchesSQLiteHelper(getActivity(),
                "peluchesBD",
                null,
                1);

        sqLiteDatabase= peluchesSQLiteHelper.getWritableDatabase();

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBD= new ContentValues();
                dataBD.put("nombre", eNombre.getText().toString());
                dataBD.put("cantidad", eCantidad.getText().toString());
                dataBD.put("precio", ePrecio.getText().toString());
                sqLiteDatabase.insert("peluches", null, dataBD);
                Toast.makeText(getActivity(),"Peluche Guardado", Toast.LENGTH_SHORT).show();
                limpiarWidgets();


            }
        });
        return view;
    }

    private void limpiarWidgets() {
        eNombre.setText("");
        eCantidad.setText("");
        ePrecio.setText("");
    }

}
