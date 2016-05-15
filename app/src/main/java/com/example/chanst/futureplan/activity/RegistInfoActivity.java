package com.example.chanst.futureplan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;

import com.example.chanst.futureplan.R;

public class RegistInfoActivity extends AppCompatActivity {
    private NumberPicker np;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_info);
        getIntent();
        np = (NumberPicker) findViewById(R.id.np);
        np.setMaxValue(2016);
        np.setMinValue(2010);
        np.setValue(2016);
    }
    public void fin(View v){
        Log.i("hehe","LoginActivity");
        setResult(RESULT_OK);
        finish();
    }
}
