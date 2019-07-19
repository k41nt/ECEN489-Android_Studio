package com.company.Khanh_MusicQuiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_quiz extends AppCompatActivity {
    private static final String[] Topics = {"Pop", "Rap", "Country"};
    private static final String[] Questions = {"Pop Music: Who is the singer?",
            "Rap Music: Who is the singer?",
            "Country Music: Who is the singer?"};
    private static final String[] quizAnswers = {"ed sheeran", "eminem", "blake shelton"};
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("topic");
        TextView textview = (TextView) findViewById(R.id.questionText);
        ImageView EdPic = (ImageView)findViewById(R.id.EdSheeran);
        ImageView EminemPic = (ImageView)findViewById(R.id.Eminem);
        ImageView BlakePic = (ImageView)findViewById(R.id.BlakeShelton);

        if (extra.equals(Topics[0])) {
            textview.setText(Questions[0]);
            EdPic.setVisibility(View.VISIBLE);
            EminemPic.setVisibility(View.INVISIBLE);
            BlakePic.setVisibility(View.INVISIBLE);
            stopPlaying();
            mp = MediaPlayer.create(this,R.raw.photograph);
            mp.start();
        }
        if (extra.equals(Topics[1])) {
            textview.setText(Questions[1]);
            EdPic.setVisibility(View.INVISIBLE);
            EminemPic.setVisibility(View.VISIBLE);
            BlakePic.setVisibility(View.INVISIBLE);
            stopPlaying();
            mp = MediaPlayer.create(this,R.raw.notafraid);
            mp.start();
        }
        if (extra.equals(Topics[2])) {
            textview.setText(Questions[2]);
            EdPic.setVisibility(View.INVISIBLE);
            EminemPic.setVisibility(View.INVISIBLE);
            BlakePic.setVisibility(View.VISIBLE);
            stopPlaying();
            mp = MediaPlayer.create(this,R.raw.home);
            mp.start();
        }
    }

    public int getAnswer(String userAnswer){
        TextView textview = (TextView) findViewById(R.id.questionText);
        if (textview.getText().toString().equals(Questions[0])) {
            if(userAnswer.equals(quizAnswers[0]))
                return 1;
            else
                return 0;
        }
        else if (textview.getText().toString().equals(Questions[1])) {
            if(userAnswer.equals(quizAnswers[1]))
                return 1;
            else
                return 0;
        }
        else {
            if(userAnswer.equals(quizAnswers[2]))
                return 1;
            else
                return 0;
        }
    }

    public void submitClick (View view) {
        Intent backIntent = new Intent();
        EditText ansText = (EditText) findViewById(R.id.myAns);
        int isCorrect;

        isCorrect = getAnswer(ansText.getText().toString().toLowerCase());
        backIntent.putExtra("isCorrect", isCorrect);
        setResult(RESULT_OK, backIntent);
        stopPlaying();
        finish();
    }

    public void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void startPlay(View view) {
        mp.start();
    }

    public void stopPlay(View view) {
        mp.pause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("position", mp.getCurrentPosition());
        mp.pause();
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int pos = savedInstanceState.getInt("position");
        mp.seekTo(pos);

    }
}
