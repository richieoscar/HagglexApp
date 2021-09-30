package com.richieoscar.hagglexapp.ui.view.verify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.databinding.FragmentVerifyBinding;

public class VerifyFragment extends Fragment {
    private FragmentVerifyBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVerifyBinding.inflate(inflater, container, false);
        binding.verifyme.setOnClickListener(v->{
            Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_verifyFragment_to_compltedFragment);
        });

        binding.backButton.setOnClickListener(v->{
            Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_verifyFragment_to_registerFragment);
        });
        return binding.getRoot();
    }
}