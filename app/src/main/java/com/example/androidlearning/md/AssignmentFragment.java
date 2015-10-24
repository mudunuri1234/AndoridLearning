package com.example.androidlearning.md;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidlearning.R;

public class AssignmentFragment extends Fragment {

    public static final String DEBUG_TAG = AssignmentFragment.class.getName();

    public AssignmentFragment() {
    }

    public static AssignmentFragment newInstance() {
        return new AssignmentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_assignment, container, false);

        return view;
    }


}