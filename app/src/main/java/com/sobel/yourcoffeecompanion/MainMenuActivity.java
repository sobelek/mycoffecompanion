package com.sobel.yourcoffeecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonLogOut = (Button)findViewById(R.id.logOutBtn);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.pointsProgress);

        CheckBox espressobox = (CheckBox)findViewById(R.id.espressoBox);

        CheckBox americanobox= (CheckBox)findViewById(R.id.americanoBox);

        CheckBox doppiobox= (CheckBox)findViewById(R.id.doppioBox);

        CheckBox flatwhitebox = (CheckBox)findViewById(R.id.flatBox);

        CheckBox cappucinobox = (CheckBox)findViewById(R.id.cappuccinoBox);

        CheckBox lattebox= (CheckBox)findViewById(R.id.latteBox);

        TextView pointstext = (TextView)findViewById(R.id.pointsInfo);

        String points = getIntent().getStringExtra("points");
        pointstext.setText("Posiadasz " + points + " punktów");

        int ipoints = Integer.parseInt(points);
        progressBar.setProgress(ipoints);


        if(ipoints> 10 && ipoints < 21) {
            espressobox.setChecked(true);
            americanobox.setChecked(true);
        }
        if(ipoints > 20 && ipoints < 31) {
            espressobox.setChecked(true);
            americanobox.setChecked(true);
            doppiobox.setChecked(true);
            flatwhitebox.setChecked(true);
        }
        if(ipoints > 30) {
            espressobox.setChecked(true);
            americanobox.setChecked(true);
            doppiobox.setChecked(true);
            flatwhitebox.setChecked(true);
            lattebox.setChecked(true);
            cappucinobox.setChecked(true);
        }



    }


    @Override
    public void onClick(View view){
        if (view == buttonLogOut){
            Intent i = new Intent(MainMenuActivity.this, MainActivity.class);
            startActivity(i);
        }

    }
}