package com.example.pacientes.ui.credits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pacientes.R;

public class CreditsFragment extends Fragment {

    private CreditsViewModel creditsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        creditsViewModel =
                ViewModelProviders.of(this).get(CreditsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_credits, container, false);
       // final TextView textView = root.findViewById(R.id.text_tools);
        creditsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
          //      textView.setText(s);
            }
        });
        return root;
    }
}