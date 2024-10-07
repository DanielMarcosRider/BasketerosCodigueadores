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

    private EditText edtTitle;
    private EditText edtDescription;
    private EditText edtDirector;
    private EditText edtYear;
    private EditText edtImageUrl;
    private Button btnUpdateMovie;

    private UpdateMoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mov);

        // Inicializamos los componentes de la interfaz
        initComponents();

    }

    private void initComponents() {
        edtTitle = findViewById(R.id.edtTitle);
        edtDescription = findViewById(R.id.edtDescription);
        edtDirector = findViewById(R.id.edtDirector);
        edtYear = findViewById(R.id.edtYear);
        edtImageUrl = findViewById(R.id.edtImageUrl);
        btnUpdateMovie = findViewById(R.id.btnUpdateMovie);

        btnUpdateMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear objeto Pelicula con los datos introducidos
                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(edtTitle.getText().toString());
                pelicula.setDescripcion(edtDescription.getText().toString());
                pelicula.setDirector(edtDirector.getText().toString());
                pelicula.setAnyo(Integer.parseInt(edtYear.getText().toString()));
                pelicula.setUrlImagen(edtImageUrl.getText().toString());

                // Llamar al presentador para realizar la actualización
                presenter.updatePelicula(pelicula);
            }
        });
    }

    @Override
    public void onUpdateSuccess() {
        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Película actualizada con éxito", Toast.LENGTH_SHORT).show();
        // Limpiar los campos o realizar otra acción
    }

    @Override
    public void onUpdateError(String error) {
        // Mostrar un mensaje de error
        Toast.makeText(this, "Error al actualizar la película: " + error, Toast.LENGTH_SHORT).show();
    }
}
