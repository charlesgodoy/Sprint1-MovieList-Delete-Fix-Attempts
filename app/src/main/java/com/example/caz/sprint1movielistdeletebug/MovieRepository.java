package com.example.caz.sprint1movielistdeletebug;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.ArrayList;

public class MovieRepository {

    private ArrayList<Movie> movies;

    public MovieRepository() {
        this.movies = new ArrayList<>();
    }

    public MutableLiveData<ArrayList<Movie>> getMovies() {
        MutableLiveData<ArrayList<Movie>> liveDataList = new MutableLiveData<>();
        liveDataList.setValue(movies);
        return liveDataList;
    }

    public ArrayList<Movie> addMovie(Movie movie) {
        if(movie.getId() == Movie.NO_ID) {
            int movieIndex = movies.size();
            movie.setId(movieIndex);
            movies.add(movie);
        } else {
            movies.set(movie.getId(), movie);
        }

        return movies;
    }

// start of code to test movie delete

//    public ArrayList<Movie> removeMovie(Movie movie) {
//        if(movie.getId() == Movie.NO_ID) {
//            int movieIndex = movies.size();
//            movie.setId(movieIndex);
//            movies.remove(movie);
//        }
//
//        return movies;
//    }

    public ArrayList<Movie> removeMovie(Movie movie) {
//        if(movie.getId() == Movie.NO_ID) {
//            int movieIndex = movies.size();
//            movie.setId(movieIndex);
//        }


        movies.remove(movie);

        return movies;
    }

    // end of code to test delete


// Temporary code to for testing delete

//    public ArrayList<Movie> removeMovie(Movie movie) {
//
//        movies.remove(movie);
//
//
//        return movies;
//    }




}
