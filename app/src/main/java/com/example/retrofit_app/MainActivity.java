package com.example.retrofit_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        // créez une instance de l'interface JSONPlaceholder en utilisant la méthode create()
        //qui sera utilisée pour effectuer des appels réseau conformément à la définition de l'interface.
        Call<List<RequestPost>> call = jsonPlaceholder.getRequestPost();
        //elle enverra une requête HTTP GET à l'URL relative "posts" lorsque cette méthode sera appelée.
        call.enqueue(new Callback<List<RequestPost>>() {
            @Override
            public void onResponse(Call<List<RequestPost>> call, @NonNull Response<List<RequestPost>> response) {
                if (!response.isSuccessful()){

                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    //un message Toast est affiché pour informer l'utilisateur du code de réponse de la requête.
                    return;
                }
                List<RequestPost> postList = response.body();
                PostAdapter postAdapter = new PostAdapter(MainActivity.this, postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<List<RequestPost>> call, Throwable throwable) {

                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });









    }
}