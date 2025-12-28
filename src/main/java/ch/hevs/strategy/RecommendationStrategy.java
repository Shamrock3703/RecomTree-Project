package ch.hevs.strategy;

import java.util.List;

public interface RecommendationStrategy {
    List<Movie> recommend(GenreTree genreTree);
}
