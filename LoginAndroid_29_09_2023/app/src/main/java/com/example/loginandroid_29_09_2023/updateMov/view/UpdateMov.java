package com.example.loginandroid_29_09_2023.updateMov.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.updateMov.ContractUpdateMovies;
import com.example.loginandroid_29_09_2023.updateMov.model.UpdateMoviesModel;
import com.example.loginandroid_29_09_2023.updateMov.presenter.UpdateMoviesPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;

public class UpdateMov extends AppCompatActivity implements ContractUpdateMovies.View {

    private EditText edtImageUrl;  // Solo este campo será editable
    private Button btnUpdateMovie;

    private UpdateMoviesPresenter presenter;
    private Pelicula currentPelicula;  // Para guardar la película actual

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movies);

        initComponents();

    }

    private void initComponents() {
        edtImageUrl = findViewById(R.id.edtImageUrl);
        btnUpdateMovie = findViewById(R.id.btnUpdateMovie);

        btnUpdateMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPelicula != null) {
                    // Actualizar solo la URL de la imagen
                    currentPelicula.setUrlImagen(edtImageUrl.getText().toString());

                    // Llamar al presentador para realizar la actualización
                    presenter.updatePelicula(currentPelicula);
                }
            }
        });
    }

    @Override
    public void onUpdateSuccess() {
        // Mostrar un mensaje de éxito
        Toast.makeText(this, "URL de la imagen actualizada con éxito", Toast.LENGTH_SHORT).show();
        finish();  // Volver a la pantalla anterior o cerrar la actividad
    }

    @Override
    public void onUpdateError(String error) {
        // Mostrar un mensaje de error
        Toast.makeText(this, "Error al actualizar la URL: " + error, Toast.LENGTH_SHORT).show();
    }
}
