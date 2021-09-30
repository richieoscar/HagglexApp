package com.richieoscar.hagglexapp.ui.view.login;


import androidx.lifecycle.ViewModel;

import com.apollographql.apollo.ApolloMutationCall;
import com.richieoscar.hagglexapp.LoginUserMutation;
import com.richieoscar.hagglexapp.repository.HaggleRepo;

public class LoginViewmodel extends ViewModel {
    HaggleRepo haggleRepo = new HaggleRepo();

   public ApolloMutationCall<LoginUserMutation.Data> loginUser(String email, String password){
       return haggleRepo.loginUser(email, password);
    }
}
