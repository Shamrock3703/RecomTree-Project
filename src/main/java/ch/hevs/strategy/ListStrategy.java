package ch.hevs.strategy;

import ch.hevs.content.GenreTree;

import java.io.PrintWriter;
import java.util.List;

public interface ListStrategy {
     List<String> list(GenreTree genreTree);
}
