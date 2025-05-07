package com.example.chapterseven;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, emailText;

        public UserViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.userName);
            emailText = itemView.findViewById(R.id.userEmail);
        }
    }

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameText.setText(user.name);
        holder.emailText.setText(user.email);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

