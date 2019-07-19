package com.company.Khanh_MusicQuiz;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;
import android.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    private static final String[] Topics = {"Pop", "Rap", "Country"};
    private static final int req_code = 2929;
    int score = 0;
    TextView scoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent forwardIntent = new Intent(this, activity_quiz.class);

        ListView simpleList = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Topics);
        simpleList.setAdapter(myAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic = parent.getItemAtPosition(position).toString();
                forwardIntent.putExtra("topic", topic);

                // return 1 or 0 for result of quiz question
                startActivityForResult(forwardIntent, req_code);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        scoreText = (TextView) findViewById(R.id.scoreBoard);
        if(requestCode==req_code){
            int answer = intent.getIntExtra("isCorrect", 0);
            if(answer == 1){
                score += 100;
                scoreText.setText("Your Score:" + score);
                Toast.makeText(MainActivity.this, "Correct! +100 Points.", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }
/*
    public void resetClick(View view){
    TextView scoreText = (TextView) findViewById(R.id.scoreBoard);
    score = 0;
    scoreText.setText("Score:" + score);
}*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("score",score);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("score");
        scoreText = (TextView) findViewById(R.id.scoreBoard);
        scoreText.setText("Your Score:" + score);

    }
}
