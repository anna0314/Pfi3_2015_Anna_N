package com.example.loki.assignment_4;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentDialog extends DialogFragment implements View.OnClickListener{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog, container, false);
               v.setOnClickListener(this);

/*      Spinner spinner = (Spinner)v.findViewById(R.id.spinner_book_names);
        spinner.setOnItemSelectedListener(this); //This class implements OnItemSelectedListenr
        Spinner spinner2 = (Spinner)v.findViewById(R.id.spinner_other_book_names);
        ArrayAdapter<Planet> planetAdapter = new ArrayAdapter<Planet>(this.getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                FragmentList.planets);
        spinner2.setAdapter(planetAdapter);
        spinner2.setOnItemSelectedListener(this);*/
        return v;
    }
/*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId()==R.id.spinner_book_names){
                String[] bookNames = getResources().getStringArray(R.array.books);
                Log.i("FragmentWithSpinners","Selected position:  "+position+" and book item " +  bookNames[position]);
                Toast.makeText(this.getActivity(),"Selected position:  "+position+" and book item " +  bookNames[position],Toast.LENGTH_LONG).show();
            }

            if (parent.getId()==R.id.spinner_other_book_names){
                String[] isbn_numbers = getResources().getStringArray(R.array.books_isbn);
                Log.i("FragmentWithSpinners","Selected position:  "+position+" with title " +  FragmentList.planets.get(position).getTitle());
                Toast.makeText(this.getActivity(),"Selected position:  "+position+" with title " +  FragmentList.planets.get(position).getTitle(),Toast.LENGTH_LONG).show();
            }
    }*/



    @Override
    public void onClick(View v) {
        FragmentDialog.this.dismiss();

    }

    public void addToBackStack(Object o) {
    }
}
