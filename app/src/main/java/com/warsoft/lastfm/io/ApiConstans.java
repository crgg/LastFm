package com.warsoft.lastfm.io;

/**
 * Created by ander on 27/12/2015.
 */
public class ApiConstans {
    public static final String API_KEY = "6780ba40d84b36a6166a595df62add7b";
    public static final String URL_BASE = "http://ws.audioscrobbler.com";
    public static final String PATH_VERSION = "/2.0";
    public static final String VALUE_HYPED_ARTISTS_METHOD= "chart.gethypedartists";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";
    public static final String VALUE_JSON = "json";
    public static final String URL_HYPED_ARTISTS = "?" + PARAM_API_KEY + "=" + API_KEY
            + "&" + PARAM_METHOD + "=" + VALUE_HYPED_ARTISTS_METHOD + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;

}
