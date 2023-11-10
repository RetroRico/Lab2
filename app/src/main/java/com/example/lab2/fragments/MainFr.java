package com.example.lab2.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lab2.R;

public class MainFr extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        Button begin_button = view.findViewById(R.id.begin_button);
        Button close_button = view.findViewById(R.id.exit_button);

        begin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoxidFr doxidFr = new DoxidFr();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, doxidFr)
                        .addToBackStack(null)
                        .commit();
            }
        });

        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
}
