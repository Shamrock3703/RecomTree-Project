package ch.hevs.command;

import java.io.PrintWriter;
import java.util.List;

public class RecommendCommand implements Command {
    private GenreTree tree;
    private PrintWriter printWriter;
    private RecommendationStrategy recomStrategy;

    public RecommendCommand(GenreTree tree, PrintWriter printWriter, RecommendationStrategy recomStrategy) {
        this.tree = tree;
        this.printWriter = printWriter;
        this.recomStrategy = recomStrategy;
    }

    @Override
    public void execute() {
        List<Movie> movies  = recomStrategy.recommend(tree);

        if (movies.isEmpty()) {
            printWriter.println("No movies found");
        } else {
            for (int i = 0; i < movies.size(); i++) {
                printWriter.println(i + 1 + ") " + movies.get(i).toString());
            }
        }
        printWriter.println("END");
    }
}
