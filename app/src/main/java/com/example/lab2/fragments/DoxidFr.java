package com.example.lab2.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lab2.R;


public class DoxidFr extends Fragment {
    private EditText Textdoxid,Textpercent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.doxid_fragment, container, false);
        Textdoxid = view.findViewById(R.id.doxid_EditText);
        Textpercent = view.findViewById(R.id.percent_EditText);
        Button next_button = view.findViewById(R.id.next_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doxid = Textdoxid.getText().toString();
                String percent = Textpercent.getText().toString();

                if (doxid.isEmpty()) {
                     Toast.makeText(getActivity(), "Значення <Дохiд> має бути заповненним.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (percent.isEmpty()) {
                    Toast.makeText(getActivity(), "Значення <Процент> має бути заповненним.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double percentValue;
                    percentValue = Double.parseDouble(percent);
                    if (percentValue < 0 || percentValue > 1) {
                        Toast.makeText(getActivity(), "Значение <Процент> должно быть от 0 до 1.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                ValuesFr valuesFr = new ValuesFr();
                Bundle args = new Bundle();
                args.putString("doxid", doxid);
                args.putString("percent", percent);
                valuesFr.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, valuesFr)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
