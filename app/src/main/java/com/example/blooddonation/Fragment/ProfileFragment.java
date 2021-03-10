package com.example.blooddonation.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.StackView;
import android.widget.TableLayout;

import com.example.blooddonation.Adapter.CardStackAdapter;
import com.example.blooddonation.Adapter.MainAdapter;
import com.example.blooddonation.Adapter.ProfileFragmentAdapter;
import com.example.blooddonation.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {



    private CardStackView cardStackView;
    private StackView stackView;
    private CardStackAdapter cardStackAdapter;

    private MainAdapter mainAdapter;

    private RecyclerView profileRecyclerView;
    private ProfileFragmentAdapter profileFragmentAdapter;

    private ArrayList<String> fragmentTittle = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //cardStackView = view.findViewById(R.id.recyclerView);
        profileRecyclerView = view.findViewById(R.id.profileRecyclerView);
        fragmentTittle.add("Badges");
        fragmentTittle.add("Donation");
        fragmentTittle.add("Request");
        fragmentTittle.add("Info");
        fragmentTittle.add("Contact");



        //stackView = view.findViewById(R.id.cardStackView);
        profileFragmentAdapter = new ProfileFragmentAdapter(getContext(),fragmentTittle);
        cardStackAdapter = new CardStackAdapter(getContext(),fragmentTittle);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        profileRecyclerView.setLayoutManager(linearLayoutManager);
        profileRecyclerView.setAdapter(profileFragmentAdapter);



       // mainAdapter = new MainAdapter(numberWord(),layoutWord(),getContext(),R.layout.cardstack_row);
        //stackView.setAdapter(mainAdapter);


    }

    private List<String> numberWord(){

        ArrayList<String> word = new ArrayList<>();

        word.add("5");
        word.add("5");
        word.add("5");
        word.add("5");
        word.add("5");

        return word;

    }



    private List<Integer> layoutWord(){

        ArrayList<Integer> layouts = new ArrayList<>();

        layouts.add(R.drawable.earth);
        layouts.add(R.drawable.earth);
        layouts.add(R.drawable.earth);
        layouts.add(R.drawable.earth);
        layouts.add(R.drawable.earth);




        return layouts;

    }

}