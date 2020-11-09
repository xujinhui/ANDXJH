package com.example.a02kotlin;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import com.example.a02kotlin.databinding.ActivityTwoBinding;

public class TwoActivity extends AppCompatActivity {

    private  TwoViewModel mVCModel;
    private  ActivityTwoBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        mVCModel = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(),this)).get(TwoViewModel.class);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_two);
        mBinding.setMData(mVCModel);
        mBinding.setLifecycleOwner(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

}
