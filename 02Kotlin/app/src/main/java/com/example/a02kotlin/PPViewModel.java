package com.example.a02kotlin;

import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class PPViewModel extends ViewModel {

    private static final String Number_Key  = "NUMBER";
    private SavedStateHandle handle;
    public PPViewModel(SavedStateHandle handle) {

        if (!this.handle.contains(Number_Key)){
            this.handle.set(Number_Key,0);
        }

        this.handle = handle;
    }

    public  LiveData<Integer> getNumber(){
        return this.handle.get(Number_Key);
    }
    public void  caseAdd(Integer n){

       Integer number =  Integer.parseInt(String.valueOf(getNumber().getValue()));
       Integer i = number + n;
       this.handle.set(Number_Key,i.toString());
    }


}
