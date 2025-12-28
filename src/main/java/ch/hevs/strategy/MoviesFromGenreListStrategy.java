package ch.hevs.strategy;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MoviesFromGenreListStrategy implements ListStrategy {
    private PrintWriter printWriter;
    private String genre;

    public MoviesFromGenreListStrategy(String genre) {
        this.genre = genre;
    }

    @Override
    public List<String> list(GenreTree genreTree) {
        List<String> result = new ArrayList<>();
        List<Movie> movies = genreTree.getMoviesFromGenre(genre);
        if (movies != null) {
            for (Movie movie : movies) {
                result.add(movie.toString());
            }
        } else {
            return new ArrayList<String>();
        }
        return result;
    }
}
