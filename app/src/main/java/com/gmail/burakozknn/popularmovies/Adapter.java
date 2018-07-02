package com.gmail.burakozknn.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public static class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

        private List<Movie> mMovieList;
        private LayoutInflater mInflater;
        private Context mContext;


        public MoviesAdapter(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from( context );
            this.mMovieList = new ArrayList<>();
        }


        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate( R.layout.row_movie, parent, false );
            MovieViewHolder viewHolder = new MovieViewHolder( view );

            return viewHolder;
        }


        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            Movie movie = mMovieList.get( position );


            // Picasso to load images from the internet.
            Picasso.with( mContext )
                    .load( movie.getPoster() )
                    .placeholder( R.color.colorPrimary )
                    .into( holder.imageView );


        }

        @Override
        public int getItemCount() {
            return (mMovieList == null) ? 0 : mMovieList.size();
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;


            public MovieViewHolder(final View itemView) {
                super( itemView );
                imageView = (ImageView) itemView.findViewById( R.id.imageView );


                //on item click

                itemView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //int position
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {


                            //Toast.makeText( v.getContext(), "You clicked", Toast.LENGTH_SHORT ).show();


                            Intent intent = new Intent( v.getContext(), DetailActivity.class );
                            intent.putExtra( "movie_title", mMovieList.get( position ).getTitle() );
                            intent.putExtra( "movie_image", mMovieList.get( position ).getPoster() );
                            intent.putExtra( "movie_overview", mMovieList.get( position ).getDescription() );
                            intent.putExtra( "movie_average", mMovieList.get( position ).getRating() );
                            intent.putExtra( "movie_release_date", mMovieList.get( position ).getReleaseDate() );

                            v.getContext().startActivity( intent );

                        }
                    }
                } );

            }

        }

        public void setMovieList(List<Movie> movieList) {
            this.mMovieList.clear();
            this.mMovieList.addAll( movieList );

            // The adapter needs to know that the data has changed. If we don't call this, app will crash.
            notifyDataSetChanged();
        }


    }
}
