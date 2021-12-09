package com.example.simpletravelapp.features.help_center;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.simpletravelapp.features.help_center.model.HelpCenterQA;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HelpCenterRepository {

    MutableLiveData<List<HelpCenterQA>> helpCenterQAListMutableLiveData;
    FirebaseFirestore mFirestore;
    MutableLiveData<HelpCenterQA> helpCenterQAMutableLiveData;

    public HelpCenterRepository() {
        this.helpCenterQAListMutableLiveData = new MutableLiveData<>();
        mFirestore = FirebaseFirestore.getInstance();
        helpCenterQAMutableLiveData = new MutableLiveData<>();

    }

    public MutableLiveData<List<HelpCenterQA>> getHelpCenterQAListMutableLiveData() {

        mFirestore.collection("helpCenterQA").addSnapshotListener((value, error) -> {
            List<HelpCenterQA> helpCenterQAList = new ArrayList<>();
            for (QueryDocumentSnapshot doc : value) {
                if (doc != null) {
                    helpCenterQAList.add(doc.toObject(HelpCenterQA.class));
                }
            }
            helpCenterQAListMutableLiveData.postValue(helpCenterQAList);
        });
        return helpCenterQAListMutableLiveData;
    }
}
