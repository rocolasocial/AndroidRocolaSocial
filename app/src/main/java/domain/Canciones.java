package domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salvador on 07/08/2015.
 */
public class Canciones {

        @SerializedName("name")
        String name;

        @SerializedName("duration")
        String duration;

        @SerializedName("artist")
        //Artist es una clase
                Artistas artist;

        @SerializedName("playcount")
        int playCount;

        @SerializedName("listeners")
        int listeners;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Artistas getArtist() {
            return artist;
        }

        public void setArtist(Artistas artist) {
            this.artist = artist;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getListeners() {
            return listeners;
        }

        public void setListeners(int listeners) {
            this.listeners = listeners;
        }

        @Override
        public String toString() {
            return "Canciones{" +
                    "name='" + name + '\'' +
                    ", duration='" + duration + '\'' +
                    ", artistName='" + artist.getArtistName() + '\'' +
                    ", playCount=" + playCount +
                    ", listeners=" + listeners +
                    '}';
        }
    }
