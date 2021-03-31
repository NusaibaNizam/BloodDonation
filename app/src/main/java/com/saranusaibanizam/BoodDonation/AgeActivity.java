package com.saranusaibanizam.BoodDonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import travel.ithaka.android.horizontalpickerlib.PickerLayoutManager;

public class AgeActivity extends AppCompatActivity {
    RecyclerView ageRecyclerView;
    RecyclerView dayRecyclerView;
    RecyclerView monthRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Integer> day = new ArrayList<>();
        ArrayList<String> months = new ArrayList<>();
        for(int i=1;i<=150;i++){
            if(i<32){
                day.add(i);
            }
            age.add(i);
        }
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] monthNames = symbols.getMonths();
        for(String text:monthNames) {
            months.add(text);
        }
        ageRecyclerView=findViewById(R.id.ageRV);
        setUpRecyclerView(ageRecyclerView,age);
        dayRecyclerView=findViewById(R.id.dayRV);
        setUpRecyclerView(dayRecyclerView,day);
        monthRecyclerView=findViewById(R.id.monthRV);
        setUpRecyclerView(monthRecyclerView,months);

    }

    public void setUpRecyclerView(RecyclerView recyclerView, ArrayList list){
        SingleRowAdapter adapter = new SingleRowAdapter(this, list);
        PickerLayoutManager pickerLayoutManager = new PickerLayoutManager(this,
                PickerLayoutManager.HORIZONTAL, false);
        pickerLayoutManager.setChangeAlpha(true);
        pickerLayoutManager.setScaleDownBy(0.995f);
        pickerLayoutManager.setScaleDownDistance(0.8f);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(pickerLayoutManager);
        recyclerView.setAdapter(adapter);
        pickerLayoutManager.setOnScrollStopListener(new PickerLayoutManager.onScrollStopListener() {
            @Override
            public void selectedView(View view) {
                //Do your thing
                int pos=recyclerView.getChildLayoutPosition(view);
            }
        });
    }
    public void Next(View view) {
    }
}