package com.example.lucky.retrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lucky.retrofit.R;
import com.example.lucky.retrofit.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieviewHolder> {

    private List<Movie> movies;
    private Context context;
    private int rawLayout;

    public MoviesAdapter(List<Movie> movies, int rawLayout, Context context) {
        this.movies = movies;
        this.context = context;
        this.rawLayout = rawLayout;
    }

    @NonNull
    @Override
    public MovieviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rawLayout,parent,false);
        return new MovieviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieviewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
       holder.movieRating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieviewHolder extends RecyclerView.ViewHolder{

        LinearLayout moviesLayout;
        TextView movieTitle,movieRating,data,movieDescription;

        public MovieviewHolder(View itemView) {
            super(itemView);

            moviesLayout =(LinearLayout)itemView.findViewById(R.id.linear_layout);
            movieRating =(TextView)itemView.findViewById(R.id.rating);
            data=(TextView)itemView.findViewById(R.id.subtitle);
            movieTitle=(TextView)itemView.findViewById(R.id.title);
            movieDescription = (TextView)itemView.findViewById(R.id.description);
        }
    }
}
