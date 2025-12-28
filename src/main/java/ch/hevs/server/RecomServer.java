package ch.hevs.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class RecomServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        GenreTree tree = new GenreTree();

        // Creation of the tree
        // Spectacular branch
        // root level
        tree.addGenre("Root", "Action");
        // 1st level
        tree.addGenre("Action", "Sci-Fi");
        tree.addGenre("Action", "Adventure");
        // 2nd level
        tree.addGenre("Sci-Fi", "Fantastic");
        tree.addGenre("Sci-Fi", "Horror");
        tree.addGenre("Adventure", "War");
        tree.addGenre("Adventure", "Western");

        // Emotional branch
        // root level
        tree.addGenre("Root", "Comedy");
        // 1st level
        tree.addGenre("Comedy", "Family");
        tree.addGenre("Comedy", "Drama");
        // 2nd level
        tree.addGenre("Family", "Animation");
        tree.addGenre("Family", "Documentary");
        tree.addGenre("Drama", "Romance");
        tree.addGenre("Drama", "History");

        System.out.println("Waiting for connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            ClientHandler clientHandler = new ClientHandler(socket, tree);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

