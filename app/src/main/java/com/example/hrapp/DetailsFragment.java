// DetailsFragment.java

package com.example.hrapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.internal.NavigationMenu;

public class DetailsFragment extends Fragment {

    private static final String ARGUMENT_NAME = "name";
    private static final String ARGUMENT_PHONE_NUMBER = "phoneNumber";
    private static final String ARGUMENT_BE = "be";
    private static final String ARGUMENT_ME = "me";
    private static final String ARGUMENT_PHD = "phd";
    private static final String ARGUMENT_POSITION = "position";

    public DetailsFragment() {
    }

    public static DetailsFragment newInstance(String name, String phoneNumber, boolean be, boolean me, boolean phd, String position) {
        DetailsFragment fragment = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT_NAME, name);
        bundle.putString(ARGUMENT_PHONE_NUMBER, phoneNumber);
        bundle.putBoolean(ARGUMENT_BE, be);
        bundle.putBoolean(ARGUMENT_ME, me);
        bundle.putBoolean(ARGUMENT_PHD, phd);
        bundle.putString(ARGUMENT_POSITION, position);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_details, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            TextView content = root.findViewById(R.id.content);
            content.setText(
                    "Name: " + bundle.getString(ARGUMENT_NAME) + "\n" +
                    "Phone Number: " + bundle.getString(ARGUMENT_PHONE_NUMBER) + "\n" +
                    "B.E.: " + bundle.getBoolean(ARGUMENT_BE) + "\n" +
                    "M.E.: " + bundle.getBoolean(ARGUMENT_ME) + "\n" +
                    "PhD: " + bundle.getBoolean(ARGUMENT_PHD) + "\n" +
                    "Position: " + bundle.getString(ARGUMENT_POSITION)
            );
        }



        return root;
    }
}