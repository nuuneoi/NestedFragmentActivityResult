package com.inthecheesefactory.example.nestedfragmentactivityresult.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inthecheesefactory.example.nestedfragmentactivityresult.Constant;
import com.inthecheesefactory.example.nestedfragmentactivityresult.R;
import com.inthecheesefactory.example.nestedfragmentactivityresult.activity.SecondActivity;
import com.inthecheesefactory.example.nestedfragmentactivityresult.bus.MainBus;
import com.inthecheesefactory.example.nestedfragmentactivityresult.bus.event.ActivityResultEvent;
import com.squareup.otto.Subscribe;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class BodyFragment extends StatedFragment {

    TextView tvResult;
    Button btnLaunch;

    public BodyFragment() {
        super();
    }

    public static BodyFragment newInstance() {
        BodyFragment fragment = new BodyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        //setRetainInstance(true);

        tvResult  = (TextView) rootView.findViewById(R.id.tvResult);
        btnLaunch = (Button) rootView.findViewById(R.id.btnLaunch);
        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                getActivity().startActivityForResult(intent, Constant.SAMPLE_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        MainBus.getInstance().register(this);
        Log.d("BodyFragment", "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        MainBus.getInstance().unregister(this);
        Log.d("BodyFragment", "onStop");
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

    @Subscribe
    public void onActivityResultReceived(ActivityResultEvent event) {
        int requestCode = event.getRequestCode();
        int resultCode = event.getResultCode();
        Intent data = event.getData();
        Toast.makeText(getActivity(), "Fragment Got it: " + requestCode + ", " + resultCode, Toast.LENGTH_SHORT).show();
        if (requestCode == Constant.SAMPLE_REQUEST_CODE) {
            // Do your job
            tvResult.setText("Result Code = " + resultCode);
        }
    }
}
