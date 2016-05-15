package com.example.chanst.futureplan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.chanst.futureplan.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void register(View v){
        Intent intent = new Intent();
        intent.setClass(this,RegisterActivity.class);
        startActivityForResult(intent,1);
    }
    public void backToMain(View v){
        setResult(RESULT_OK);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            Log.i("hehe","LoginActivity");
        }
        finish();
    }
}
