package com.example.dixuan_1904;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dixuan_1904.home.HomeFragment;
import com.example.dixuan_1904.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentUtils.addOrShowFragment(getSupportFragmentManager(),HomeFragment.class,R.id.linear,null);
    }
}
