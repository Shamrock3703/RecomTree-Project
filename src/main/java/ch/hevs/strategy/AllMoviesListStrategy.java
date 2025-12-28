package ch.hevs.strategy;

import ch.hevs.content.GenreTree;
import ch.hevs.content.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllMoviesListStrategy implements ListStrategy {
    @Override
    public List<String> list(GenreTree genreTree) {
        List<String> result = new ArrayList<>();
        List<Movie> movies = genreTree.getAllMovies();

        for (Movie movie : movies) {
            result.add(movie.toString());
        }
        Collections.sort(result, (a, b) -> a.compareTo(b));
        return result;
    }
}
