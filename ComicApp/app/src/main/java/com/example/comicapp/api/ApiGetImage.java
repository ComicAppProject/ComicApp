package com.example.comicapp.api;

import android.os.AsyncTask;

import com.example.comicapp.interfaces.LayAnhVe;
import com.example.comicapp.interfaces.LayTruyenVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiGetImage extends AsyncTask<Void, Void, Void> {
    String data;
    String idChap;
    LayAnhVe layAnhVe;
    public ApiGetImage(LayAnhVe layAnhVe, String idChap) {
        this.layAnhVe = layAnhVe;
        this.idChap=idChap;
        this.layAnhVe.start();
    }

    LayTruyenVe layTruyenVe;
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()

                //.url("https://jsonkeeper.com/b/5IQU")
                .url("https://comicapp1.000webhostapp.com/Anh.php?idChap="+idChap)
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        }catch(IOException e){
            data = null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      if (data == null){
          this.layAnhVe.errored();
      }else {
          this.layAnhVe.finish(data);
      }
    }
}
