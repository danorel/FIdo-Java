package dev.fido;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static final int port = 4004;
    public static LinkedList<Node> client_list = new LinkedList();

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(port);
            System.out.println("Opened the server connection");
            while(true){
                Socket client_socket = socket.accept();
                client_list.add(new Node(client_socket));
                try{
                    System.out.println("Closing the client connection");
                    client_socket.close();
                    System.out.println("Closing the server socket connection");
                    socket.close();
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
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
*/