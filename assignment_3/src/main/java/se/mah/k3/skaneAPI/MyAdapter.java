package se.mah.k3.skaneAPI;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;



import se.mah.k3.skaneAPI.R;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
import se.mah.k3.skaneAPI.model.Station;
import se.mah.k3.skaneAPI.xmlparser.Parser;
import se.mah.k3.skaneAPI.xmlparser.XMLParser;


import java.util.Calendar;


/**
 * Created by Loki on 2015-04-14.
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private ArrayList<Journey> journeyList;
    private Context c;

    public MyAdapter(Context c, ArrayList<Journey>journeyList){
        this.c=c;
        this.journeyList=journeyList;
    }

    @Override
    public int getGroupCount() {
        return journeyList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.group,null);

        TextView tv_trafik = (TextView)convertView.findViewById(R.id.trafik);
        String linje = journeyList.get(groupPosition).getLineOnFirstJourney();
        String medel = journeyList.get(groupPosition).getLineTypeName();
        tv_trafik.setText(medel +" "+ linje);

        TextView tv_dep = (TextView)convertView.findViewById(R.id.departure);
        String dep = journeyList.get(groupPosition).getTimeToDeparture();
        tv_dep.setText(dep +" min");

/*        TextView tv_restid = (TextView)convertView.findViewById(R.id.restid);
        String restid = journeyList.get(groupPosition).getTravelMinutes();
        tv_restid.setText(restid+" min");*/

/*        TextView tv_byten = (TextView)convertView.findViewById(R.id.byten);
        String byten = journeyList.get(groupPosition).getNoOfChanges();
        tv_byten.setText(byten);*/

        ImageView image = (ImageView)convertView.findViewById(R.id.image);
        int time = Integer.parseInt(dep);
            if(time<5){

            image.setVisibility(convertView.VISIBLE);
        } else{
            image.setVisibility(convertView.INVISIBLE);

        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Journey journey = journeyList.get(groupPosition);

        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.child,null);

        TextView tv_station=(TextView)convertView.findViewById(R.id.station1);
        Station station = journeyList.get(groupPosition).getStartStation();
        tv_station.setText(station.getStationName());

        TextView tv_station2=(TextView)convertView.findViewById(R.id.station2);
        Station station2 = journeyList.get(groupPosition).getEndStation();
        tv_station2.setText(station2.getStationName());

        TextView tv_avg=(TextView)convertView.findViewById(R.id.avg);
        String avgTid = journeyList.get(groupPosition).getDepDateTime().get(Calendar.HOUR_OF_DAY)+
                ":" +journeyList.get(groupPosition).getDepDateTime().get(Calendar.MINUTE);
        tv_avg.setText(avgTid);

        TextView tv_ank=(TextView)convertView.findViewById(R.id.ank);
        String ankTid = journeyList.get(groupPosition).getArrDateTime().get(Calendar.HOUR_OF_DAY)+
                ":" +journeyList.get(groupPosition).getArrDateTime().get(Calendar.MINUTE);
        tv_ank.setText(ankTid);


        TextView tv_linje=(TextView)convertView.findViewById(R.id.linje);
        String linje = journeyList.get(groupPosition).getLineOnFirstJourney();
        String medel = journeyList.get(groupPosition).getLineTypeName();
        tv_linje.setText(medel +" "+ linje);

        TextView tv_delay=(TextView)convertView.findViewById(R.id.delayed);
        String delay = journeyList.get(groupPosition).getDepTimeDeviation();
        tv_delay.setText(delay+" min");



        return convertView;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

