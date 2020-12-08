package com.example.comicapp.api;

import android.os.AsyncTask;

import com.example.comicapp.interfaces.LayChapVe;
import com.example.comicapp.interfaces.LayTruyenVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiGetChap extends AsyncTask<Void, Void, Void> {
    String data;

    public ApiGetChap(LayChapVe layChapVe, String idTruyen) {
        this.layChapVe = layChapVe;
        this.layChapVe.start();
        this.idTruyen = idTruyen;
    }

    LayChapVe layChapVe;
    String idTruyen;
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //.url("https://jsonkeeper.com/b/WXH8")
                //tạo api có thể thay đổi data
                .url("https://comicapp1.000webhostapp.com/Chap.php?id="+idTruyen)
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
          this.layChapVe.errored();
      }else {
          this.layChapVe.finish(data);
      }
    }
}
