package com.example.androidlearning.md;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.androidlearning.R;

/**
 * Created by fcwl on 7/9/2015.
 */
public class TranslateAnimationActivity extends Activity {

    ImageView androidImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ RotateAnimationActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_image);

        androidImageView = (ImageView) findViewById(R.id.anim_apple);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f, 0.0f, 0.0f);
        animation.setDuration(5000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(2);
        animation.setFillAfter(true);
        androidImageView.startAnimation(animation);
    }

}
