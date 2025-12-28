package ch.hevs.command;

import ch.hevs.content.GenreTree;
import ch.hevs.strategy.ListStrategy;

import java.io.PrintWriter;
import java.util.List;

public class ListCommand implements Command {
    private GenreTree tree;
    private PrintWriter printWriter;
    private ListStrategy listStrategy;

    public ListCommand(GenreTree tree, PrintWriter printWriter, ListStrategy listStrategy) {
        this.tree = tree;
        this.printWriter = printWriter;
        this.listStrategy = listStrategy;
    }

    @Override
    public void execute() {
        List<String> strings = listStrategy.list(tree);

        if (strings.isEmpty()) {
            printWriter.println("Nothing found");
        } else {
            for (int i = 0; i < strings.size(); i++) {
                printWriter.println(strings.get(i));
            }
        }
        printWriter.println("END");
    }
}
