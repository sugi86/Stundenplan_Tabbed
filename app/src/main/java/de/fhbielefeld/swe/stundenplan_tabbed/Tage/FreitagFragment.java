package de.fhbielefeld.swe.stundenplan_tabbed.Tage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.fhbielefeld.swe.stundenplan_tabbed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FreitagFragment extends Fragment {


    public FreitagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_freitag, container, false);
    }

}
