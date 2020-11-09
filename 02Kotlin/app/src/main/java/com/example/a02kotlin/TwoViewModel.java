package com.example.a02kotlin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class TwoViewModel extends ViewModel {

    private static final String NUMBER_KEY = "NUMBER";
    private SavedStateHandle handle;

    public TwoViewModel(SavedStateHandle handle) {

        if (!handle.contains( NUMBER_KEY )){
            handle.set(NUMBER_KEY,1);
        }

        this.handle = handle;
    }

    public LiveData<Integer> getNumber(){

        return this.handle.getLiveData(NUMBER_KEY);
    }

    public void  caseAdd(Integer n){

        this.handle.set(NUMBER_KEY, (getNumber().getValue() + n) );
    }
}
