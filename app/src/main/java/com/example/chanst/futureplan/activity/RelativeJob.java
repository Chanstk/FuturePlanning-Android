package com.example.chanst.futureplan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.chanst.futureplan.R;

public class RelativeJob extends AppCompatActivity {
    private boolean fav = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_job);
    }
    public void jump(View v){
        Intent intent = new Intent(this, SkillRequired.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        }
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
    private void CreateMenu(Menu menu)
    {
        final MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
        {
            mnu1.setIcon(R.drawable.task_detail_heart);
            mnu1.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM);
            mnu1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    fav = !fav;
                    if(fav)
                        mnu1.setIcon(R.drawable.task_detail_heart_red);
                    else
                        mnu1.setIcon(R.drawable.task_detail_heart);
                    return false;
                }
            });
        }
        MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
        {
            mnu2.setIcon(R.drawable.relative_slade);
            mnu2.setShowAsAction(
                    MenuItem.SHOW_AS_ACTION_IF_ROOM);
            mnu2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    setResult(RESULT_OK);
                    finish();
                    return false;
                }
            });
        }

    }
}
