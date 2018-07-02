package com.gmail.burakozknn.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //public static final String EXTRA_POSITION = "extra_position";
    //private static final int DEFAULT_POSITION = -1;

    TextView mTitle, mOverview, mRating, mReleaseDate;
    ImageView mImageUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );

        // Title
        mTitle = (TextView) findViewById( R.id.mTitle ) ;

        String title = getIntent().getExtras().getString("movie_title");

        mTitle.setText( title );

        // Movie poster
        String image = getIntent().getExtras().getString("movie_image");

        mImageUrl = (ImageView) findViewById( R.id.mImageUrl );

        Picasso.with( this )
                .load( image )
                .into( mImageUrl );

        // overview

        mOverview = (TextView) findViewById( R.id.mOverview );
        String overview = getIntent().getExtras().getString("movie_overview");
        mOverview.setText( overview );

        // vote_average

        mRating = (TextView) findViewById( R.id.mRating );
        String vote_average = getIntent().getExtras().getString("movie_average");
        mRating.setText( vote_average );

        //  release date
        mReleaseDate = (TextView) findViewById( R.id.mReleaseDate );
        String release_date = getIntent().getExtras().getString("movie_release_date");
        mReleaseDate.setText( release_date );








    }
}
