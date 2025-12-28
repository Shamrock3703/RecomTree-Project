package ch.hevs.strategy;

import java.util.Collections;
import java.util.List;

public class TopRatedRecommendationStrategy implements RecommendationStrategy {
    @Override
    public List<Movie> recommend(GenreTree genreTree) {
        List<Movie> movies = genreTree.getAllMovies();
        Collections.sort(movies, (m1, m2) -> Integer.compare(m2.getRating(), m1.getRating()));
        return movies;
    }
}
