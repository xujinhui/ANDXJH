package com.example.a02kotlin;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

     private MutableLiveData<Integer> number;
     public MutableLiveData<Integer> getNumber() {

          if (this.number == null){
               this.number = new MutableLiveData<>();
               this.number.setValue(999);
          }

          return number;
     }

    public void add(Integer n){

        Integer count = this.getNumber().getValue() + n;
         this.number.setValue(count);
        Log.d("xxxx >> ", "add: " + this.number.getValue() );
    }

     public void  caseReset(){
         Log.d("xxxx >> ", "caseReset: ");
         this.number.setValue(0);
     }
}
