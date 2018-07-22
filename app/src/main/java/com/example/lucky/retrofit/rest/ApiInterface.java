package com.example.lucky.retrofit.rest;

import com.example.lucky.retrofit.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


        @POST("movie/top_rated")
      Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apikey);


        @POST("movie/{id}")
        Call<MovieResponse>  getMovieDetails(@Path("id") int id, @Query("api_key") String apikey);
}
