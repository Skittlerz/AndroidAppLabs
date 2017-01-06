package com.braun1792.musicapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by braun1792 on 1/5/2017.
 */
public class MusicEventFragment extends Fragment {

    public MusicEventFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //collect data from MusicEvents class
        String [] eventData = MusicEvents.data;
        List<String> seasonEvents = new ArrayList<>(Arrays.asList(eventData));

        ArrayAdapter<String> musicEventAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_event, R.id.list_item_event_textView,seasonEvents);

        View rootView = inflater.inflate(R.layout.activity_fragment, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.lvEvents);
        listView.setAdapter(musicEventAdapter);

        return rootView;

    }
}
