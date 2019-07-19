package com.company.Khanh_MusicQuiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragList extends Fragment {

    private static final String[] Topics = {"Pop", "Rap", "Country"};
    private static final int req_code = 3500;
    ListView simpleList;
    Intent forwardIntent;

    public FragList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_list, container, false);

        //forwardIntent = new Intent(getContext(), activity_quiz.class);

        //simpleList = (ListView) view.findViewById(R.id.list);
        //ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, quizTopics);
        //simpleList.setAdapter(myAdapter);

        return view;
    }


}
