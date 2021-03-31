package com.saranusaibanizam.BoodDonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BloodGroupActivity extends AppCompatActivity {

    ArrayList<Button> bloodGroupBTs=new ArrayList<>();
    Boolean[] bloodBools=new Boolean[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        bloodGroupBTs.add((Button)findViewById(R.id.APosBT));
        bloodGroupBTs.add((Button)findViewById(R.id.ANegBT));
        bloodGroupBTs.add((Button)findViewById(R.id.BPosBT));
        bloodGroupBTs.add((Button)findViewById(R.id.BNegBT));
        bloodGroupBTs.add((Button)findViewById(R.id.OPosBT));
        bloodGroupBTs.add((Button)findViewById(R.id.ONegBT));
        bloodGroupBTs.add((Button)findViewById(R.id.ABPosBT));
        bloodGroupBTs.add((Button)findViewById(R.id.ABNegBT));
    }

    public void Next(View view) {
        Intent intent=new Intent(BloodGroupActivity.this,WeightActivity.class);
        startActivity(intent);
    }

    public void selectGroup(View view) {

        switch (view.getId()){
            case R.id.APosBT:
                setBlood(0);
                break;
            case R.id.ANegBT:
                setBlood(1);
                break;
            case R.id.BPosBT:
                setBlood(2);
                break;
            case R.id.BNegBT:
                setBlood(3);
                break;
            case R.id.OPosBT:
                setBlood(4);
                break;
            case R.id.ONegBT:
                setBlood(5);
                break;
            case R.id.ABPosBT:
                setBlood(6);
                break;
            case R.id.ABNegBT:
                setBlood(7);
                break;
        }
    }
    public void setBlood(int i){
        Button selectedBT= bloodGroupBTs.get(i);
        bloodBools[i]=true;
        selectedBT.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_selected_blood));
        selectedBT.setTextColor(Color.WHITE);
        for (int j=0;j<8;j++){
            if(j!=i){
                Button unSelectedBT= bloodGroupBTs.get(j);
                bloodBools[j]=false;

                unSelectedBT.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_unselected_blood));
                unSelectedBT.setTextColor(Color.parseColor("#C70100"));

            }
        }

    }
}