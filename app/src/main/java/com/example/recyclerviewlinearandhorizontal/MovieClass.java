package com.example.recyclerviewlinearandhorizontal;

public class MovieClass {

    int movieImage;
    String movieTitle;
    String movieRating;
    boolean isSelected;

    public MovieClass() {
    }

    public MovieClass(int movieImage, String movieTitle, String movieRating, boolean isSelected) {
        this.movieImage = movieImage;
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
        this.isSelected = isSelected;
    }

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
