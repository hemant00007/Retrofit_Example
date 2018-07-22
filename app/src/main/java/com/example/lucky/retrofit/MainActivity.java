package com.example.lucky.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lucky.retrofit.adapter.MoviesAdapter;
import com.example.lucky.retrofit.model.Movie;
import com.example.lucky.retrofit.model.MovieResponse;
import com.example.lucky.retrofit.rest.ApiClient;
import com.example.lucky.retrofit.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Movie> contacts;

    private static final  String API_KEY = "cd007d5a471ebe6a62dfff62e72afeb3";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(API_KEY.isEmpty()){

            Toast.makeText(getApplicationContext(),"please enter the api key",Toast.LENGTH_SHORT).show();
            return;
        }
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiservice = ApiClient.getClient().create(ApiInterface.class);
                            Call<MovieResponse> call =apiservice.getTopRatedMovies(API_KEY);
                            call.enqueue(new Callback<MovieResponse>() {
                                @Override
                                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                                   // int statusCode = response.code();
                                    List<Movie> movies = response.body().getResults();
                                    recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.movie_list_data, getApplicationContext()));


                                    Log.d(TAG,"NUMBER OF MOVIES RECEIVE = " + movies.size());
                                }

                                @Override
                                public void onFailure(Call<MovieResponse> call, Throwable t) {

                                    Log.d(TAG, t.toString());

                                }
                            });
    }
}
