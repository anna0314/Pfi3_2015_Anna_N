package se.mah.k3.skaneAPI.view;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import se.mah.k3.skaneAPI.R;
import se.mah.k3.skaneAPI.model.Journey;
import se.mah.k3.skaneAPI.model.Journeys;
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

        TextView tv_avgang = (TextView)convertView.findViewById(R.id.avgang);
        String avgang = journeyList.get(groupPosition).getDepDateTime().toString();
        tv_avgang.setText(avgang);

        TextView tv_ankomst = (TextView)convertView.findViewById(R.id.ankomst);
        String ankomst = journeyList.get(groupPosition).getArrDateTime().toString();
        tv_ankomst.setText(ankomst);

        TextView tv_restid = (TextView)convertView.findViewById(R.id.restid);
        String restid = journeyList.get(groupPosition).getTravelMinutes();
        tv_restid.setText(restid);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.child,null);


        TextView tv_station=(TextView)convertView.findViewById(R.id.station);
        String station = journeyList.get(groupPosition).getStartStation().getStationName();
        tv_station.setText(station);

        TextView tv_station2=(TextView)convertView.findViewById(R.id.station2);
        String station2 = journeyList.get(groupPosition).getEndStation().getStationName();
        tv_station2.setText(station2);

        TextView tv_avg=(TextView)convertView.findViewById(R.id.avg);
        String avg = journeyList.get(groupPosition).getDepTimeDeviation();
        tv_avg.setText(avg);

        TextView tv_ank=(TextView)convertView.findViewById(R.id.ank);
        String ank = journeyList.get(groupPosition).getArrTimeDeviation();
        tv_ank.setText(ank);

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

