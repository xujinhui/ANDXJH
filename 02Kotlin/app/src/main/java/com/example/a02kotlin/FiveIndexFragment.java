package com.example.a02kotlin;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.databinding.BindingBuildInfo;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.a02kotlin.databinding.ActivityTwoBinding;
import com.example.a02kotlin.databinding.FragmentFiveIndexBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FiveIndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiveIndexFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FiveViewModel mFiveViewModel;
    private FragmentFiveIndexBinding mFiveIndexBinding;

    public FiveIndexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FiveIndexFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FiveIndexFragment newInstance(String param1, String param2) {
        FiveIndexFragment fragment = new FiveIndexFragment();
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
        // Inflate the layout for this fragment

        mFiveViewModel = ViewModelProviders.of(getActivity()).get(FiveViewModel.class);
        mFiveIndexBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_five_index,container,false);
        mFiveIndexBinding.setMData(mFiveViewModel);
        mFiveIndexBinding.setLifecycleOwner(getActivity());

        mFiveIndexBinding.seekBartFiveIndex.setProgress( mFiveViewModel.getNumber().getValue() );

        return  mFiveIndexBinding.getRoot();
//        return inflater.inflate(R.layout.fragment_five_index, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mFiveIndexBinding.buttonFiveIndexNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bd = new Bundle();
                bd.putString("number", String.valueOf( mFiveViewModel.getNumber().getValue() ));

                NavController nav = Navigation.findNavController(v);
                nav.navigate(R.id.fiveDetailFragment,bd);

//                System.out.println(" >>>> onClick");
//                Toast.makeText(getActivity(),"xxx",Toast.LENGTH_SHORT).show();
            }
        });

        SeekBar bar;
        bar = mFiveIndexBinding.seekBartFiveIndex;
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mFiveViewModel.getNumber().setValue(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


}