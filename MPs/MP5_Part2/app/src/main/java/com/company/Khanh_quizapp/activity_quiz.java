package com.company.Khanh_quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_quiz extends AppCompatActivity {
    private static final String[] quizTopics = {"Soccer", "Movie", "Math"};
    private static final String[] quizQuestions = {"What country has won the most World Cups?",
            "What is batman's real name?",
            "8-3+3=?"};
    private static final String[] quizAnswers = {"brazil", "bruce wayne", "8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("topic");
        TextView textview = (TextView) findViewById(R.id.questionText);

        if (extra.equals(quizTopics[0])) {
            textview.setText(quizQuestions[0]);
        }
        if (extra.equals(quizTopics[1])) {
            textview.setText(quizQuestions[1]);
        }
        if (extra.equals(quizTopics[2])) {
            textview.setText(quizQuestions[2]);
        }
    }

    public int getAnswer(String userAnswer){
        TextView textview = (TextView) findViewById(R.id.questionText);
        if (textview.getText().toString().equals(quizQuestions[0])) {
            if(userAnswer.equals(quizAnswers[0]))
                return 1;
            else
                return 0;
        }
        else if (textview.getText().toString().equals(quizQuestions[1])) {
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
        finish();
    }
}
