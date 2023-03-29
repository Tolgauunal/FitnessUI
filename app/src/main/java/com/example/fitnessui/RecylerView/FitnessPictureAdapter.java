package com.example.fitnessui.RecylerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.R;

import java.util.ArrayList;

public class FitnessPictureAdapter extends RecyclerView.Adapter<FitnessPictureViewHolder> implements View.OnClickListener {

    private ArrayList<FitnessMove> fitnessMoves;
    private LayoutInflater layoutInflater;
    private AppCompatActivity appCompatActivity;
    private Mylistener mylistener;

    public FitnessPictureAdapter(AppCompatActivity appCompatActivity, Mylistener mylistener) {
        this.appCompatActivity = appCompatActivity;
        this.mylistener = mylistener;
        layoutInflater = appCompatActivity.getLayoutInflater();
        fitnessMoves = new ArrayList<>();
    }

    public ArrayList<FitnessMove> getFitnessMoves() {
        return fitnessMoves;
    }

    @NonNull
    @Override
    public FitnessPictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recylerview_fitness_pictures_list, parent, false);
        view.setOnClickListener(this);
        return new FitnessPictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessPictureViewHolder holder, int position) {
        holder.getMoves(appCompatActivity, fitnessMoves.get(position));
    }

    public interface Mylistener {
        void Mylistener(FitnessMove fitnessMove);
    }

    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() instanceof FitnessMove) {
            FitnessMove fitnessMove = (FitnessMove) view.getTag();
            mylistener.Mylistener(fitnessMove);
        }
    }
}
