package com.example.comicapp.object;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Comic implements Serializable {
    private String Id, nameComic, nameChap, LinkImage;

    public Comic(){

    }
    public Comic(JSONObject o) throws JSONException {
        Id = o.getString("Id");
        nameComic = o.getString("nameComic");
        nameChap = o.getString("nameChap");
        LinkImage = o.getString("linkImage");
    }
    public Comic(String Id, String nameComic, String nameChap, String linkImage) {
        this.Id = Id;
        this.nameComic = nameComic;
        this.nameChap = nameChap;
        LinkImage = linkImage;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNameComic() {
        return nameComic;
    }

    public void setNameComic(String nameComic) {
        this.nameComic = nameComic;
    }

    public String getNameChap() {
        return nameChap;
    }

    public void setNameChap(String nameChap) {
        this.nameChap = nameChap;
    }

    public String getLinkImage() {
        return LinkImage;
    }

    public void setLinkImage(String linkImage) {
        LinkImage = linkImage;
    }


}
