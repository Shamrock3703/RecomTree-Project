package ch.hevs.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5000);

        Scanner scan = new Scanner(System.in);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(outputStream, true);

        String welcomeMessage;
        while ((welcomeMessage = reader.readLine()) != null) {
            if (welcomeMessage.equals("END")) {
                break;
            }
            System.out.println(welcomeMessage);
        }

        while (true) {
            String request = scan.nextLine();
            printWriter.println(request);

            if (request.equals("QUIT")) {
                System.out.println("Closing client...");
                break;
            }
            String serverMessage;
            try {
                while ((serverMessage = reader.readLine()) != null) {
                    if (serverMessage.equals("END")) {
                        break;
                    }
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                System.out.println("Server connection closed");
                break;
            }
        }
        socket.close();
        scan.close();
    }
}
