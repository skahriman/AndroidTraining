package com.example.sefakkahriman.fragmentproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.sefakkahriman.fragmentproject.R;
import com.example.sefakkahriman.fragmentproject.adapter.MyAdapter;
import com.example.sefakkahriman.fragmentproject.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    Button button;
    EditText brand;
    EditText make;
    EditText year;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        //return inflater.inflate(R.layout.fragment_add, container, false);

        brand = view.findViewById(R.id.idBrand);
        make = view.findViewById(R.id.idModel);
        year = view.findViewById(R.id.idYear);

        button = view.findViewById(R.id.idAddButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = brand.getText().toString() + make.getText().toString() + year.getText().toString();

                if(str!="") {
                    Car myCar = new Car(brand.getText().toString(), make.getText().toString(), year.getText().toString());
                    MyAdapter.car.add(myCar);
                }
                //this notifies when ever data set is changed.
                MyAdapter.adapter.notifyDataSetChanged();///////////////////////////
            }
        });

        setEnterTransition(new Slide(Gravity.BOTTOM));
        return view;
    }

}
