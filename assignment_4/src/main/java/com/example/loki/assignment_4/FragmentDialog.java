package com.example.loki.assignment_4;

import android.app.Fragment;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentDialog extends Fragment implements AdapterView.OnItemSelectedListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__dialog, container, false);
       /* Planet p = (Planet) getArguments().getSerializable("planet");
        TextView tv_title = (TextView) v.findViewById(R.id.tv_dialog_title);
        tv_title.setText(p.getTitle());
        TextView tv_temp = (TextView) v.findViewById(R.id.tv_dialog_temp);
        tv_temp.setText("Temp: " + p.getTemp());

        TextView tv_description = (TextView) v.findViewById(R.id.tv_dialog_description);
        tv_description.setText(p.getSummary());
        ImageView iv = (ImageView) v.findViewById(R.id.iv_dialog);
        iv.setImageDrawable(p.getImage());*/


/*        v.setOnClickListener(this);
        tv_description.setOnClickListener(this);
        iv.setOnClickListener(this);
        tv_title.setOnClickListener(this);*/
        return v;
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
