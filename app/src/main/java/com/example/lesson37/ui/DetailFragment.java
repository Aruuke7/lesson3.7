package com.example.lesson37.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson37.R;
import com.example.lesson37.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        safeArgs();
    }



    private void safeArgs() {
        if (getArguments()!=null){
            DetailFragmentArgs argument = DetailFragmentArgs.fromBundle(getArguments());
            binding.text1.setText(argument.getModel().getName());
            binding.text2.setText(argument.getModel().getSecondName());
            binding.image.setImageResource(argument.getModel().getImage());

        }
    }
}