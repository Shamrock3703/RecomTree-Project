package ch.hevs.strategy;

import ch.hevs.content.GenreNode;
import ch.hevs.content.GenreTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenreListStrategy implements ListStrategy {
    @Override
    public List<String> list(GenreTree genreTree) {
        List<String> result = new ArrayList<>();
        List<GenreNode> genres = genreTree.getAllGenres();
        if (genres.size() <= 1) {
            result.add("No genres");
        } else {
            for (GenreNode genre : genres) {
                result.add("| " + genre.toString() + " |");
            }
            result.remove(0);
        }
        Collections.sort(result, (a, b) -> a.compareTo(b));
        return result;
    }
}
