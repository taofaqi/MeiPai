package com.taofaqi.meipai.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.taofaqi.meipai.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class DetailActivity extends AppCompatActivity {


    private VideoView mainVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_deatail);
        mainVideoView = ((VideoView) findViewById(R.id.main_video_view));

        mainVideoView.setVideoURI(Uri.parse("http://mvvideo2.meitudata.com/56e457edc353d1239.mp4"));
        mainVideoView.setMediaController(new MediaController(this));

        mainVideoView.requestFocus();
        mainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
    }

}
