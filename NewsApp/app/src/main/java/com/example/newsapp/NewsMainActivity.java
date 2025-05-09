package com.example.newsapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsMainActivity extends AppCompatActivity {
    private NewsDataAdapter adapter;
    private List<NewsData> newsList;
    private List<NewsData> filteredNewsList;
    private RequestQueue requestQueue;
    private TextView emptyPlaceholder;
    private ProgressBar loadingSpinner;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewTodos);
        EditText searchBar = findViewById(R.id.searchBar);
        Button searchButton = findViewById(R.id.searchButton);
        emptyPlaceholder = findViewById(R.id.emptyPlaceholder);
        loadingSpinner = findViewById(R.id.loadingSpinner);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        newsList = new ArrayList<>();
        filteredNewsList = new ArrayList<>();
        adapter = new NewsDataAdapter(this, filteredNewsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Initialize the request queue
        requestQueue = Volley.newRequestQueue(this);

        // Search button click listener
        searchButton.setOnClickListener(v -> {
            String query = searchBar.getText().toString().trim();
            if (!query.isEmpty()) {
                fetchNews(query);
            } else {
                Toast.makeText(this, "Please enter a search term", Toast.LENGTH_SHORT).show();
            }
        });
        fetchNews("tesla");

    }

    public void fetchNews(String query) {
        String url = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=" + "53ec1625ca314db6bd6499990a398f2c";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray articles = response.getJSONArray("articles");
                            List<NewsData> newsItemsList = new ArrayList<>();

                            for (int i = 0; i < articles.length(); i++) {
                                JSONObject article = articles.getJSONObject(i);

                                String title = article.getString("title");
                                String description = article.getString("description");
                                String publishedAt = article.getString("publishedAt");
                                String urlToImage = article.getString("urlToImage");
                                String articleUrl = article.optString("url", "");
                                NewsData newsItem = new NewsData(title, description, publishedAt, urlToImage,articleUrl);
                                newsItemsList.add(newsItem);
                            }
                            filteredNewsList.clear();
                            filteredNewsList.addAll(newsItemsList);
                            updatePlaceholderVisibility();
                            adapter.notifyDataSetChanged();



                        } catch (JSONException e) {
                            e.printStackTrace();
                        } finally {
                            loadingSpinner.setVisibility(View.GONE);
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        if (error.networkResponse != null) {
                            int statusCode = error.networkResponse.statusCode;
                            String body = new String(error.networkResponse.data);
                            Toast.makeText(NewsMainActivity.this,
                                    "HTTP " + statusCode + "\n" + body,
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(NewsMainActivity.this,
                                    "Network error: " + error.toString(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("User-Agent", "Mozilla/5.0");
                return headers;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }


    private void filterNews(String query) {
        filteredNewsList.clear();
        for (NewsData news : newsList) {
            if (news.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredNewsList.add(news);
            }
        }
        updatePlaceholderVisibility();
        adapter.notifyDataSetChanged();
    }

    private void updatePlaceholderVisibility() {
        if (filteredNewsList.isEmpty()) {
            emptyPlaceholder.setVisibility(View.VISIBLE);
        } else {
            emptyPlaceholder.setVisibility(View.GONE);
        }
    }
}
