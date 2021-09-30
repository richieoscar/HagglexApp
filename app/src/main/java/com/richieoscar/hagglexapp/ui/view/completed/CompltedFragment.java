package com.richieoscar.hagglexapp.ui.view.completed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.databinding.FragmentCompltedBinding;

public class CompltedFragment extends Fragment {
    private FragmentCompltedBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCompltedBinding.inflate(inflater, container, false);
        binding.startExploring.setOnClickListener(v->{
            Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_compltedFragment_to_dashBoardFragment);
        });
        return binding.getRoot();
    }
}