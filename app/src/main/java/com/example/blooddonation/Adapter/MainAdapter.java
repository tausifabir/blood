package com.example.blooddonation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.blooddonation.R;

import java.util.List;

public class MainAdapter extends ArrayAdapter {



    List<String> numberWord;
    List<Integer> image;
    Context context;
    int itemLayout;


    public MainAdapter(List<String> numberWord,List<Integer> image,Context context,int resource) {
        super(context, resource, numberWord);
        this.numberWord = numberWord;
        this.image = image;
        this.context = context;
        this.itemLayout = resource;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardstack_row,parent,false);

        }

        String word = numberWord.get(position);
        Integer layout = image.get(position);

        ImageView imageView = convertView.findViewById(R.id.layoutContain);
        imageView.setImageResource(layout);

        return convertView;
    }
}
