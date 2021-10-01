package com.richieoscar.hagglexapp.ui.view.login;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloMutationCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.richieoscar.hagglexapp.LoginUserMutation;
import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

   private FragmentLoginBinding binding;
    private LoginViewmodel viewmodel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.email.setBoxStrokeColor(Color.TRANSPARENT);
        viewmodel = new ViewModelProvider(getActivity()).get(LoginViewmodel.class);
        login();
        navigateToRegister();
        return binding.getRoot();
    }

    private void login() {
        binding.login.setOnClickListener(v -> {
            loginUser();
        });
    }

    private void loginUser() {
        binding.errorText.setVisibility(View.INVISIBLE);
        showProgressBar();
        if (validateInputs()) return;
        makeLoginRequest();
    }
    private boolean validateInputs() {
        if (binding.emailText.getText().toString().isEmpty()) {
            binding.email.setError(getString(R.string.email_error_message));
            hideProgressbar();
            return true;
        }
        if (binding.passweordText.getText().toString().isEmpty()) {
            binding.password.setError(getString(R.string.password_error_message));
            hideProgressbar();
            return true;
        }
        return false;
    }

    private void makeLoginRequest() {
        new Handler().post(() -> {
            ApolloMutationCall<LoginUserMutation.Data> call = viewmodel.loginUser(binding.emailText.getText().toString(),
                    binding.passweordText.getText().toString());
            call.enqueue(new ApolloCall.Callback<LoginUserMutation.Data>() {
                @Override
                public void onResponse(@NonNull Response<LoginUserMutation.Data> response) {
                    if(!response.hasErrors() && (response.getData() != null)) {
                        naviagteToDashBoard();
                        System.out.println(response.getData().toString());
                        hideProgressbar();
                    }
                    else {
                        if(response.hasErrors()){
                            System.out.println(response.getData());
                            hideProgressbar();
                            displayErrorMessage();
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull ApolloException e) {
                    displayErrorMessage();
                }
            });
        });
    }

    private void displayErrorMessage() {
     binding.errorText.post(() -> {
         binding.errorText.setVisibility(View.VISIBLE);
     });
    }

    private void hideProgressbar() {
        binding.progressBar.setVisibility(View.INVISIBLE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }
    void naviagteToDashBoard() {
        Navigation.findNavController(getActivity(), R.id.container).navigate(
                R.id.action_loginFragment_to_dashBoardFragment);

    }

    private void navigateToRegister() {
        binding.newuser.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.container).navigate(
                    R.id.action_loginFragment_to_registerFragment
            );
        });
    }
}