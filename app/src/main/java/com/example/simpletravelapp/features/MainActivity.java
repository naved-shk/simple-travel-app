package com.example.simpletravelapp.features;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.simpletravelapp.R;
import com.example.simpletravelapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
         mNavController = navHostFragment.getNavController();

        mAppBarConfiguration =
                new AppBarConfiguration.Builder(R.id.nav_home).build();

        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
        BottomNavigationView bottomNavigationView = binding.bottomNavView;
        NavigationUI.setupWithNavController(bottomNavigationView, mNavController);

        mNavController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()){
                case R.id.nav_login:
                case R.id.nav_register:
                        hideActionBar();
                        hideBottomNav();
                        break;
                case R.id.nav_home:
                    showBottomNav();
                    break;
                default:
                    showActionBar();
                    hideBottomNav();
            }

        });

    }

    private void hideActionBar() { getSupportActionBar().hide();}
    private void showActionBar()  { getSupportActionBar().show();}

    private void hideBottomNav() {binding.bottomNavView.setVisibility(View.GONE);}
    private void showBottomNav() {binding.bottomNavView.setVisibility(View.VISIBLE);}


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}