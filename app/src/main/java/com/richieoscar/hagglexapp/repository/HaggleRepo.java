package com.richieoscar.hagglexapp.repository;

import com.apollographql.apollo.ApolloMutationCall;
import com.richieoscar.hagglexapp.LoginUserMutation;
import com.richieoscar.hagglexapp.service.apollo.ApolloService;
import com.richieoscar.hagglexapp.type.LoginInput;

import org.jetbrains.annotations.NotNull;

public class HaggleRepo {
    private static final String TAG = "Cannot invoke method length() on null object";
    public ApolloMutationCall<LoginUserMutation.Data> loginUser(@NotNull String email, String password){
      LoginInput input =  new  LoginInput(email, password);

        ApolloMutationCall<LoginUserMutation.Data> call = ApolloService.getClient().mutate(
                new LoginUserMutation(input));
        return  call;
    }
}
