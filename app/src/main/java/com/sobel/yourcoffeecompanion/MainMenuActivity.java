package com.sobel.yourcoffeecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {


    private Button buttonLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        TextView pointstext = (TextView)findViewById(R.id.pointsInfo);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.pointsProgress);
        String points = getIntent().getStringExtra("points");
        pointstext.setText("Posiadasz " + points + " punktów");


        buttonLogOut = (Button) findViewById(R.id.logOutBtn);

    }



    public void onClick(View view){
        if (view == buttonLogOut){
            Intent i = new Intent(MainMenuActivity.this, MainActivity.class);
            startActivity(i);
        }




    }
}