package ch.hevs.strategy;

import java.util.ArrayList;
import java.util.List;

public class AllMoviesListStrategy implements ListStrategy {
    @Override
    public List<String> list(GenreTree genreTree) {
        List<String> result = new ArrayList<>();
        List<Movie> movies = genreTree.getAllMovies();

        for (Movie movie : movies) {
            result.add(movie.toString());
        }
        return result;
    }
}
