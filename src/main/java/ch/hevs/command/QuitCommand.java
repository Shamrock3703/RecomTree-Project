package ch.hevs.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class QuitCommand implements Command {
    private PrintWriter printWriter;
    private Socket socket;

    public QuitCommand(PrintWriter printWriter, Socket socket) {
        this.printWriter = printWriter;
        this.socket = socket;
    }

    @Override
    public void execute() {
        try {
            printWriter.println("Disconnected");
            socket.close();
        } catch (IOException e) {
            System.out.println("Error during connection closure : " + e.getMessage());
        }
    }
}
