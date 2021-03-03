package com.example.blooddonation.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blooddonation.Activity.LoginActivity;
import com.example.blooddonation.Activity.SplashActivity3;
import com.example.blooddonation.R;
import com.example.blooddonation.SharedPreferencs.SharedPreference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplashFragment_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashFragment_3 extends Fragment {

    private Button splashJourneyButton;

    private SharedPreference sharedPreference;
    private SplashFragmentInterface3 splashFragmentInterface3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public SplashFragment_3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SplashFragment_3.
     */
    // TODO: Rename and change types and number of parameters
    public static SplashFragment_3 newInstance(String param1, String param2) {
        SplashFragment_3 fragment = new SplashFragment_3();
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
        return inflater.inflate(R.layout.fragment_splash_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        splashJourneyButton = view.findViewById(R.id.splashJourneyBtn);
        sharedPreference = new SharedPreference(getActivity());


        splashJourneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreference.setSplashStatus(true);
                getActivity().finish();
                startActivity(new Intent(getActivity().getBaseContext(),LoginActivity.class));

            }
        });


    }

    public interface SplashFragmentInterface3{

        void replaceThirdFragment();

    }
}