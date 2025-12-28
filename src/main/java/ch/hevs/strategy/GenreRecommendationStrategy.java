package ch.hevs.strategy;

import ch.hevs.content.GenreTree;
import ch.hevs.content.Movie;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GenreRecommendationStrategy implements RecommendationStrategy {
    private String genre;
    private PrintWriter printWriter;

    public GenreRecommendationStrategy(String genre) {
        this.genre = genre;
    }

    @Override
    public List<Movie> recommend(GenreTree genreTree) {
        List<Movie> movies = null;
        List<String> genres = genreTree.getAllGenresString();
        if (genres.contains(genre)) {
            movies = genreTree.getMoviesAndChildrenFromGenre(genre);
        }
        if (movies != null) {
            return movies;
        } else {
            return new ArrayList<Movie>();
        }
    }
}
