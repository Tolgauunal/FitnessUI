package com.example.fitnessui.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.PopupActivity;
import com.example.fitnessui.RecylerView.FitnessPictureAdapter;
import com.example.fitnessui.R;

import java.util.ArrayList;

public class FitnessPictures extends Fragment implements FitnessPictureAdapter.Mylistener {
    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;

    public static FitnessPictures newInstance() {
        return new FitnessPictures();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Fragment view tanımlamasını ve diğer tanımlamaları yaptık.
        View view = inflater.inflate(R.layout.fragment_pictures, container, false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(), this);
        fitnessMoves = fitnessPictureAdapter.getFitnessMoves();
        recyclerView = view.findViewById(R.id.fragment_picture_recylerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        if (isAdded()) {
            recyclerView.setAdapter(fitnessPictureAdapter);
        }
        getFitnessMoves(fitnessMoves);
        return view;
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves) {
        //FitnessMove class tanımladık ve değerlerini doldurduk
        for (int i = 0; i < 16; i++) {
            fitnessMoves.add(new FitnessMove("Fitness Move Name" + i,
                    "https://i0.wp.com/post.healthline.com/wp-content/uploads/2019/12/pull-up-pullup-gym-1296x728-header-1296x728.jpg?w=1575",
                    "Fitness Move Discrpition",
                    100));
        }
        return fitnessMoves;
    }

    @Override
    public void Mylistener(FitnessMove fitnessMove) {
        Intent intent = PopupActivity.newIntent(getActivity(), fitnessMove);
        startActivity(intent);
    }
}
