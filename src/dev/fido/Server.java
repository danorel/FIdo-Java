package dev.fido;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket client_socket;
    private static ServerSocket server;
    private static BufferedWriter output;
    private static BufferedReader input;

    private static final int port = 4004;

    public static void main(String[] args) {
        String word = "";
        try {
            // Giving the server the port
            server = new ServerSocket(port);
            System.out.println("Server is awaiting for clients!");
            // Waiting for the client connection
            client_socket = server.accept();
            input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(client_socket.getOutputStream()));
            while(!word.equals("Exit")){
                word = input.readLine();
                System.out.println("You've entered: " + word);
                output.write("Hi, this is server, you've written: " + word + "\n");
                output.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                System.out.println("Closing the streams...");
                client_socket.close();
                output.close();
                input.close();
                System.out.println("Server is closed!");
                server.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
