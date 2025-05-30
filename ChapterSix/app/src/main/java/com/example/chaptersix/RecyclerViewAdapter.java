package com.example.chaptersix;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Activity context;
    int[] images;
    String[] names;
    String[] phones;
    public  RecyclerViewAdapter(Activity context,String[] names,String[] phones, int[] images){
        this.context=context;
        this.names=names;
        this.phones=phones;
        this.images=images;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View listItem= inflater.inflate(R.layout.recyclerview_items,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public  void onBindViewHolder(@NonNull ViewHolder holder,int postion){
        holder.txtName.setText(names[postion]);
        holder.txtPhone.setText(phones[postion]);
        holder.imageView.setImageResource(images[postion]);
    }
    @Override
    public  int getItemCount(){
        return names.length;
    }
    public static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtPhone;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtName=itemView.findViewById(R.id.rvName);
            txtPhone=itemView.findViewById(R.id.rvTextPhone);
            imageView=itemView.findViewById(R.id.rvImage);

        }

    }
}
