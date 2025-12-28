package ch.hevs.command;

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
        movie = new Movie(this.title, this.director, this.year);
    }

    @Override
    public void execute() {
        try {
            tree.addMovie(this.genre, movie);
            printWriter.println("Movie added successfully");
        } catch (IllegalStateException e) {
            printWriter.println(e.getMessage());
        }
        printWriter.println("END");
    }
}
