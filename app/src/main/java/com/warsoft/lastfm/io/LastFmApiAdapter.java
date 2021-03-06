package com.warsoft.lastfm.io;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.warsoft.lastfm.io.deserializer.HypedArtistsDeserializer;
import com.warsoft.lastfm.io.model.HypedArtistsResponse;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


/**
 * Created by ander on 27/12/2015.
 */
public class LastFmApiAdapter {
    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService() {



            if (API_SERVICE == null) {

                Retrofit adapter = new Retrofit.Builder()
                        .baseUrl(ApiConstans.URL_BASE)
                        .addConverterFactory(GsonConverterFactory.create(buildLastFmApiGsonConverter()))
                        .build();
                API_SERVICE = adapter.create(LastFmApiService.class);
            }
        return API_SERVICE;
    }

    private static Gson buildLastFmApiGsonConverter() {
                Gson gsonConf = new GsonBuilder()
                        .registerTypeAdapter(HypedArtistsResponse.class, new HypedArtistsDeserializer())
                        .create();


              return gsonConf;
           }



}
