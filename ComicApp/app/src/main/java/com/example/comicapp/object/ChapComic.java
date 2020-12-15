package com.example.comicapp.object;

import org.json.JSONException;
import org.json.JSONObject;

public class ChapComic {
<<<<<<< HEAD
    private String nameChap,DateSubmit,id;
=======
    private String nameChap,DateSubmit;
>>>>>>> origin/master
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

<<<<<<< HEAD
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

=======
>>>>>>> origin/master
    public ChapComic(String nameChap, String DateSubmit){
        this.nameChap=nameChap;
        this.DateSubmit=DateSubmit;
    }
<<<<<<< HEAD

    public ChapComic(JSONObject o) throws JSONException {
        nameChap = o.getString("tenchap");
        DateSubmit = o.getString("ngaynhap");
        id = o.getString("id");
=======
    public ChapComic(JSONObject o) throws JSONException {
        nameChap = o.getString("tenchap");
        DateSubmit = o.getString("ngaynhap");
>>>>>>> origin/master
    }
}
