package com.example.loginandroid_29_09_2023.updateMov;

import com.example.loginandroid_29_09_2023.beans.Pelicula;


public interface ContractUpdateMovies {

    interface Model {
        void updatePelicula(Pelicula pelicula, UpdateCallback callback);

        interface UpdateCallback {
            void onSuccess();
            void onError(String error);
        }
    }

    interface Presenter {
        void updatePelicula(Pelicula pelicula);
    }

    interface View {
        void onUpdateSuccess();
        void onUpdateError(String error);
    }
}
