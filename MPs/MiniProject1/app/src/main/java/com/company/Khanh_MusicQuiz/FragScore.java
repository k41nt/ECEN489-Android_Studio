package com.company.Khanh_MusicQuiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragScore extends Fragment {
    private int score = 0;
    TextView scoreText;
    private static final int req_code = 2929;

    public FragScore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_score, container, false);
        View r = (Button) view.findViewById(R.id.resetButton);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetClick(v);
            }
        });
        scoreText = (TextView) view.findViewById(R.id.scoreBoard);

        return view;
    }

    public void resetClick(View view){
        //scoreText = (TextView) view.findViewById(R.id.scoreBoard);
        score = 0;
        scoreText.setText("Score:" + score);

    }
}
