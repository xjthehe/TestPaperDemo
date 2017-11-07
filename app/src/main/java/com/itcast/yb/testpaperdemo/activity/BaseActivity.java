package com.itcast.yb.testpaperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import utils.ActivityCollector;

public class BaseActivity extends AppCompatActivity {
private ActivityCollector collector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        collector=ActivityCollector.getActivityCollector();
        collector.addActivity(this);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        collector.removeActivity(this);
    }
}
