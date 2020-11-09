package com.example.a02kotlin;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.a02kotlin.databinding.FragmentFiveDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FiveDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiveDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FiveDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FiveDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FiveDetailFragment newInstance(String param1, String param2) {
        FiveDetailFragment fragment = new FiveDetailFragment();
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

        FiveViewModel vm = ViewModelProviders.of(getActivity()).get(FiveViewModel.class);
        FragmentFiveDetailBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_five_detail,container,false);
        binding.setMData(vm);
        binding.setLifecycleOwner(getActivity());

        binding.buttonFiveBack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.fiveIndexFragment));
        /*
        up主您好，有个bug不太明白，在做用seekbar和加减号按钮在fragment之间传递数据的时候，点击自己创建的返回按钮是正常的，
        但是使用back或者导航栏的返回按钮回到第一个fragment的时候，数据没有改变，我debug的时候看到setProcess的是正确的值，
        但是接下来就触发了change事件，process是旧的值所以设置回去了？不知道为什么会这样，为什么自己创建的返回按钮就没有问题[热词系列_我哭了]
来自iOS客户端2020-09-09 00:11回复
进击的手柄回复 @longway777  :好的！谢谢up指点~[呲牙]
2020-09-09 09:55回复
longway777系统的back键默认行为是返回栈回退，你可以重写onBackPressed这个函数，把你自己的代码替换进去。
2020-09-09 00:37回复
        *
        * */


        return binding.getRoot();

//        return inflater.inflate(R.layout.fragment_five_detail, container, false);
    }
}