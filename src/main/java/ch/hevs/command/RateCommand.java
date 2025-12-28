package ch.hevs.command;

import java.io.PrintWriter;

public class RateCommand implements Command{
    private PrintWriter printWriter;
    private Movie movie;
    private int rating;

    public RateCommand(PrintWriter printWriter, Movie movie, int rating) {
        this.printWriter = printWriter;
        this.movie = movie;
        this.rating = rating;
    }

    @Override
    public void execute() {
        if (rating < 0 || rating > 100) {
            printWriter.println("Grade must be between 0 and 100");
            printWriter.println("END");
        } else {
            movie.setRating(rating);
            printWriter.println(movie.getTitle() + " has been rated");
            printWriter.println("END");
        }
    }
}
