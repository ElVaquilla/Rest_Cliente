package com.example.rest_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// Librerías de retrofit
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.rest_client.models.Track;

public class NewTrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_track);
    }
    public void addTrackOnClick(View v){
        // First we retrieve the user inputs
        EditText editText = (EditText) findViewById(R.id.namesong);
        String title = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.author);
        String author = editText2.getText().toString();

        Track t = new Track(title, author);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewTrackService addtrack = retrofit.create(NewTrackService.class);
        Call<Track> call = addtrack.Createcredenciales(t);
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if (response.isSuccessful()){

                }
                else{
                    if (response.code() == 500) {
                        Toast.makeText(NewTrackActivity.this, "Error, datos erroneamente introducidos", Toast.LENGTH_SHORT).show();
                        clearFields();
                    } else {
                        Toast.makeText(NewTrackActivity.this, "Error, La respuesta no es como se espera", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Toast.makeText(NewTrackActivity.this, "Error No response", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}