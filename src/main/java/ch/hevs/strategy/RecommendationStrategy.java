package ch.hevs.strategy;

import ch.hevs.content.GenreTree;
import ch.hevs.content.Movie;

import java.util.List;

public interface RecommendationStrategy {
    List<Movie> recommend(GenreTree genreTree);
}
