package ch.hevs.server;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket socket;
    private GenreTree tree;

    public ClientHandler(Socket socket, GenreTree tree) {
        this.socket = socket;
        this.tree = tree;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            printWriter.println("Welcome on the Movie Recommendation Server");
            printWriter.println("1) RECOMMEND GENRE [Genre]");
            printWriter.println("2) RECOMMEND TOP");
            printWriter.println("3) LIST ALL_MOVIES");
            printWriter.println("4) LIST GENRE [Genre]");
            printWriter.println("5) LIST GENRE");
            printWriter.println("6) RATE [Movie] [Grade]");
            printWriter.println("7) ADD_MOVIE [Genre] [Title] [Director] [Year]");
            printWriter.println("8) QUIT");
            printWriter.println("9) HELP");
            printWriter.println("END");

            String request;
            while ((request = reader.readLine()) != null) {
                String[] parts = request.split(" ");

                AddMovieCommand addMovieCommand;
                RecommendCommand recommendCommand;
                ListCommand listCommand;
                RateCommand rateCommand;
                QuitCommand quitCommand;
                HelpCommand helpCommand;

                switch (parts[0]) {
                    case "ADD_MOVIE":
                        addMovieCommand = null;
                        if (parts.length == 5) {
                            addMovieCommand = new AddMovieCommand(tree, printWriter, parts[1], parts[2].replace("_", " "), parts[3].replace("_", " "), parts[4]);
                        } else {
                            printWriter.println("Syntax could be : ADD_MOVIE [Genre] [Title] [Director] [Year]");
                            printWriter.println("END");
                        }
                        if (addMovieCommand != null) {
                            addMovieCommand.execute();
                        }
                        break;
                    case "RECOMMEND":
                        RecommendationStrategy recomStrategy = null;
                        if (parts.length == 3 && parts[1].equals("GENRE")) {
                            recomStrategy = new GenreRecommendationStrategy(parts[2]);
                        } else if (parts.length == 2 && parts[1].equals("TOP")) {
                            recomStrategy = new TopRatedRecommendationStrategy();
                        } else {
                            printWriter.println("Syntax could be : RECOMMEND GENRE [Genre] or RECOMMEND TOP");
                            printWriter.println("END");
                        }
                        if (recomStrategy != null) {
                            recommendCommand = new RecommendCommand(tree, printWriter, recomStrategy);
                            recommendCommand.execute();
                        }
                        break;
                    case "LIST":
                        ListStrategy listStrategy = null;
                        if (parts.length == 2 && parts[1].equals("ALL_MOVIES")) {
                            listStrategy = new AllMoviesListStrategy();
                        } else if (parts.length == 3 && parts[1].equals("GENRE")) {
                            listStrategy = new MoviesFromGenreListStrategy(parts[2]);
                        } else if (parts.length == 2 && parts[1].equals("GENRE")) {
                            listStrategy = new GenreListStrategy();
                        } else {
                            printWriter.println("Syntax could be : LIST ALL_MOVIES, LIST GENRE [Genre] or LIST GENRE");
                            printWriter.println("END");
                        }
                        if (listStrategy != null) {
                            listCommand = new ListCommand(tree, printWriter, listStrategy);
                            listCommand.execute();
                        }
                        break;
                    case "RATE":
                        Movie movie = null;
                        List<Movie> movies = tree.getAllMovies();
                        for (int i = 0; i < movies.size(); i++) {
                            if (movies.get(i).getTitle().equals(parts[1].replace("_", " "))) {
                                movie = movies.get(i);
                            }
                        }
                        if (movie != null) {
                            String rating = parts[2];
                            int ratingInInt = Integer.parseInt(rating);
                            rateCommand = new RateCommand(printWriter, movie, ratingInInt);
                            rateCommand.execute();
                        } else {
                            printWriter.println("Movie not found");
                            printWriter.println("END");
                        }
                        break;
                    case "QUIT":
                        quitCommand = new QuitCommand(printWriter, socket);
                        quitCommand.execute();
                        break;
                    case "HELP":
                        helpCommand = new HelpCommand(printWriter);
                        helpCommand.execute();
                        break;
                    default:
                        printWriter.println("Command unknown");
                        printWriter.println("END");
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}
