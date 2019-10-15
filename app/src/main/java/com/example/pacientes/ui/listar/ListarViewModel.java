package com.example.pacientes.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is listar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}