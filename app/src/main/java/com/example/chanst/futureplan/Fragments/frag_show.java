package com.example.chanst.futureplan.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chanst.futureplan.R;

/**
 * Created by chanst on 16-3-15.
 */
public class frag_show extends Fragment {
    private View view;
    private TextView tv,more;
    private LinearLayout lil;
    private boolean isFold = true;
    private ImageView fold ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_show, container, false);
        tv = (TextView) view.findViewById(R.id.showBuilding);
        tv.setClickable(true);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                building();
            }
        });
        lil = (LinearLayout) view.findViewById(R.id.b_1);
        more = (TextView) view.findViewById(R.id.more);
        fold = (ImageView) view.findViewById(R.id.fold);
        fold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFold){
                    lil.setVisibility(View.VISIBLE);
                    more.setVisibility(View.GONE);
                    fold.setImageDrawable(getResources().getDrawable(R.drawable.fold));
                }else{
                    lil.setVisibility(View.GONE);
                    more.setVisibility(View.VISIBLE);
                    fold.setImageDrawable(getResources().getDrawable(R.drawable.extend));
                }
                isFold = !isFold;
            }
        });

        return view;
    }

    public void building(){
        final Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, "该功能正在开发中", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
