package domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salvador on 07/08/2015.
 */
public class Artistas {
    @SerializedName("name")
    String artistName;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
