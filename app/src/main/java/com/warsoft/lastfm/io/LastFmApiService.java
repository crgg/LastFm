package com.warsoft.lastfm.io;
import com.warsoft.lastfm.domain.Artist;
import com.warsoft.lastfm.io.model.HypedArtistsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
/**
 * Created by ander on 27/12/2015.
 */
public interface LastFmApiService {

    @GET(ApiConstans.URL_HYPED_ARTISTS)
    Call<HypedArtistsResponse> getHypedArtists();

}
