package com.sobel.yourcoffeecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import api.APIService;
import api.APIUrl;
import model.Result;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonback, buttonRegister;

    private EditText editcard, editpass;

    private TextView textView;

    private String userpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        buttonback= (Button) findViewById(R.id.backbtn);
        buttonRegister = (Button) findViewById(R.id.registerBtn);

        textView = (TextView) findViewById(R.id.textView);

        editcard = (EditText) findViewById(R.id.cardIdTb);
        editpass = (EditText) findViewById(R.id.passwordTb);

        buttonback.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);

    }

    private void userSingUp(){

        String cardId = editcard.getText().toString().trim();
        String password = editpass.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        User user = new User();
        user.setCardId(cardId);
        user.setPassword(password);

        Call<Result> call = service.createUser(
                user.getCardId(),
                user.getPassword()
        );

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();

                Log.i("A", "elo");

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("A", "elo2");
            }
        });


    }



    public void onClick(View view){

        if (view == buttonRegister) {
            userSingUp();


        }else if(view == buttonback){
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
        }

    }

}
