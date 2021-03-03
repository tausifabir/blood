package com.example.blooddonation.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blooddonation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplashFragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashFragment_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button splashStartButton;
    private SplashFragmentInterface2 splashFragmentInterface2;
    public SplashFragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SplashFragment_2.
     */
    // TODO: Rename and change types and number of parameters
    public static SplashFragment_2 newInstance(String param1, String param2) {
        SplashFragment_2 fragment = new SplashFragment_2();
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
        return inflater.inflate(R.layout.test2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        splashStartButton = view.findViewById(R.id.splashStartTest);

        splashStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splashFragmentInterface2 = (SplashFragmentInterface2) getActivity();
                splashFragmentInterface2.replaceSecondFragment();
            }
        });


    }

    public interface SplashFragmentInterface2{

        void replaceSecondFragment();

    }
}