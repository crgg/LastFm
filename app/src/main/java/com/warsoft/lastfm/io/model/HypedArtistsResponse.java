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

    public void setArtist(ArrayList<Artist> artist){
        this.result.artists= artist;
    }


    public ArrayList<Artist> getArtists(){
        return result.artists;
    }

private class HypedArtistsResult{

    ArrayList<Artist> artists;
}

}
