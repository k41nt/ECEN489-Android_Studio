package com.company.Khanh_musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        ImageView mario_world = (ImageView)findViewById(R.id.worldImage);
        ImageView mario_star = (ImageView)findViewById(R.id.starImage);
        ImageView mario_underwater = (ImageView)findViewById(R.id.underwaterImage);

        switch(view.getId()) {
            case R.id.song1:
                if(checked) {
                    mario_star.setVisibility(View.VISIBLE);
                    mario_underwater.setVisibility(View.INVISIBLE);
                    mario_world.setVisibility(View.INVISIBLE);
                    stopPlaying();
                    mp = MediaPlayer.create(this,R.raw.star);
                    mp.start();
                }
                break;
            case R.id.song2:
                if(checked) {
                    mario_star.setVisibility(View.INVISIBLE);
                    mario_underwater.setVisibility(View.VISIBLE);
                    mario_world.setVisibility(View.INVISIBLE);
                    stopPlaying();
                    mp = MediaPlayer.create(this,R.raw.underwater);
                    mp.start();
                }
                break;
            case R.id.song3:
                if(checked) {
                    mario_star.setVisibility(View.INVISIBLE);
                    mario_underwater.setVisibility(View.INVISIBLE);
                    mario_world.setVisibility(View.VISIBLE);
                    stopPlaying();
                    mp = MediaPlayer.create(this,R.raw.world);
                    mp.start();
                }
                break;
        }
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
}
