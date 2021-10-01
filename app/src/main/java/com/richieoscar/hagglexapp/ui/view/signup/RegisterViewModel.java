package com.richieoscar.hagglexapp.ui.view.signup;

import androidx.lifecycle.ViewModel;

import com.apollographql.apollo.ApolloMutationCall;
import com.richieoscar.hagglexapp.RegisterUserMutation;
import com.richieoscar.hagglexapp.repository.HaggleRepo;

public class RegisterViewModel extends ViewModel {

    public ApolloMutationCall<RegisterUserMutation.Data> signUp(
            String email,
            String password,
            String username,
            String phoneNumber,
            String referralCode,
            String country,
            String currency) {
        return HaggleRepo.getInstance().signUpUser(
                email, password, username, phoneNumber, referralCode, country, currency);

    }
}
