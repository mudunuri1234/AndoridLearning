package com.example.androidlearning.md;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.androidlearning.R;

/**
 * Created by fcwl on 7/7/2015.
 */
public class RotateAnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_image);

        RotateAnimation anim = new RotateAnimation(0f, 350f, 350f, 700f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);

        // with animation
        final ImageView androidImageView = (ImageView) findViewById(R.id.anim_apple);
        androidImageView.setAnimation(anim);
    }

}
