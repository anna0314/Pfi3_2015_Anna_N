package se.mah.k3.skaneAPI.view;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;


import se.mah.k3.skaneAPI.R;
import android.app.Activity;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.control.Constants;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
import se.mah.k3.skaneAPI.xmlparser.Parser;
import android.widget.AdapterView.OnItemSelectedListener;



/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private  ArrayList<Journey> journeyList= new ArrayList<Journey>();

    private MyAdapter myAdapter;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        ExpandableListView exList = (ExpandableListView)v.findViewById(R.id.expandableListView);
        myAdapter = new MyAdapter(getActivity(),journeyList);
        exList.setAdapter(myAdapter);

        Spinner spinner = (Spinner)v.findViewById(R.id.spinnerStations);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = (Spinner)v.findViewById(R.id.spinnerStations2);
        spinner2.setOnItemSelectedListener(this);

        return v;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            Spinner spinner = (Spinner) getView().findViewById(R.id.spinnerStations);
            Spinner spinner2 = (Spinner) getView().findViewById(R.id.spinnerStations2);
            int i = spinner.getSelectedItemPosition();
            String[] s = getActivity().getResources().getStringArray(R.array.stationsNumber);
            String station = s[i];
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(station);
            return true;
        } else {

            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner)getView().findViewById(R.id.spinnerStations);
        int i = spinner.getSelectedItemPosition();
        String[] s = getActivity().getResources().getStringArray(R.array.stationsNumber);
        String station = s[i];

        Spinner spinner2 = (Spinner)getView().findViewById(R.id.spinnerStations2);
        int i2 = spinner2.getSelectedItemPosition();
        String[] s2 = getActivity().getResources().getStringArray(R.array.stationsNumber);
        String station2 = s2[i2];
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(station);
        new MyAsyncTask().execute(station2);

        Log.i("BlankFragment", "station. " + station);
        Log.i("BlankFragment", "station. " + station2);
        String searchURL = Constants.getURL(station, station2, 10); //Malmö C = 80000,  Malmö GAtorg 80100, Hässleholm C 93070
        new MyAsyncTask().execute(searchURL);
        Log.i("BlankFragment", "station. " + searchURL);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void searchFinished(){
        for (Journey j: journeyList){
            Log.i("BlankFragment", "From "+ j.getStartStation().getStationName()
                        +" To: "+ j.getEndStation()
                        + " leaves : "+j.getTimeToDeparture()+ "\n");
        }
    }

    private class MyAsyncTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {
            //Search
            Journeys journeys = Parser.getJourneys(params[0]); //There can be many in the params Array
            //And put the Journeys in our list.
            journeyList.clear();
            journeyList.addAll(journeys.getJourneys());
            return null;
        }

        protected void onPostExecute(Long result) { //Called when the AsyncTask is all done
            searchFinished();
        }

    }

}




