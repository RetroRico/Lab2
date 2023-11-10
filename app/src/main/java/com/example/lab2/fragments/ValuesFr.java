package com.example.lab2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lab2.R;
import com.example.lab2.Service.CalcService;

public class ValuesFr extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.values_fragment, container, false);
        Spinner spinner = view.findViewById(R.id.valute_choice_Spinner);
        Button result_button = view.findViewById(R.id.result_button);

        Bundle args = getArguments();
        String doxid = args.getString("doxid");
        String percent = args.getString("percent");

        String[] types = {"Euro", "Dollar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, types);
        spinner.setAdapter(adapter);

        result_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultFr resultFr = new ResultFr();
                String valut = spinner.getSelectedItem().toString();
                Intent intent = new Intent(requireActivity(), CalcService.class);
                intent.putExtra("valut",valut);
                intent.putExtra("doxid",doxid);
                intent.putExtra("percent",percent);
                requireActivity().startService(intent);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, resultFr)
                        .addToBackStack(null)
                        .commit();

            }
        });

        return view;
    }
}
