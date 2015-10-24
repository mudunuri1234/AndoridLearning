package com.example.androidlearning.eventbus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidlearning.R;

import de.greenrobot.event.EventBus;

/**
 * Created by FCWL on 10/19/2015.
 */
public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        return view;
    }

    public void onEvent(FragmentDataEvent fragmentDataEvent) {
        TextView view = (TextView) getView().findViewById(R.id.display_tv);
        view.setText(fragmentDataEvent.getValue());
    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
