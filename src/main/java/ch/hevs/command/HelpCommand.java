package ch.hevs.command;

import java.io.PrintWriter;

public class HelpCommand implements Command {
    private PrintWriter printWriter;

    public HelpCommand(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
    public void execute() {
        String format = "%-50s : %s";

        printWriter.println("--- CLI Syntax ---------------------------------------  --- Description ---");

        printWriter.println(String.format(format, "LIST ALL_MOVIES", "to list all movies"));
        printWriter.println(String.format(format, "LIST GENRE [Genre]", "to list all movies from a genre"));
        printWriter.println(String.format(format, "LIST GENRE", "to list all genres available"));
        printWriter.println(String.format(format, "RECOMMEND GENRE [Genre]", "to recommend movies from genre and its subgenres"));
        printWriter.println(String.format(format, "RECOMMEND TOP", "to recommend top-rated movies"));
        printWriter.println(String.format(format, "RATE [Movie] [Grade]", "to rate a movie (Grade must be between 0 and 100)"));
        printWriter.println(String.format(format, "ADD_MOVIE [Genre] [Title] [Director] [Year]", "to add a movie (Select the genres from those available)"));
        printWriter.println(String.format(format, "QUIT", "to end the session"));

        printWriter.println("");
        printWriter.println("--- Note ---");
        printWriter.println("1) The parameters are indicated in brackets [] - for example : RECOMMEND GENRE Action");
        printWriter.println("2) If parameters require spaces, use '_' - for example : ADD_MOVIE Fantastic The_Fellowship_of_the_Ring Peter_Jackson 2001");

        printWriter.println("END");
    }
}
