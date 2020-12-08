package com.example.comicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.*;

import com.example.comicapp.R;
import com.example.comicapp.object.ChapComic;

import java.util.ArrayList;

public class ChapComicAdapter extends ArrayAdapter<ChapComic> {
        private Context ct;
        private ArrayList<ChapComic> arr;

    public ChapComicAdapter( Context context, int resource,List<ChapComic> objects) {
        super(context, resource,objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_chap_comic,null);

        }
        if(arr.size()>0){
            TextView txvChapName,txvDateSubmit;
            txvChapName=convertView.findViewById(R.id.txvChapName);
            txvDateSubmit=convertView.findViewById(R.id.txvDateSubmit);

            ChapComic chapComic=arr.get(position);
            txvChapName.setText(chapComic.getNameChap());
            txvDateSubmit.setText(chapComic.getDateSubmit());
        }
        return convertView;
    }
}
