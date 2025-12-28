package ch.hevs.command;

import ch.hevs.content.GenreTree;
import ch.hevs.content.Movie;

import java.io.PrintWriter;

public class AddMovieCommand implements Command {
    private Movie movie;
    private GenreTree tree;
    private PrintWriter printWriter;
    private String title;
    private String director;
    private String year;
    private String genre;

    public AddMovieCommand(GenreTree tree, PrintWriter printWriter, String genre, String title, String director, String year) {
        this.tree = tree;
        this.printWriter = printWriter;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public void execute() {
        movie = new Movie(this.title, this.director, this.year);
        try {
            tree.addMovie(this.genre, movie);
            printWriter.println("Movie added successfully: " + title);
        } catch (IllegalStateException e) {
            printWriter.println("Error: " +  e.getMessage());
        }
        printWriter.println("END");
    }
}
