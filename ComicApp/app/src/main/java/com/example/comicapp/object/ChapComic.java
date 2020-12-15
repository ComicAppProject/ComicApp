package com.example.comicapp.object;

import org.json.JSONException;
import org.json.JSONObject;

public class ChapComic {
    private String nameChap,DateSubmit,id;
    public ChapComic(){}

    public String getNameChap() {
        return nameChap;
    }

    public void setNameChap(String nameChap) {
        this.nameChap = nameChap;
    }

    public String getDateSubmit() {
        return DateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        DateSubmit = dateSubmit;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public ChapComic(String nameChap, String DateSubmit){
        this.nameChap=nameChap;
        this.DateSubmit=DateSubmit;
    }

    public ChapComic(JSONObject o) throws JSONException {
        nameChap = o.getString("tenchap");
        DateSubmit = o.getString("ngaynhap");
        id = o.getString("id");
    }
}
