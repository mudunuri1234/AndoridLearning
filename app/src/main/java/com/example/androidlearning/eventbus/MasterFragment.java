package com.example.androidlearning.eventbus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidlearning.R;

import de.greenrobot.event.EventBus;

/**
 * Created by FCWL on 10/19/2015.
 */
public class MasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.master_fragment, container, false);

        // Button instances
        Button android_btn = (Button) view.findViewById(R.id.android_btn_id);
        Button ios_btn = (Button) view.findViewById(R.id.ios_btn_id);
        Button windows_btn = (Button) view.findViewById(R.id.windows_btn_id);

        // Listeners for buttons
        android_btn.setOnClickListener(fargmentButtonListener1);
        ios_btn.setOnClickListener(fargmentButtonListener2);
        windows_btn.setOnClickListener(fargmentButtonListener3);

        return view;
    }

    // Handles the Android button click event
    private View.OnClickListener fargmentButtonListener1 = new View.OnClickListener() {
        public void onClick(View v) {
            System.out.println("--------- Listener1 called ------------");
            EventBus.getDefault().post(new FragmentDataEvent("Android"));
        }
    };

    // Handles the IOS button click event
    private View.OnClickListener fargmentButtonListener2 = new View.OnClickListener() {
        public void onClick(View v) {
            System.out.println("--------- Listener2 called ------------");
            EventBus.getDefault().post(new FragmentDataEvent("IOS"));
        }
    };

    // Handles the Windows button click event
    private View.OnClickListener fargmentButtonListener3 = new View.OnClickListener() {
        public void onClick(View v) {
            System.out.println("--------- Listener3 called ------------");
            EventBus.getDefault().post(new FragmentDataEvent("Windows"));
        }
    };

}