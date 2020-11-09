package com.example.a02kotlin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FiveViewModel extends ViewModel {

    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {

        if (number == null){
            number = new MutableLiveData<Integer>();
            number.setValue(99);
        }

        return number;
    }

    public void  add(Integer n){

        Integer value =  number.getValue();
        value = value + n;
        if(value < 0){
            value = 0;
        } else if(value > 100) {
            value = 100;
        }

        number.setValue( value );
    }
}
