package com.example.chaptersix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.activity.EdgeToEdge;
import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    RecyclerView movieView;
    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie);

        movieView = findViewById(R.id.movieView);
        movieView.setLayoutManager(new LinearLayoutManager(this));

        movieList.add(new Movie("The Batman", "Action", 2022, R.mipmap.shinobu_image_foreground));
        movieList.add(new Movie("Inception", "Sci-Fi", 2010, R.mipmap.ganyu_image_layer));
        movieList.add(new Movie("Avengers", "Superhero", 2019, R.mipmap.keqing_image_foreground));
        movieList.add(new Movie("Interstellar", "Sci-Fi", 2014, R.mipmap.shinobu_image_foreground));

        MovieAdapter adapter = new MovieAdapter(this, movieList);
        movieView.setAdapter(adapter);
    }
}
