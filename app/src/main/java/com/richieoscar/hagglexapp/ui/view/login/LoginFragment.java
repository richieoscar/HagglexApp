package com.richieoscar.hagglexapp.ui.view.login;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloMutationCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.richieoscar.hagglexapp.LoginUserMutation;
import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    private LoginViewmodel viewmodel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.email.setBoxStrokeColor(Color.TRANSPARENT);
        viewmodel = new ViewModelProvider(getActivity()).get(LoginViewmodel.class);
        ApolloMutationCall<LoginUserMutation.Data> call = viewmodel.loginUser(binding.emailText.getText().toString(), binding.passweordText.getText().toString());
        call.enqueue(new ApolloCall.Callback<LoginUserMutation.Data>() {
            @Override
            public void onResponse(@NonNull Response<LoginUserMutation.Data> response) {
                if (!response.hasErrors()){
                    naviagteToDashBoard();
                }
            }

            @Override
            public void onFailure(@NonNull ApolloException e) {
                Toast.makeText(getContext(), "Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }

    void login(){

    }
    void naviagteToDashBoard(){
        binding.button.setOnClickListener(v->{
            Navigation.findNavController(getActivity(),R.id.container).navigate(
                    R.id.action_loginFragment_to_dashBoardFragment
            );
        });
    }

    private void navigateToRegister(){
        binding.newuser.setOnClickListener(v->{
            Navigation.findNavController(getActivity(),R.id.container).navigate(
                    R.id.action_loginFragment_to_registerFragment
            );
        });
    }
}