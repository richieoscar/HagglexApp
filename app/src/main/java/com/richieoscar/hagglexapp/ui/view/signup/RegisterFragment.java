package com.richieoscar.hagglexapp.ui.view.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        binding.backButton.setOnClickListener(v->{
            Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_registerFragment_to_loginFragment);
        });

        binding.signup.setOnClickListener(view -> {
            Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_registerFragment_to_verifyFragment);
        });
        return binding.getRoot();
    }
}