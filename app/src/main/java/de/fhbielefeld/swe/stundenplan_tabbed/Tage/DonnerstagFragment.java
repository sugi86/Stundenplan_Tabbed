package de.fhbielefeld.swe.stundenplan_tabbed.Tage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.fhbielefeld.swe.stundenplan_tabbed.R;


public class DonnerstagFragment extends Fragment {


    public DonnerstagFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donnerstag, container, false);
    }
}
