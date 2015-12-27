package com.warsoft.lastfm.io;
import retrofit.Callback;
import retrofit.http.GET;
/**
 * Created by ander on 27/12/2015.
 */
public interface LastFmApiService {

    @GET(ApiConstans.URL_HYPED_ARTISTS)
    void getHypedArtists (Callback<> serverResponse);

}
