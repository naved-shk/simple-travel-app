package com.example.simpletravelapp.features.help_center;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simpletravelapp.databinding.FragmentHelpCenterBinding;
import com.example.simpletravelapp.features.help_center.model.HelpCenterQA;


public class HelpCenterFragment extends Fragment {

    private FragmentHelpCenterBinding binding;
    private HelpCenterQA mHelpCenterQA;
    private HelpCenterQAAdapter helpCenterQAAdapter;
    private HelpCenterViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HelpCenterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHelpCenterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpObserver();

    }

    private void setUpObserver() {
        mViewModel.getLiveHelpCenterQAData().observe(getViewLifecycleOwner(), helpCenterQAList -> {
            helpCenterQAAdapter = new HelpCenterQAAdapter(helpCenterQAList);
            binding.helpCenterQa.setAdapter(helpCenterQAAdapter);
            helpCenterQAAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}