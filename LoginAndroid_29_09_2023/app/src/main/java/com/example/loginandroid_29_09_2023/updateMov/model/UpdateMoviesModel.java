package com.example.loginandroid_29_09_2023.updateMov.model;

import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.updateMov.ContractUpdateMovies;
import com.example.loginandroid_29_09_2023.utils.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMoviesModel implements ContractUpdateMovies.Model {
    private ApiService apiService;

    public UpdateMoviesModel(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void updatePelicula(Pelicula pelicula, UpdateCallback callback) {
        Call<Void> call = apiService.updatePelicula(pelicula.getId(), pelicula);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Error en la actualización");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}

