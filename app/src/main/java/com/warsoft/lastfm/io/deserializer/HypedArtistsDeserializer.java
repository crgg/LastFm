package com.warsoft.lastfm.io.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.warsoft.lastfm.domain.Artist;
import com.warsoft.lastfm.io.model.HypedArtistsResponse;
import com.warsoft.lastfm.io.model.JsonKeys;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ander on 27/12/2015.
 */
public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistsResponse> {
    @Override
    public HypedArtistsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        HypedArtistsResponse response = gson.fromJson(json, HypedArtistsResponse.class);
       //obtener el objeto artist
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);
     //obtener el array artist
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);
//convertir el json array a objetos de la clase artist
        response.setArtist(extracArtistsFromJsonArray(artistArray));
        return response;

    }

    private ArrayList<Artist> extracArtistsFromJsonArray(JsonArray array) {
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();
            Artist currentArtist = new Artist();
            String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();

            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGES);
            String[] images = extractArtistImageFromJsonArray(imagesArray);
            currentArtist.setName(name);
            currentArtist.setUrlLargeImage(images[1]);
            currentArtist.setUrlMediumImage(images[0]);
            artists.add(currentArtist);
        }
        return artists;
    }

    private  String[] extractArtistImageFromJsonArray(JsonArray imagesArray){
        String[] image = new String[2];

        for (int i= 0; i<imagesArray.size();i++){
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();
            String size = imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGE_URL).getAsString();


            if(url.isEmpty()){
                url=null;
            }else {
                url=url.replaceAll("\\/","/");
            }
            if (size.matches(JsonKeys.IMAGE_MEDIUM)){
                image[0]=url;
            }
            else if (size.matches(JsonKeys.IMAGE_LARGE)){
                image[1]=url;
            }
        }
        return image;
    }
}
