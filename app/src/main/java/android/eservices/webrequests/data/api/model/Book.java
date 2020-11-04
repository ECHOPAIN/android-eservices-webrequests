package android.eservices.webrequests.data.api.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//reponse json de l'api
public class Book {
    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public void setVolumeInfo(BookInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
    private BookInfo volumeInfo;
    private boolean isFavorite;

    public String getId() {
        return id;
    }

    public BookInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setFavorite() {
        isFavorite = true;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
