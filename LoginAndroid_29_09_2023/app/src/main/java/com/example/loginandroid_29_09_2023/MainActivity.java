package com.example.loginandroid_29_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.lstMov.view.LstMovies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final long SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editTextEmail = findViewById(R.id.edtEmail);
        EditText editTextPassword = findViewById(R.id.edtPassword);
        Button btnIniciarSesion = findViewById(R.id.btnLogin);


        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editTextEmail.getText().toString();
                String userPassword = editTextPassword.getText().toString();
                if (!userEmail.isEmpty() || !userPassword.isEmpty()) {
                    Login();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa datos en los campos ", Toast.LENGTH_SHORT).show();
                }

            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this,
                        LstMovies.class);
                startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
/*
    private void Login() {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId, API_KEY, LANGUAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Movie movie = response.body();
                    Toast.makeText(MainActivity.this, "Detalles de " + movie.getTitle() + ": " + movie.getOverview(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "No se encontraron detalles para esta película", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}