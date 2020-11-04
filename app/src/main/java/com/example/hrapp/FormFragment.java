// FormFragment.java

package com.example.hrapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class FormFragment extends Fragment {

    public FormFragment() {
    }

    public static FormFragment newInstance() {
        return new FormFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_form, container, false);

        EditText name = root.findViewById(R.id.name);
        EditText phoneNumber = root.findViewById(R.id.phoneNumber);
        CheckBox be = root.findViewById(R.id.be);
        CheckBox me = root.findViewById(R.id.me);
        CheckBox phd = root.findViewById(R.id.phd);

        Spinner position = root.findViewById(R.id.position);
        ArrayAdapter<CharSequence> positionAdapter = ArrayAdapter.createFromResource(getContext(), R.array.positions, android.R.layout.simple_spinner_item);
        positionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        position.setAdapter(positionAdapter);

        Button applyButton = root.findViewById(R.id.apply);
        applyButton.setOnClickListener(view -> {
            FormFragmentCallback callback = (FormFragmentCallback)getActivity();
            callback.onApply(name.getText().toString(), phoneNumber.getText().toString(), be.isChecked(), me.isChecked(),
                    phd.isChecked(), (String)position.getSelectedItem());
        });

        return root;
    }
}