package com.gyk.haberapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<NewsSite> newsSiteList;
    LayoutInflater layoutInflater;

    public CustomAdapter (List<NewsSite> newsSiteList, Context context){
        this.newsSiteList = newsSiteList;
        this.layoutInflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return newsSiteList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsSiteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        row_view = layoutInflater.inflate(R.layout.custom_row_layout,null);

        ImageView imageViewNewsPhoto = (ImageView)
                row_view.findViewById(R.id.imageViewNewsSitePhoto);
        TextView textViewNewsName = (TextView)
                row_view.findViewById(R.id.textViewNewsSiteName);

        NewsSite goruntulenecekHaberSitesi = newsSiteList.get(i);

        textViewNewsName.setText(goruntulenecekHaberSitesi.getName());
        Picasso.get().load(goruntulenecekHaberSitesi.getPhotoUrl()).into(imageViewNewsPhoto);

        return row_view;
    }
}
