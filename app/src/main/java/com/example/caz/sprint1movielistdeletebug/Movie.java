package com.example.caz.sprint1movielistdeletebug;

import java.io.Serializable;

public class Movie implements Serializable {
    public static final int NO_ID = -1;

    private String title;
    private int id;
    private boolean watchedMovie = false;          //new checkbox code
    private boolean movieDelete = false;                                            // code to test delete

    //stop
    //stop
    //stop
    public Movie(int id, String title, boolean watchedMovie) {
        this.title = title;
        this.id = id;
        this.watchedMovie = watchedMovie;
    }

    public boolean getMovieDelete() {
        return movieDelete;
    }

    public void setMovieDelete(boolean movieDelete) {
        this.movieDelete = movieDelete;
    }


    //    public boolean isMovieDelete() {                                                // code to test delete
//        movieDelete = true;                                                         // code to test delete
//        return movieDelete;                                                         // code to test delete
//    }

    public boolean isWatchedMovie() {

        return watchedMovie;
    }

    public void setWatchedMovie(boolean watchedMovie) {
        this.watchedMovie = watchedMovie;
    }


    public Movie(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
