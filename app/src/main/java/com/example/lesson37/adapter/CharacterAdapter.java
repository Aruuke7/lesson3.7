package com.example.lesson37.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson37.databinding.RecyclerViewItemBinding;
import com.example.lesson37.model.CharacterModel;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private ArrayList<CharacterModel> list = new ArrayList<>();
    private OnItemClickListener listener;

    public CharacterAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(ArrayList<CharacterModel> list, OnItemClickListener listener){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerViewItemBinding binding;

        public ViewHolder(@NonNull RecyclerViewItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(CharacterModel characterModel, OnItemClickListener listener) {
            binding.imageRecycler.setImageResource(characterModel.getImage());
            binding.textRecycler.setText(characterModel.getName());
            binding.textRecycler2.setText(characterModel.getSecondName());
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
