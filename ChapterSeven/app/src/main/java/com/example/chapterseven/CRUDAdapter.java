package com.example.chapterseven;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CRUDAdapter extends RecyclerView.Adapter<CRUDAdapter.CRUDViewHolder> {

    private List<DataModel> dataList;

    public CRUDAdapter(List<DataModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CRUDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crud_recycler_item, parent, false);
        return new CRUDViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CRUDViewHolder holder, int position) {
        DataModel model = dataList.get(position);
        holder.idText.setText(String.valueOf(model.getId()));
        holder.nameText.setText(model.getName());
        holder.addressText.setText(model.getAddress());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setTasks(List<DataModel> newDataList) {
        this.dataList = newDataList;
        notifyDataSetChanged();
    }

    public static class CRUDViewHolder extends RecyclerView.ViewHolder {
        TextView idText, nameText, addressText;

        public CRUDViewHolder(@NonNull View itemView) {
            super(itemView);
            idText = itemView.findViewById(R.id.idText);
            nameText = itemView.findViewById(R.id.rvName);
            addressText = itemView.findViewById(R.id.rvAddress);
        }
    }

}
