package com.example.lesson37.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson37.databinding.RecyclerLocationBinding;
import com.example.lesson37.model.CharacterModel;
import com.example.lesson37.model.LocationModel;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private ArrayList<CharacterModel> list = new ArrayList<>();
    private OnItemClickListener listener;

    public LocationAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(ArrayList<CharacterModel> list,
                           OnItemClickListener listener){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RecyclerLocationBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerLocationBinding binding;

        public ViewHolder(@NonNull RecyclerLocationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(CharacterModel characterModel, OnItemClickListener listener) {
            binding.text1.setText(characterModel.getName());
            binding.text2.setText(characterModel.getSecondName());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(characterModel);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(CharacterModel characterModel);
    }
}
