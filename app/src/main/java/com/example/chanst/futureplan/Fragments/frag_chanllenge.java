package com.example.chanst.futureplan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chanst.futureplan.R;

/**
 * Created by chanst on 16-3-15.
 */
public class frag_chanllenge extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_chanllenge, container, false);
        return view;
    }
}
