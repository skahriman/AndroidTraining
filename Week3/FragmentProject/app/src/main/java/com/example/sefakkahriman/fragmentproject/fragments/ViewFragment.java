package com.example.sefakkahriman.fragmentproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.sefakkahriman.fragmentproject.R;
import com.example.sefakkahriman.fragmentproject.adapter.MyAdapter;
import com.example.sefakkahriman.fragmentproject.model.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    ListView listView;
    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_view, container, false);

        //return inflater.inflate(R.layout.fragment_view, container, false);


        listView = view.findViewById(R.id.idOfListView);
        listView.setAdapter(MyAdapter.adapter);


        //this acts like a sliding window on view
        setEnterTransition(new Slide(Gravity.BOTTOM));
        return view;

    }





}
