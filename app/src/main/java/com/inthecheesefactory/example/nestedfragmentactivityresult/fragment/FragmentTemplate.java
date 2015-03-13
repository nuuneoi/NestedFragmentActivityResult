package com.inthecheesefactory.example.nestedfragmentactivityresult.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inthecheesefactory.example.nestedfragmentactivityresult.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentTemplate extends StatedFragment {

    public FragmentTemplate() {
        super();
    }

    public static FragmentTemplate newInstance() {
        FragmentTemplate fragment = new FragmentTemplate();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ground, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        //setRetainInstance(true);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /////////////////////////////////
    // Restore Instance State Here
    /////////////////////////////////

    @Override
    protected void onRestoreState(Bundle savedInstanceState) {
        super.onRestoreState(savedInstanceState);
    }

    //////////////////////////////
    // Save Instance State Here
    //////////////////////////////

    @Override
    protected void onSaveState(Bundle outState) {
        super.onSaveState(outState);
    }
}
