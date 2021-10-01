package com.richieoscar.hagglexapp.ui.view.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloMutationCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.richieoscar.hagglexapp.R;
import com.richieoscar.hagglexapp.RegisterUserMutation;
import com.richieoscar.hagglexapp.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private RegisterViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(RegisterViewModel.class);

        pop();
        signUp();
        return binding.getRoot();
    }

    private void pop() {
        binding.backButton.setOnClickListener(v->{
            Navigation.findNavController(getActivity(), R.id.container).navigate(R.id.action_registerFragment_to_loginFragment);
        });
    }

    private  void signUp(){
        binding.signup.setOnClickListener(view -> {
            signupUser();
        });
    }

    private  void signupUser(){
        binding.error.setVisibility(View.INVISIBLE);
        showProgressBar();
        if(validateInputs()) return;
        makeSignUpRequest();
    }

    private void displayErrorMessage() {
        binding.error.post(() -> {
            binding.error.setVisibility(View.VISIBLE);
        });
    }

    private void hideProgressbar() {
        binding.progressBar2.setVisibility(View.INVISIBLE);
    }

    private void showProgressBar() {
        binding.progressBar2.setVisibility(View.VISIBLE);
    }

    private void makeSignUpRequest() {
        ApolloMutationCall<RegisterUserMutation.Data> call =  viewModel.signUp(
                binding.emailText.getText().toString(),
                binding.passwordText.getText().toString(),
                binding.userNameText.getText().toString(),
                binding.ccp.getSelectedCountryCode() +binding.phoneText.getText().toString(),
                binding.referalText.getText().toString(),
                "Nigeria",
                "Naira"
        );

        call.enqueue(new ApolloCall.Callback<RegisterUserMutation.Data>() {
            @Override
            public void onResponse(@NonNull Response<RegisterUserMutation.Data> response) {
                if(!response.hasErrors()){
                    navigatetoVerify();
                    hideProgressbar();
                    System.out.println("Registration succesful");

                }
                else if(response.hasErrors()){
                    displayErrorMessage();
                    hideProgressbar();
                    System.out.println(response.getErrors());
                }
            }

            @Override
            public void onFailure(@NonNull ApolloException e) {
                displayErrorMessage();

            }
        });
    }

    void navigatetoVerify(){
        Navigation.findNavController(getActivity(), R.id.container)
                .navigate(R.id.action_registerFragment_to_verifyFragment);

    }

    boolean validateInputs(){
        if(binding.emailText.getText().toString().isEmpty()){
            binding.email.setError("Required");
            hideProgressbar();
            return true;
        }
        if(binding.passwordText.getText().toString().isEmpty()){
            binding.password.setError("Required");
            hideProgressbar();
            return true;
        }
        if(binding.passwordText.getText().toString().length() < 8){
            binding.password.setError("Password too short");
            hideProgressbar();
            return true;
        }
        if(binding.userNameText.getText().toString().isEmpty()){
            binding.username.setError("Required");
            hideProgressbar();
            return true;
        }
        if(binding.phoneText.getText().toString().isEmpty()){
            binding.password.setError("Required");
            hideProgressbar();
            return true;
        }
        return false;
    }
}