package com.example.blooddonation.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.blooddonation.Activity.DonationActivity;
import com.example.blooddonation.Activity.MyRequestActivity;
import com.example.blooddonation.Activity.PostRequestActivity;
import com.example.blooddonation.Activity.UrgentRequestsActivity;
import com.example.blooddonation.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageSlider imageSlider;

    private GraphView lineGraph;

    private ImageView urgentRequests,myPostedRequested,postRequest,bookImage,donationImage;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSlider = view.findViewById(R.id.slider);


        urgentRequests = view.findViewById(R.id.urgentRequests);
        myPostedRequested = view.findViewById(R.id.myPostedRequested);
        postRequest = view.findViewById(R.id.postRequest);
        donationImage = view.findViewById(R.id.donationImage);
        bookImage = view.findViewById(R.id.bookImage);


        lineGraph = (GraphView) view.findViewById(R.id.line_graph);

        LineGraphSeries<DataPoint> lineSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(2, 3),
                new DataPoint(3, 10),
                new DataPoint(4, 6),
                new DataPoint(6, 17),
                new DataPoint(7, 10)
        });
        lineGraph.addSeries(lineSeries);
        //lineSeries.setColor(R.color.Theme);

        lineSeries.setColor(Color.RED);
        lineSeries.setDrawDataPoints(true);
        lineSeries.setDataPointsRadius(10);
        lineSeries.setThickness(8);
        lineSeries.setAnimated(true);

        /*Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
        lineSeries.setCustomPaint(paint);*/


        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.earth));
        slideModels.add(new SlideModel(R.drawable.earthdown));
        imageSlider.setImageList(slideModels,true);


        urgentRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UrgentRequestsActivity.class));
            }
        });

        myPostedRequested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyRequestActivity.class));
            }
        });


        postRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PostRequestActivity.class));
            }
        });

        donationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DonationActivity.class));
            }
        });


    }
}