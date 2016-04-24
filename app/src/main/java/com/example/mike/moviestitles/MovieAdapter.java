package com.example.mike.moviestitles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 25/01/2016.
 */
public class MovieAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public MovieAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{

        ImageView Poster;
        TextView title;
        TextView rating;

    }
    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);

    }


        @Override
                public int getCount(){

            return this.list.size();
        }

    @Override
     public Object getItem (int position){
        return this.list.get(position);
    }
    @Override
    public View getView (int position,View convertView,ViewGroup parent){
        View row;
        row=convertView;
        DataHandler handler;
        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row= inflater.inflate(R.layout.row_layout,parent,false);
            handler = new DataHandler();
            handler.Poster = (ImageView)row.findViewById(R.id.movie_poster);
            handler.title =(TextView)row.findViewById(R.id.movie_title);
            handler.rating =(TextView)row.findViewById(R.id.movie_rating);
            row.setTag(handler);
        }

        else {
            handler =(DataHandler)row.getTag();
        }
     MovieDataProvider dataProvider;
        dataProvider =(MovieDataProvider)this.getItem(position);
        handler.Poster.setImageResource(dataProvider.getMovie_poster_resource());
        handler.title.setText(dataProvider.getMovie_title());
        handler.rating.setText(dataProvider.getMovie_rating());


        return row;
    }
    }
