package com.example.simpletravelapp.features.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simpletravelapp.R;
import com.example.simpletravelapp.databinding.FragmentRegisterBinding;
import com.example.simpletravelapp.features.auth.AuthViewModel;
import com.google.firebase.auth.FirebaseUser;


public class RegisterFragment extends Fragment {

    private AuthViewModel viewModel;
    private NavController navController;
    private FragmentRegisterBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        viewModel.getUserData().observe(this, firebaseUser -> {
            if (firebaseUser != null){
                navController.navigate(R.id.action_nav_register_to_nav_home);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        setUpListener();
    }

    private void setUpListener() {

        binding.tvLogin.setOnClickListener(v -> {
            navController.navigate(R.id.action_nav_register_to_nav_login);
        });

        binding.btnSignUp.setOnClickListener(v -> {
            String email = binding.tILEmail.getEditText().getText().toString();
            String pass = binding.tILPassword.getEditText().getText().toString();

            if (!email.isEmpty() && !pass.isEmpty()){
                viewModel.register(email , pass);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}