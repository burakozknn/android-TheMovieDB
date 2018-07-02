package com.gmail.burakozknn.popularmovies;

import retrofit.Callback;
import retrofit.http.GET;


public interface MoviesApiService {

    // to pull up popular movies from the movie database
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);

    // to pull up top rated movies from the movie database
    @GET("/movie/top_rated")
    void getTopMovies(Callback<Movie.MovieResult> cb);

}
