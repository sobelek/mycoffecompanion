package com.sobel.yourcoffeecompanion;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.List;

import api.APIService;
import api.APIUrl;
import model.Result;
import model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogin, buttonRegister;

    private EditText editcard, editpass;

    private TextView textView;

    public String userpass;

    private String points;

    String textpass;
    String textid;
    String message;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        context = this;

        buttonLogin = (Button) findViewById(R.id.loginBtn);
        buttonRegister = (Button) findViewById(R.id.registerBtn);

        textView = (TextView) findViewById(R.id.textView);

        editcard = (EditText) findViewById(R.id.cardIdTb);
        editpass = (EditText) findViewById(R.id.passwordTb);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);


    }

    private void userSingIn(){


        String cardId = editcard.getText().toString().trim();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.DETAILS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        final User user = new User();
        user.setCardId(cardId);

        Call<Result> call = service.loginUser(
                user.getCardId()

        );

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.body().getSuccess() == 1) {
                    userpass = response.body().getPassword();
                    points = response.body().getPoints();

                    /*message = response.body().getMessage().trim();*/
               /* if(message.equals("No product found")){
                    Toast.makeText(getApplicationContext(), "Karta nie jest aktywna", Toast.LENGTH_SHORT).show();

                }*/
                    if (userpass.equals(textpass)) {
                        Toast.makeText(getApplicationContext(), "Zalogowano pomyślnie", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context, MainMenuActivity.class);
                        i.putExtra("points", points);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "Wprowadzono błędne hasło", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    message = response.body().getMessage();
                    if(message.equals("No product found")) {
                        Toast.makeText(getApplicationContext(), "Karta nie jest aktywna", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }


     @Override
    public void onClick(View view){
        if (view == buttonRegister){
            Intent i = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(i);
        }else if (view == buttonLogin) {

            textpass = editpass.getText().toString().trim();
            textid = editcard.getText().toString().trim();

            if(textpass.isEmpty() || textid.isEmpty()){
                Toast.makeText(getApplicationContext(), "Nie wprowadzono hasła lub numeru karty", Toast.LENGTH_LONG).show();

            }else {

                userSingIn();
            }

        }

    }








}








