package com.warsoft.lastfm.io.model;

import com.google.gson.annotations.SerializedName;
import com.warsoft.lastfm.domain.Artist;


import java.util.ArrayList;

/**
 * Created by ander on 27/12/2015.
 */
public class HypedArtistsResponse {

@SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResult result;

    public ArrayList<Artist> getArtists(){
        return result.artists;
    }

private class HypedArtistsResult{
@SerializedName(JsonKeys.ARTISTS_ARRAY)
    ArrayList<Artist> artists;
}

}
