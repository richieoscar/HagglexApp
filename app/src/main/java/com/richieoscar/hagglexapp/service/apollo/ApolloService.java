package com.richieoscar.hagglexapp.service.apollo;

import com.apollographql.apollo.ApolloClient;

public class ApolloService {
   static final String BASE_ENDPOINT ="https://api-staging.hagglex.com/graphql";
   public static ApolloClient getClient(){
       ApolloClient client = new ApolloClient.builder()
               .serverUrl("https://api-staging.hagglex.com")
               .build();
       return client;

    }
}
