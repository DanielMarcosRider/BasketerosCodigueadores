package com.example.loginandroid_29_09_2023.login_user.data;

import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;

public class MyData {
    private String message;
    private ArrayList<User> lstUsers;


    public String getMessage() {
        return message;
    }
    public ArrayList<User> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}

/*
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
*/

/*
    private void Login() {
        Call<User> call = RetrofitClient.getInstance().getMovieDetails(movieId, API_KEY, LANGUAGE);
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