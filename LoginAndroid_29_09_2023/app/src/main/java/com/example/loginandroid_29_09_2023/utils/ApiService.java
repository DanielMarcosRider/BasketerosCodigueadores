package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.login_user.loginParams.LoginParams;
import com.example.loginandroid_29_09_2023.login_user.model.data.MyData;
import com.example.loginandroid_29_09_2023.lstMov.data.DataMovies;

import java.util.ArrayList;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import retrofit2.http.Query;

public interface ApiService {

    public static final String URL ="http://localhost:3000/";


      @Headers({
              "Accept: application/json",
              "Content-Type: application/json"
      })

      Call<MyData> getDataUser(@Query("ACTION") String action);
      @GET("MyServlet")
        Call<MyData> getDataUser(@Query("ACTION") String action,
                                 @Query("EMAIL") String email,
                                 @Query("PASSWORD") String pass);

    @GET("MyServlet")
        Call<ArrayList<Pelicula>> getMovies(@Query("genre") String genre,
                                            @Query("year") Integer year,
                                            @Query("director") String director);


        @GET("MyServlet")
        Call<DataMovies> getDataMovies(@Query("ACTION") String action);

        @GET("MyServlet")
        Call<DataMovies> getDataMovies2(@Query("ACTION") String action);




        @PUT("pelicula")
        Call<Void> updatePelicula(@Body Pelicula pelicula);

        /*
 main
        @GET("MyServlet")
          Call<MyData> getMyData(@Query("id") String id);
/*
        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);

        */
        @POST("/login")
        Call<MyData> login(@Body LoginParams loginParams);


        @POST("/login")
        Call<MyData> login(@Field("username") String username, @Field("password") String password);

}
