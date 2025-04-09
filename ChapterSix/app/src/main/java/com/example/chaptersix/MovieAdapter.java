package com.example.chaptersix;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Activity context;
    List<Movie> movieList;

    public MovieAdapter(Activity context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.txtTitle.setText(movie.getTitle());
        holder.txtGenre.setText(movie.getGenre());
        holder.year.setText(String.valueOf(movie.getYear()));
        holder.imageView.setImageResource(movie.getImage());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtGenre, year;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.rvTitle);
            txtGenre = itemView.findViewById(R.id.rvGenre);
            year = itemView.findViewById(R.id.rvYear);
            imageView = itemView.findViewById(R.id.rvImage);
        }
    }
}
