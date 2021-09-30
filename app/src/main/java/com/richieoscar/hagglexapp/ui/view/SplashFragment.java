package com.richieoscar.hagglexapp.ui.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.richieoscar.hagglexapp.R;


public class SplashFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              gotoLogin();
            }
        }, 2000);

        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    private void gotoLogin() {
        Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_splashFragment_to_loginFragment);
    }
}