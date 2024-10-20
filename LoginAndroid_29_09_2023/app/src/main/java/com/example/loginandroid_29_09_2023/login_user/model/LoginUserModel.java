package com.example.loginandroid_29_09_2023.login_user.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.loginParams.LoginParams;
import com.example.loginandroid_29_09_2023.login_user.model.data.MyData;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {
    private static final String IP_BASE = "localhost:3000/";
    private LoginUserPresenter presenter;
    public LoginUserModel(LoginUserPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(User user, final OnLoginUserListener onLoginUserListener) {

        ApiService apiService = RetrofitCliente.getClient(  "http://" +IP_BASE + "login").create(ApiService.class);

        LoginParams loginParams = new LoginParams(user.getUsername(),user.getToken() );

        Call<MyData> call = apiService.login(loginParams);
        System.out.printf(String.valueOf(loginParams));

       // Call<MyData> call = apiService.login (user.getUsername(), user.getToken());
        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    MyData myData = response.body();

                    //String message = myData.getMessage();

                    ArrayList<User> lstUsers = myData.getLstUsers();

                    onLoginUserListener.onFinished(lstUsers.get(0));

                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
                    // Manejar una respuesta no exitosa
                    // Manejar una respuesta no exitosa
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                // Manejar errores de red o del servidor
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
    }

