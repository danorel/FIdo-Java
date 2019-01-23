//package dev.fido;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.net.*;
//
//public class Chat {
////    JTextArea incomingField;
////    JTextField outgoingField;
////    PrintWriter writer;
////    BufferedReader reader;
////    Socket socket;
//
//
//    public static void main(String[] args) {
//        new Chat().run();
//    }
//
//    public void run() {
//        Server server = new Server();
//        Client client = new Client("127.0.0.1", 4224);
//        client.setInterface();
//    }
//
////    private void setUpNetworking() {
////        try {
////            socket = new Socket("127.0.0.1", 5000);
////            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
////            reader = new BufferedReader(streamReader);
////            writer = new PrintWriter(socket.getOutputStream());
////            System.out.println("Networking established.");
////        } catch (IOException ex) {
////            ex.printStackTrace();
////        }
////    }
//
//}
