package com.pool.taiho.testpool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import com.pool.taiho.testpool.popup.ChooseActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private ViewFlipper vf;
    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resInit();

    }

    public void resInit() {
        vv = (VideoView)findViewById(R.id.videoView);
        final MediaController mediaController = new MediaController(this);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ttt);
        vv.setMediaController(mediaController);
        vv.setVideoURI(video);
        vv.requestFocus();
        vv.setOnTouchListener(this);
        vv.start();


/*        vf = (ViewFlipper)findViewById(R.id.vf);
        Animation showIn= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        vf.setFlipInterval(5000);
        vf.setInAnimation(showIn);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
        vf.startFlipping();
        vf.setOnClickListener(this);*/
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
        startActivity(intent);
        return false;
    }

}
