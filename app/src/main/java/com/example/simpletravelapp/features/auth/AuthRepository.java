package com.example.simpletravelapp.features.auth;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthRepository {

    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private MutableLiveData<Boolean> userLoggedMutableLiveData;
    private FirebaseAuth auth;

    public AuthRepository() {
        firebaseUserMutableLiveData = new MutableLiveData<>();
        userLoggedMutableLiveData = new MutableLiveData<>();
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){
            firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
        }
    }

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public MutableLiveData<Boolean> getUserLoggedMutableLiveData() {
        return userLoggedMutableLiveData;
    }

    public void register(String email , String pass){
        auth.createUserWithEmailAndPassword(email , pass).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
            }else{
                Log.d("tag", "register: "+ task.getException().getMessage());
            }
        });
    }

    public void login(String email , String pass){
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
                Log.d("tag", "login successfull: "+ task.isSuccessful());
            }else{
                Log.d("tag", "register: "+ task.getException().getMessage());
            }
        });
    }

    public void signOut(){
        auth.signOut();
        userLoggedMutableLiveData.postValue(true);
    }
}
