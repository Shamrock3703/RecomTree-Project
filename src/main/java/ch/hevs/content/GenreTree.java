package ch.hevs.content;

import java.util.ArrayList;
import java.util.List;

public class GenreTree {
    private GenreNode root;

    public GenreTree() {
        this.root = new GenreNode("Root");
    }

    public GenreNode search(String searchedGenre) {
        return searchRecursive(root, searchedGenre);
    }

    private GenreNode searchRecursive(GenreNode currentNode, String searchedGenre) {
        if (currentNode == null) {
            return null;
        }

        if (currentNode.getGenre().equals(searchedGenre)) {
            return currentNode;
        }

        GenreNode result = searchRecursive(currentNode.getLeft(), searchedGenre);

        if (result != null) {
            return result;
        }
        return searchRecursive(currentNode.getRight(), searchedGenre);
    }

    private void collectMoviesRecursive(GenreNode node, List<Movie> movies) {
        if (node == null) {
            return;
        }
        movies.addAll(node.getMovies());
        collectMoviesRecursive(node.getLeft(), movies);
        collectMoviesRecursive(node.getRight(), movies);
    }

    private void collectGenresRecursive(GenreNode node, List<GenreNode> genreNodes) {
        if (node == null) {
            return;
        }
        genreNodes.add(node);
        collectGenresRecursive(node.getLeft(), genreNodes);
        collectGenresRecursive(node.getRight(), genreNodes);
    }

    public void addGenre(String parentName, String newGenreName) {
        if (search(newGenreName) != null) {
            throw new IllegalStateException("Genre already exists");
        }
        GenreNode parent = search(parentName);
        if (parent != null) {
            parent.addSubGenre(new GenreNode(newGenreName));
        } else {
            throw new IllegalStateException("Parent does not exist");
        }
    }

    public void addMovie(String genre, Movie movie) {
        List<Movie> movies = getAllMovies();
        for (Movie existingMovie : movies) {
            if (existingMovie.getTitle().equalsIgnoreCase(movie.getTitle())) {
                throw new IllegalStateException("Movie '" + movie.getTitle() + "' already exists");
            }
        }
        GenreNode node = search(genre);
        if (node != null) {
            node.addMovie(movie);
        } else {
            throw new IllegalStateException(genre + " does not exist.");
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        collectMoviesRecursive(root, movies);
        return movies;
    }

    public List<Movie> getMoviesFromGenre(String genre) {
        List<Movie> movies = new ArrayList<>();
        GenreNode genreNode = search(genre);
        if (genreNode != null) {
            movies.addAll(genreNode.getMovies());
        } else {
            throw new IllegalStateException("Genre " + genre + " does not exist.");
        }
        return movies;
    }

    public List<Movie> getMoviesAndChildrenFromGenre(String genre) {
        List<Movie> movies = new ArrayList<>();
        GenreNode parentNode = search(genre);
        if (parentNode != null) {
            movies.addAll(parentNode.getMovies());
            if (parentNode.getLeft() != null) {
                movies.addAll(parentNode.getLeft().getMovies());
            }
            if (parentNode.getRight() != null) {
                movies.addAll(parentNode.getRight().getMovies());
            }
        } else {
            throw new IllegalStateException("Genre " + genre + " does not exist.");
        }
        return movies;
    }

    public List<GenreNode> getAllGenres() {
        List<GenreNode> genres = new ArrayList<>();
        collectGenresRecursive(root, genres);
        return genres;
    }

    public List<String> getAllGenresString() {
        List<GenreNode> genres = new ArrayList<>();
        List<String> genreStr = new ArrayList<>();
        collectGenresRecursive(root, genres);
        for (GenreNode genre : genres) {
            genreStr.add(genre.toString());
        }
        return genreStr;
    }
}