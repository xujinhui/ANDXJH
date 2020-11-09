package com.example.a02kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.a02kotlin.databinding.ActivityPpBinding


class PPActivity : AppCompatActivity() {

//    class PPActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var mvcModel: MyViewModel;
    private  lateinit var mBinding: ActivityPpBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pp)

        mvcModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        mBinding =  DataBindingUtil.setContentView(this,R.layout.activity_pp);
        mBinding.mData =  mvcModel
        mBinding.setLifecycleOwner(this)


//        mBinding.data = mvcModel;
//        mBinding.lifecycleOwner;

//        user = User("leavesC", "123456")
//        activityMain2Binding.setUserInfo(user)

//        mvcModel.number.observe(this, Observer {
//            mBinding.textField.text = "${mvcModel.number.value}";
//        })
//
//        mBinding.buttonA.setOnClickListener(this);
//        mBinding.buttonB.setOnClickListener(this);
//        mBinding.buttonC.setOnClickListener(this);
//        mBinding.buttonReset.setOnClickListener(this);

    }

//    override fun onClick(v: View?) {
//
//        when( v){
//            mBinding.buttonA -> {
//                mvcModel.add(1);
//            }
//            mBinding.buttonB -> {
//                mvcModel.add(2);
//            }
//            mBinding.buttonC -> {
//                mvcModel.add(3);
//            }
//            else -> {
//                mvcModel.caseReset();
//            }
//        }
//    }
}