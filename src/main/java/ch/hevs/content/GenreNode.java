package ch.hevs.content;

import java.util.ArrayList;

public class GenreNode implements CatalogComponent {
    private String genre;
    private ArrayList<Movie> movies;
    private GenreNode leftSubGenre;
    private GenreNode rightSubGenre;

    public GenreNode(String genre) {
        this.genre = genre;
        movies = new ArrayList<Movie>();
        leftSubGenre = null;
        rightSubGenre = null;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addSubGenre(GenreNode newSubGenre) {
        if (leftSubGenre == null) {
            leftSubGenre = newSubGenre;
        } else {
            if (rightSubGenre == null) {
                rightSubGenre = newSubGenre;
            } else {
                throw new IllegalStateException("This genre has already 2 subgenres. (max 2)");
            }
        }
    }

    public String getGenre() {
        return genre;
    }

    public GenreNode getLeft() {
        return leftSubGenre;
    }

    public GenreNode getRight() {
        return rightSubGenre;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public void display() {
        System.out.println("--- " + genre + " ---");
        for (int i = 0; i < movies.size(); i++) {
            System.out.print(i + 1 + ") ");
            movies.get(i).display();
        }
    }

    @Override
    public String toString() {
        return genre;
    }
}
