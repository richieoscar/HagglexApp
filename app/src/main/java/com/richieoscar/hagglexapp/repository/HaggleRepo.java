package com.richieoscar.hagglexapp.repository;

import com.apollographql.apollo.ApolloMutationCall;
import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.Operation;
import com.richieoscar.hagglexapp.LoginUserMutation;
import com.richieoscar.hagglexapp.RegisterUserMutation;
import com.richieoscar.hagglexapp.service.apollo.ApolloService;
import com.richieoscar.hagglexapp.type.CreateUserInput;
import com.richieoscar.hagglexapp.type.LoginInput;

import org.jetbrains.annotations.NotNull;

public class HaggleRepo {
    private static HaggleRepo instance;

    public static  HaggleRepo getInstance() {
        if (instance == null) {
            return new HaggleRepo();
        } else {
            return instance;
        }
    }

    private HaggleRepo() {
    }

    public ApolloMutationCall<LoginUserMutation.Data> loginUser(@NotNull String email, String password) {
        LoginInput.Builder input = LoginInput.builder();
        input.input(email);
        input.password(password);
        ApolloMutationCall<LoginUserMutation.Data> call = ApolloService.getClient().mutate(
                new LoginUserMutation(input.build()));
        return call;
    }

    public ApolloMutationCall<RegisterUserMutation.Data> signUpUser(
            String email,
            String password,
            String userName,
            String phoneNumber,
            String referralCode,
            String country,
            String currency
    ) {
        CreateUserInput.Builder input = CreateUserInput.builder();
        input.email(email);
        input.password(password);
        input.username(userName);
        input.phonenumber(phoneNumber);
        input.referralCode(referralCode);
        input.country(country);
        input.currency(currency);
        Input<CreateUserInput> createUserInputInput = Input.fromNullable(input.build());

        ApolloMutationCall<RegisterUserMutation.Data> call = ApolloService.getClient().mutate(
                new RegisterUserMutation(createUserInputInput));
        return call;
    }


}