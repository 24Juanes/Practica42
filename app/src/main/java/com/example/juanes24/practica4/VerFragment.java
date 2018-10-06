package com.example.juanes24.practica4;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerFragment extends Fragment {
    private TextView tVista;
    private Button bInventario;


    public VerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ver, container, false);

        tVista= view.findViewById(R.id.textView3);
        bInventario = view.findViewById(R.id.bInventario);

        bInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getActivity(), ListaActivity.class);
                startActivity(i);

            }
        });
        return view;

    }

}
