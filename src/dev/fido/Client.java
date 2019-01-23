package dev.fido;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket client_socket;
    private static BufferedReader reader;
    private static BufferedWriter output;
    private static BufferedReader input;
    private static Chat chat;

    public static void main(String[] args) {
        chat = new Chat();
        chat.visualize();
        String word = "";
        try {
            client_socket = new Socket("localhost", 4004);
            reader = new BufferedReader(new InputStreamReader(System.in));
            input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(client_socket.getOutputStream()));
            while(!word.equals("Exit")){
                System.out.print("Enter something here...");
                word = reader.readLine();
                output.write(word + "\n");
                output.flush();
                String server_message = input.readLine();
                System.out.println(server_message);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                System.out.println("Client stopped working!");
                reader.close();
                input.close();
                output.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }
}
