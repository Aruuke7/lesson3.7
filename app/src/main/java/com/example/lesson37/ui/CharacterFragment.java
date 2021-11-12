package com.example.lesson37.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lesson37.R;
import com.example.lesson37.adapter.CharacterAdapter;
import com.example.lesson37.databinding.FragmentCharacterBinding;
import com.example.lesson37.model.CharacterModel;
import com.example.lesson37.model.LocationModel;

import java.util.ArrayList;


public class CharacterFragment extends Fragment implements CharacterAdapter.OnItemClickListener {

   private FragmentCharacterBinding binding;
    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private ArrayList<CharacterModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerview();
    }

    private void initRecyclerview() {
        recyclerView = binding.recyclerView;
        adapter = new CharacterAdapter(new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onClick(CharacterModel characterModel) {
                NavHostFragment.findNavController(CharacterFragment.this).navigate(CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(characterModel));
            }
        });
        adapter.updateData(addList(), this);
        recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }



    private ArrayList<CharacterModel> addList() {
        list = new ArrayList<>();
        list.add(new CharacterModel("Alive","Rick Sanchez",R.drawable.rick_sanchez));
        list.add(new CharacterModel("Alive","Morty Smith",R.drawable.morty));
        list.add(new CharacterModel("Dead","Albert Einstein",R.drawable.ic_einshtein));
        list.add(new CharacterModel("Alive","Jerry Smith Sanchez",R.drawable.ic_smith));

        return list;
    }

    @Override
    public void onClick(CharacterModel characterModel) {

    }
}