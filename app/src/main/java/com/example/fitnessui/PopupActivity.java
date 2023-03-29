package com.example.fitnessui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fitnessui.Fragment.PopupFragment;

public class PopupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupactivity);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.popupactivtyFrame);
        if (fragment == null) {
            fragment = PopupFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.popupactivtyFrame, fragment).commit();
        }
    }

    public static Intent newIntent(Context context, FitnessMove fitnessMove) {
        Intent intent = new Intent(context, PopupActivity.class);
        intent.putExtra("Info", fitnessMove);
        return intent;
    }
}
