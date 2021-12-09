package com.example.simpletravelapp.features.help_center;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.simpletravelapp.features.help_center.model.HelpCenterQA;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class HelpCenterViewModel extends ViewModel {

    MutableLiveData<List<HelpCenterQA>> helpCenterQAListMutableLiveData;
    HelpCenterRepository helpCenterQARepository;

    public HelpCenterViewModel() {
        helpCenterQARepository = new HelpCenterRepository();
        helpCenterQAListMutableLiveData=  helpCenterQARepository.getHelpCenterQAListMutableLiveData();
    }

    public MutableLiveData<List<HelpCenterQA>> getLiveHelpCenterQAData() {
        return helpCenterQAListMutableLiveData;
    }
}
