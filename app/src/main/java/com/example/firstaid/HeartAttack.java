package com.example.firstaid;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


public class HeartAttack extends AppCompatActivity {

    private static final String VIDEO_SAMPLE = "heartattack";
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_attack);

        mVideoView = findViewById(R.id.videoview);

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);

    }

    private Uri getMedia(String mediaName) {
//        return Uri.parse("android.resource://" + getPackageName() +
//                "/raw/" + mediaName);

        return Uri.parse("rtsp://r3---sn-a5meknsy.googlevideo.com/Cj0LENy73wIaNAkCo015-d6o1hMYDSANFC0hCkpcMOCoAUIASARgp5HptMbnuKFcigELcXBsZ01LOXFLajQM/C067969BB98BC90BA3269CC15D5AC1F3E7E3081A.C255C3956C465D4AC24338D139B116AEA94B5159/yt6/1/video.3gp");
    }

    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();
    }

    private void releasePlayer() {
        mVideoView.stopPlayback();
    }

    @Override
    protected void onStart() {
        super.onStart();

        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();

        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }
}
