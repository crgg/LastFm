package com.warsoft.lastfm.domain;

import com.google.gson.annotations.SerializedName;
import com.warsoft.lastfm.io.model.JsonKeys;

/**
 * Created by ander on 26/12/2015.
 */
public class Artist {
    @SerializedName(JsonKeys.ARTIST_NAME)
    String name;

    String urlLargeImage;
    String urlMediumImage;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }
}
