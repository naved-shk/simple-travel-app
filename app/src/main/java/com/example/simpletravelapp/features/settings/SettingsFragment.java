package com.example.simpletravelapp.features.settings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simpletravelapp.R;
import com.example.simpletravelapp.databinding.FragmentLoginBinding;
import com.example.simpletravelapp.databinding.FragmentSettingsBinding;


public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private NavController mNavController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        setUpListener();
    }

    private void setUpListener() {
        binding.llRateFeedback.setOnClickListener(v -> {

        });

        binding.llHelpCenter.setOnClickListener(v -> {
            mNavController.navigate(R.id.action_nav_settings_to_nav_help_center);
        });
    }
}