package com.example.comicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.comicapp.adapter.ChapComicAdapter;
import com.example.comicapp.api.ApiGetChap;
import com.example.comicapp.interfaces.LayChapVe;
import com.example.comicapp.object.ChapComic;
import com.example.comicapp.object.Comic;

import org.json.JSONArray;

import java.util.ArrayList;

import static com.example.comicapp.R.layout.activity_chap;

public class ChapActivity extends AppCompatActivity implements LayChapVe {
TextView txvTenTruyens;
ImageView imgAnhTruyens;
Comic comic;
ListView lsvDanhsachChap;
ArrayList<ChapComic> arrChap;
ChapComicAdapter chapComicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_chap);
        init();
        anhXa();
        setClick();
        setUp();
        new ApiGetChap (this, comic.getId()).execute();
    }
    private void init(){
        Bundle b=getIntent().getBundleExtra("data");
        comic=(Comic)b.getSerializable("Truyen");
        //tao du lieu ao
       arrChap=new ArrayList<>();
     /*   for (int i=0;i<20;i++){
            arrChap.add(new ChapComic("Chapter"+i,"06-12-2020" ));
        }
        chapComicAdapter=new ChapComicAdapter(this,0,arrChap);*/
    }
    private void anhXa(){
        imgAnhTruyens=findViewById(R.id.imgAnhTruyens);
        lsvDanhsachChap=findViewById(R.id.lsvDanhsachChap);
        txvTenTruyens=findViewById(R.id.txvTenTruyens);
    }
    private void setUp() {
        txvTenTruyens.setText(comic.getNameComic());
        Glide.with(this).load(comic.getLinkImage()).into(imgAnhTruyens);
        //lsvDanhsachChap.setAdapter(chapComicAdapter);
    }
    private void setClick(){
        lsvDanhsachChap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b=new Bundle();
                b.putString("idChap",arrChap.get(i).getId());
                Intent intent=new Intent(ChapActivity.this,DocTruyenActivity.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }

    @Override
    public void start() {
        Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish(String data) {
        try{
            JSONArray array = new JSONArray(data);
            for(int i = 0; i < array.length(); i++){
                ChapComic chapComic = new ChapComic(array.getJSONObject(i));
                arrChap.add(chapComic);
            }
            chapComicAdapter=new ChapComicAdapter(this,0,arrChap);
            lsvDanhsachChap.setAdapter(chapComicAdapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void errored() {

    }
}