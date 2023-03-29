package com.example.fitnessui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitnessui.FitnessMove;
import com.example.fitnessui.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PopupFragment extends Fragment {
    TextView nameText, descriptionText, calorie;
    ImageView imageView;
    ProgressBar progressBar;
    private FitnessMove fitnessMove;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popup, container, false);
        nameText = view.findViewById(R.id.fragment_popup_nameTextView);
        descriptionText = view.findViewById(R.id.fragment_popup_discruption);
        calorie = view.findViewById(R.id.fragment_popup_calori);
        imageView = view.findViewById(R.id.fragment_popup_imageView);
        progressBar = view.findViewById(R.id.fragment_popup_progressbar);

        nameText.setText(fitnessMove.getFitnessName());
        descriptionText.setText(fitnessMove.getFitnessDescription());
        calorie.setText(""+fitnessMove.getFitnessCalorie());
        Picasso.get().load(fitnessMove.getFitnessPictures()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
        return view;
    }

    public static PopupFragment newInstance() {
        return new PopupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fitnessMove = getActivity().getIntent().getParcelableExtra("Info");
    }
}
