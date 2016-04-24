package com.example.mike.moviestitles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int []movie_poster_resource={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10};
    String [] movie_titles;
    String [] movie_ratings;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.list_view);
        movie_titles =getResources().getStringArray(R.array.Movies_Titles);
        movie_ratings =getResources().getStringArray(R.array.Movie_Ratings);
        int i=0;
        adapter = new MovieAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(adapter);
        for (String titles:movie_titles){

            MovieDataProvider dataProvider= new MovieDataProvider(movie_poster_resource[i],titles,movie_ratings[i]);

            adapter.add(dataProvider);
            i++;
        }
    }


}
