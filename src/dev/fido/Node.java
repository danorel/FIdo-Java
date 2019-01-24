package dev.fido;

import java.io.*;
import java.net.Socket;

public class Node extends Thread {
    private Socket client_socket;
    private BufferedWriter output;
    private BufferedReader input;

    public Node(Socket client_socket){
        this.client_socket = client_socket;
        try {
            input = new BufferedReader(new InputStreamReader(this.client_socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(this.client_socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            while(true){
                word = input.readLine();
                if(word.equals("Exit")){
                    break;
                }
                for(Node client : Server.client_list){
                    client.send(word);
                }
            }
            output.close();
            input.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void send(String message){
        try{
            output.write(message + "\n");
            output.flush();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
