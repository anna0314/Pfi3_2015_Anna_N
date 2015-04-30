package se.mah.k3.skaneAPI;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;

import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import java.util.ArrayList;

import se.mah.k3.skaneAPI.control.Constants;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
import se.mah.k3.skaneAPI.xmlparser.Parser;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private ArrayList<Journey> journeyList = new ArrayList<Journey>();

    private MyAdapter myAdapter;
    private Spinner spinner;
    private Spinner spinner2;

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
        ExpandableListView exList = (ExpandableListView) v.findViewById(R.id.expandableListView);
        myAdapter = new MyAdapter(getActivity(), journeyList);
        exList.setAdapter(myAdapter);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinnerStations);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = (Spinner) v.findViewById(R.id.spinnerStations2);
        spinner2.setOnItemSelectedListener(this);

        return v;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) getView().findViewById(R.id.spinnerStations);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = (Spinner) getView().findViewById(R.id.spinnerStations2);
        spinner2.setOnItemSelectedListener(this);

        int i = spinner.getSelectedItemPosition();
        int i2 = spinner2.getSelectedItemPosition();
        String[] stations = getActivity().getResources().getStringArray(R.array.stationsNumber);
        String searchURL = Constants.getURL(stations[i], stations[i2], 10);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(searchURL);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            int i = spinner.getSelectedItemPosition();
            String[] s = getActivity().getResources().getStringArray(R.array.stations);
            String station = s[i];

            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(station);
            return true;
        } else {

            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private class MyAsyncTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            //Search
            Journeys journeys = Parser.getJourneys(params[0]); //There can be many in the params Array
            //And put the Journeys in our list.
            journeyList.clear();
            journeyList.addAll(journeys.getJourneys());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Log.i("ExpFragment", "In background2");
            myAdapter.notifyDataSetChanged();
            for (Journey si : journeyList) {
                Log.i("ExpFragment", "moment" + si.toString());
            }

        }
    }
}




