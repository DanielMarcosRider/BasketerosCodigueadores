package com.example.loginandroid_29_09_2023.updateMov.presenter;


import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.updateMov.ContractUpdateMovies;

public class UpdateMoviesPresenter implements ContractUpdateMovies.Presenter {
    private ContractUpdateMovies.Model model;
    private ContractUpdateMovies.View view;

    public UpdateMoviesPresenter(ContractUpdateMovies.Model model, ContractUpdateMovies.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void updatePelicula(Pelicula pelicula) {
        model.updatePelicula(pelicula, new ContractUpdateMovies.Model.UpdateCallback() {
            @Override
            public void onSuccess() {
                view.onUpdateSuccess();
            }

            @Override
            public void onError(String error) {
                view.onUpdateError(error);
            }
        });
    }
}