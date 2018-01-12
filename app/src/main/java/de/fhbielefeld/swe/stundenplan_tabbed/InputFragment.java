package de.fhbielefeld.swe.stundenplan_tabbed;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    Button buttonadd;
    EditText InputSemester;
    EditText InputName;
    Spinner InputTag;
    EditText InputBeginn;
    EditText InputEnde;
    EditText InputRaum;
    EditText InputDozent;
    EditText InputKuerzel;
    EditText tmp;




    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        InputSemester = (EditText) view.findViewById(R.id.input_semester);
        InputName = (EditText) view.findViewById(R.id.input_name);
        InputTag = (Spinner) view.findViewById(R.id.input_tag);

        InputBeginn = (EditText) view.findViewById(R.id.input_beginn);
        InputEnde = (EditText) view.findViewById(R.id.input_ende);
        InputRaum = (EditText) view.findViewById(R.id.input_raum);
        InputDozent = (EditText)  view.findViewById(R.id.input_dozent);
        InputKuerzel = (EditText) view.findViewById(R.id.input_kuerzel);
        buttonadd = (Button) view.findViewById(R.id.button_input);



        final MainActivity activity = (MainActivity) getActivity();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.tage_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        InputTag.setAdapter(adapter);

        InputTag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tmp.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                activity.addFach(InputSemester.getText().toString(), InputName.getText().toString(), tmp.getText().toString(), InputBeginn.getText().toString(), InputEnde.getText().toString(),
                        InputRaum.getText().toString(), InputDozent.getText().toString(), InputKuerzel.getText().toString(), true);

                InputSemester.setText("Semester");
                InputName.setText("Name");
                InputBeginn.setText("Beginn");
                InputEnde.setText("Ende");
                InputRaum.setText("Raum");
                InputDozent.setText("Dozent");
                InputKuerzel.setText("Kuerzel");
                InputSemester.requestFocus();
                InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(InputSemester.getWindowToken(),0);
            }
        });


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

}
