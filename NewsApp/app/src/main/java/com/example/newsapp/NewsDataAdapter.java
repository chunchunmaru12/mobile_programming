package com.example.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.NewsViewHolder> {

    private List<NewsData> newsList;

    public NewsDataAdapter(NewsMainActivity newsMainActivity, List<NewsData> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_items, parent, false);
        return new NewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsData news = newsList.get(position);

        holder.titleTextView.setText(news.getTitle());
        holder.descriptionTextView.setText(news.getDescription());
        holder.dateTextView.setText(news.getDate());

        // Load the image using Glide
        Glide.with(holder.imageView.getContext())
                .load(news.getImageUrl())
                .placeholder(R.mipmap.ic_launcher_icon)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(v -> {
            String url = news.getUrl();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            holder.itemView.getContext().startActivity(intent);
        });
        // Set click listener for the share button
        holder.shareButton.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");

            shareIntent.putExtra(Intent.EXTRA_SUBJECT, news.getTitle());
            shareIntent.putExtra(Intent.EXTRA_TEXT, news.getTitle() + "\n" + news.getDescription() + "\nRead more: " + news.getUrl());

            holder.itemView.getContext().startActivity(Intent.createChooser(shareIntent, "Share News via"));
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, descriptionTextView, dateTextView;
        Button shareButton;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rvImage);
            titleTextView = itemView.findViewById(R.id.rvName);
            descriptionTextView = itemView.findViewById(R.id.rvDescription);
            dateTextView = itemView.findViewById(R.id.rvDate);
            shareButton = itemView.findViewById(R.id.btnShare);
        }
    }
}
