package com.bur1y.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class Book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    LinearLayout kia = (LinearLayout) findViewById(R.id.kia);
    LinearLayout km = (LinearLayout) findViewById(R.id.km);
    LinearLayout m5 = (LinearLayout) findViewById(R.id.m5);
    LinearLayout min1 = (LinearLayout) findViewById(R.id.min1);
    LinearLayout min60 = (LinearLayout) findViewById(R.id.min60);
    LinearLayout min1440 = (LinearLayout) findViewById(R.id.min1440);

    boolean isCar, isLiner, isPeople, isMinute, isHour, IsDay;

    public void car(View view) {
        isCar = true;
        isLiner = false;
        isPeople = false;
    }

    public void liner(View view) {
        isCar = false;
        isLiner = true;
        isPeople = false;
    }

    public void people(View view) {
        isCar = false;
        isLiner = false;
        isPeople = true;
    }

    public void minute(View view) {
    }

    public void Hour(View view) {
    }

    public void Day(View view) {
    }

    public void book(View view) {
    }
}