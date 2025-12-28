package ch.hevs.command;

import java.io.PrintWriter;

public class HelpCommand implements Command {
    PrintWriter printWriter;

    public HelpCommand(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
    public void execute() {
        printWriter.println("--- CLI Syntax ---\t\t\t\t\t\t\t--- Description ---");
        printWriter.println("LIST ALL_MOVIES\t\t\t\t\t\t\t\t: to list all movies");
        printWriter.println("RECOMMEND GENRE [Genre]\t\t\t\t\t\t: to recommend movies from genre and its subgenres");
        printWriter.println("RECOMMEND TOP\t\t\t\t\t\t\t\t: to recommend top-rated movies");
        printWriter.println("LIST ALL_MOVIES\t\t\t\t\t\t\t\t: to list all movies");
        printWriter.println("LIST GENRE [Genre]\t\t\t\t\t\t\t: to list all movies from a genre");
        printWriter.println("LIST GENRE\t\t\t\t\t\t\t\t\t: to list all genres available");
        printWriter.println("RATE [Movie] [Grade]\t\t\t\t\t\t: to rate a movie (Grade must be between 0 and 100)");
        printWriter.println("ADD_MOVIE [Genre] [Title] [Director] [Year] : to add a movie (Select the genres from those available)");
        printWriter.println("QUIT\t\t\t\t\t\t\t\t\t\t: to end the session\n");
        printWriter.println("--- Note ---");
        printWriter.println("1) The parameters are indicated in brackets [] - for example : RECOMMEND GENRE Action");
        printWriter.println("2) If parameters require spaces, use '_' - for example : ADD_MOVIE Fantastic The_Fellowship_of_the_Ring Peter_Jackson 2001");
        printWriter.println("END");
    }
}
