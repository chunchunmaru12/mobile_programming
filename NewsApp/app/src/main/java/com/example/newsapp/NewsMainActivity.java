package com.example.newsapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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
        emptyPlaceholder = findViewById(R.id.emptyPlaceholder);
        loadingSpinner = findViewById(R.id.loadingSpinner);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        newsList = new ArrayList<>();
        filteredNewsList = new ArrayList<>();
        adapter = new NewsDataAdapter(this, filteredNewsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);
        fetchNews();

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterNews(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            // Clear the old data before refreshing
            newsList.clear();
            filteredNewsList.clear();
            adapter.notifyDataSetChanged();
            fetchNews();
        });
    }

    private void fetchNews() {
        if (!swipeRefreshLayout.isRefreshing()) {
            loadingSpinner.setVisibility(View.VISIBLE);
            emptyPlaceholder.setVisibility(View.GONE);
        }

        String url = "https://newsapi.org/v2/everything?q=tesla&from=2025-04-07&sortBy=publishedAt&apiKey=53ec1625ca314db6bd6499990a398f2c";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray articles = response.getJSONArray("articles");
                        newsList.clear();

                        for (int i = 0; i < articles.length(); i++) {
                            JSONObject article = articles.getJSONObject(i);

                            String title = article.optString("title", "No Title Available");
                            String description = article.optString("description", "No Description Available");
                            String date = article.optString("publishedAt", "Unknown Date");
                            String imageUrl = article.optString("urlToImage", "");
                            String articleUrl = article.optString("url", "");
                            NewsData newsData = new NewsData(title, description, date, imageUrl, articleUrl);
                            newsList.add(newsData);
                        }

                        filteredNewsList.clear();
                        filteredNewsList.addAll(newsList);
                        updatePlaceholderVisibility();
                        adapter.notifyDataSetChanged();

                        Log.d("inside", "meow");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                        loadingSpinner.setVisibility(View.GONE);
                        swipeRefreshLayout.setRefreshing(false);
                    }

                },
                error -> {
                    if (error.networkResponse != null) {
                        String errorMsg = new String(error.networkResponse.data);
                        int statusCode = error.networkResponse.statusCode;
                        Log.e("NewsAppError", "Status Code: " + statusCode);
                        Log.e("NewsAppError", "Error Response: " + errorMsg);
                        Toast.makeText(NewsMainActivity.this, "Request failed: " + statusCode, Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("NewsAppError", "Network error without response.");
                        Toast.makeText(NewsMainActivity.this, "Network error. No response from server.", Toast.LENGTH_SHORT).show();
                    }
                    error.printStackTrace();
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
                headers.put("Accept-Language", "en-US,en;q=0.5");
                return headers;
            }
        };

        requestQueue.add(request);

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
