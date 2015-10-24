package com.example.androidlearning.picasso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.androidlearning.R;
import com.squareup.picasso.Picasso;

/**
 * Created by fcwl on 5/28/2015.
 */
public class PicassoActivity extends Activity {

    @Override
    // Called when the activity is first created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);

        // Apple view
        Picasso.with(this).load(R.drawable.apple).into(imageView1);

        Picasso.with(this).load(R.drawable.apple)
                .resize(250, 200)
                .rotate(90)
                .into(imageView2);

        Picasso.with(this).load(R.drawable.apple)
                .resize(350, 350)
                .rotate(180)
                .into(imageView3);

        Picasso.with(this).load(R.drawable.apple)
                .resize(400, 400)
                .rotate(270)
                .into(imageView4);
    }

    @Override
    // Called when the activity becomes visible to the user
    protected void onStart() {
        super.onStart();
    }

    @Override
    // Called when the activity is no longer visible to the user
    protected void onStop() {
        super.onStop();
    }

}
