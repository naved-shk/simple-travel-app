package com.example.simpletravelapp.features.auth;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

public class AuthViewModel extends ViewModel {

    private  AuthRepository repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public AuthViewModel() {
        this.repository = new AuthRepository();
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
    }


    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

    public void register(String email , String pass){
        repository.register(email, pass);
    }

    public void login(String email , String pass){
        repository.login(email, pass);
    }

    public void logOut(){
        repository.signOut();
    }
}
