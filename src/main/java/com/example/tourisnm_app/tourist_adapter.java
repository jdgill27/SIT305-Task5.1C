package com.example.tourisnm_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class tourist_adapter extends RecyclerView.Adapter<tourist_adapter.touristViewHolder> {

    private List<tourist_spot> tourist_spotList;
    private Context context;
    private OnRowClickListener listener;

    public tourist_adapter(List<tourist_spot> tourist_spotList, Context context, OnRowClickListener clickListener) {
        this.tourist_spotList = tourist_spotList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public touristViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.tourist_place, parent, false);
        return new touristViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull touristViewHolder holder, int position) {
        holder.des_image.setImageResource(tourist_spotList.get(position).getImage());
        holder.des_name.setText(tourist_spotList.get(position).getName());
        holder.des_desc.setText(tourist_spotList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return tourist_spotList.size();
    }

    public class touristViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView des_image;
        public TextView des_name, des_desc;
        public OnRowClickListener onRowClickListener;
        public touristViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            des_image = itemView.findViewById(R.id.image_card);
            des_name = itemView.findViewById(R.id.name_card);
            des_desc = itemView.findViewById(R.id.desc_card);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener{
        void onItemClick(int position);
    }
}
