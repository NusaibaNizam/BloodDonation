package com.saranusaibanizam.BoodDonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import soup.neumorphism.NeumorphCardView;

public class WeightActivity extends AppCompatActivity {
    TextView headTV;
    TextView noteTV;
    Boolean above50=false;
    Boolean below50=false;
    Boolean male=false;
    Boolean female=false;
    Boolean weightSelected=false;
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        headTV=findViewById(R.id.letUsTV);
        noteTV=findViewById(R.id.provideTV);
        Intent intent=getIntent();
        weightSelected=intent.getBooleanExtra("selected",false);
        if(weightSelected){
            headTV.setText("What Is Your Gender");
            noteTV.setText("Providing you gender will let us set features for mother health care.");
            button= (ImageButton) findViewById(R.id.above);
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.male));
            button=(ImageButton) findViewById(R.id.below);
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.female));
        }
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void Next(View view) {
        if(weightSelected){
            if(male||female){
                Intent intent =new Intent(WeightActivity.this,SignUpActivity.class);
                intent.putExtra("address",true);
                startActivity(intent);
            }
        }
        else {
            if(above50||below50){
                Intent intent =new Intent(WeightActivity.this,WeightActivity.class);
                intent.putExtra("selected",true);
                startActivity(intent);
            }

        }
    }

    public void select(View view) {
        NeumorphCardView white;
        NeumorphCardView red;
        if(view.getId()==R.id.above){
            if(!weightSelected) {
                above50 = true;
                below50=false;
            }
            else{
                male=true;
                female=false;
            }
            red=(NeumorphCardView) findViewById(R.id.aboveBT);
            white= (NeumorphCardView) findViewById(R.id.belowBT);
        }else {
            if(!weightSelected) {
                below50 = true;
                above50=false;
            }else {
                female=true;
                male=false;
            }
            red=(NeumorphCardView) findViewById(R.id.belowBT);
            white=(NeumorphCardView) findViewById(R.id.aboveBT);
        }
        red.setBackgroundColor(Color.parseColor("#C4D6BCBC"));
        white.setBackgroundColor(Color.WHITE);
    }
}