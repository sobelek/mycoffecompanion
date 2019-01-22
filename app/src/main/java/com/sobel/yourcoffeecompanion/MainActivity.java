package com.sobel.yourcoffeecompanion;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
public class MainActivity extends AppCompatActivity {

    EditText idEd;
    EditText passEd;
    TextView tekst;
    String text;
    private ProgressDialog pDialog;

    private static String url_get_user = "http://alicjamus.hs5.linux.pl/android_connect/get_user_details.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEd = (EditText)findViewById(R.id.cardIdTb);
        passEd = (EditText)findViewById(R.id.passwordTb);
        tekst = (TextView)findViewById(R.id.textView);



        final Button button = findViewById(R.id.loginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            String cardId = idEd.getText().toString();
            String password = passEd.getText().toString();
            CallAPI callAPI = new CallAPI();
            callAPI.execute();

            }
        });

    }
    public class CallAPI extends AsyncTask<String, String, String> {

        public CallAPI(){
            //set context variables if required
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String urlString = url_get_user; // URL to call
            String data = "cardId=25"; //data to post
            OutputStream out = null;

            try {
                java.net.URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                out = new BufferedOutputStream(urlConnection.getOutputStream());

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                out.close();

                urlConnection.connect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return null;}
    }
























    /*class CreateNewProduct extends AsyncTask<String, String, String> {

        *//**
         * Before starting background thread Show Progress Dialog
         * *//*
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Creating Product..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        *//**
         * Creating product
         * *//*
        protected String doInBackground(String... args) {
            String name =  idEd.getText().toString();
            String price = passEd.getText().toString();

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url_get_user, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    text = response.toString();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    text = "eror";
                }
            });

            return null;
        }

        *//**
         * After completing background task Dismiss the progress dialog
         * **//*
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }*/
}




