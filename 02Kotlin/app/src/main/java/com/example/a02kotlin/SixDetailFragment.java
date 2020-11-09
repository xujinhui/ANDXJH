package com.example.a02kotlin;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a02kotlin.databinding.FragmentSixDetailBinding;
import com.example.a02kotlin.databinding.FragmentSixIndexBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SixDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SixDetailFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentSixDetailBinding mBinding;
    public SixDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SixDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SixDetailFragment newInstance(String param1, String param2) {
        SixDetailFragment fragment = new SixDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentSixDetailBinding binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_six_detail,container,false);
        mBinding = binding;
        binding.buttonCl0.setOnClickListener(this);
        binding.buttonCl1.setOnClickListener(this);
        binding.buttonCl2.setOnClickListener(this);
        binding.buttonCl3.setOnClickListener(this);
        binding.buttonCl4.setOnClickListener(this);
        binding.buttonCl5.setOnClickListener(this);
        binding.buttonCl6.setOnClickListener(this);
        binding.buttonCl7.setOnClickListener(this);
        binding.buttonCl8.setOnClickListener(this);
        binding.buttonCl9.setOnClickListener(this);
        binding.buttonClCc.setOnClickListener(this);
        binding.buttonClCm.setOnClickListener(this);

        return  binding.getRoot();
//        return inflater.inflate(R.layout.fragment_six_detail, container, false);
    }

    @Override
    public void onClick(View v) {

        Button sender = (Button) v;

//        System.out.println(" xxxx >>>" + Integer.valueOf() );

        TextView textView_result =  getView().findViewById(R.id.textView_result);
        if (v.getId() == R.id.button_cl_cc){
            textView_result.setText(R.string.text_place_holder);
            return;
        }

        if (v.getId() == R.id.button_cl_cm){
            System.out.println("2 >>>" + sender.getText());
            return;
        }

        String text =  String.valueOf(textView_result.getText()).trim();
        String value =  String.valueOf(sender.getText()).trim();
        Integer result_a = 0;
        Integer result_b = 0;

//        方法dao一:this.getString(R.string.resource_name);
//        方法二:getResources().getString(R.string.resource_name);
        if ( text.equals(this.getString(R.string.text_place_holder)) ){
            text = "0";
        }

        try {
            result_a  = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        try {
            result_b  = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        String tmp =  String.valueOf(result_a) + String.valueOf(result_b);
        textView_result.setText( tmp  );
    }
}

//        在run之前，rebuild project，你可能用了注解框架类似androidannotation，运行前最好rebuild一下，应该没问题