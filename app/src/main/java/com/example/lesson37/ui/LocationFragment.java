package com.example.lesson37.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson37.R;
import com.example.lesson37.adapter.CharacterAdapter;
import com.example.lesson37.adapter.LocationAdapter;
import com.example.lesson37.databinding.FragmentLocationBinding;
import com.example.lesson37.model.CharacterModel;
import com.example.lesson37.model.LocationModel;

import java.util.ArrayList;

public class LocationFragment extends Fragment implements LocationAdapter.OnItemClickListener {

    private FragmentLocationBinding binding;
    private ArrayList<CharacterModel> list;
    private LocationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addList();
        initRecycler();
    }

    private void initRecycler() {
        list = new ArrayList<>();
        adapter = new LocationAdapter(new LocationAdapter.OnItemClickListener() {
            @Override
            public void onClick(CharacterModel characterModel) {
                NavHostFragment.findNavController(LocationFragment.this).navigate(LocationFragmentDirections.actionLocationFragmentToDetailFragment(characterModel));
            }
        });
        adapter.updateData(addList(),this);
        binding.recyclerLocation.setAdapter(adapter);

    }

    private ArrayList<CharacterModel> addList() {
        list = new ArrayList<>();
        list.add(new CharacterModel("Planet","Earth (C-137)",R.drawable.details));
        list.add(new CharacterModel("Cluster","Abadango",R.drawable.details));
        list.add(new CharacterModel("Space Station","Citadel of Ricks",R.drawable.details));
        list.add(new CharacterModel("Planet","Worldender's lair",R.drawable.details));
        list.add(new CharacterModel("Microverse","Anatomy Park",R.drawable.details));
        list.add(new CharacterModel("TV","Interdimensional Cable",R.drawable.details));
        list.add(new CharacterModel("Resort","Immortality Field Resort",R.drawable.details));
        list.add(new CharacterModel("Planet","Post-Apocalyptic Earth",R.drawable.details));
        list.add(new CharacterModel("Planet","Purge Planet",R.drawable.details));
        list.add(new CharacterModel("Planet","Venzenulon 7",R.drawable.details));
        list.add(new CharacterModel("Planet","Bepis 9",R.drawable.details));
        list.add(new CharacterModel("Planet","Cronenberg Earth",R.drawable.details));
        list.add(new CharacterModel("Planet","Nuptia 4",R.drawable.details));
        list.add(new CharacterModel("Fantasy town","Giants Town",R.drawable.details));
        list.add(new CharacterModel("Planet","Bird World",R.drawable.details));
        list.add(new CharacterModel("Space Station","St. Gloopy Noops Hospital",R.drawable.details));
        list.add(new CharacterModel("Planet","Earth (5-126",R.drawable.details));
        list.add(new CharacterModel("Dream","Mr. Goldenfold's dream",R.drawable.details));
        list.add(new CharacterModel("Planet","Gromflom Prime",R.drawable.details));
        list.add(new CharacterModel("Planet","Earth (Rpl. Dimension)",R.drawable.details));

        return list;
    }

    @Override
    public void onClick(CharacterModel characterModel) {

    }
}