package com.warsoft.lastfm.io;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                API_SERVICE = adapter.create(LastFmApiService.class);
            }
        return API_SERVICE;
    }
}
