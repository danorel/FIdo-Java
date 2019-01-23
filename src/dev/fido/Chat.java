package dev.fido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class Chat extends JFrame {
    // Frame parameters
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    // Panels
    private JPanel main;

    // Text container
    private JTextArea container;
    private static final int CONTAINER_WIDTH = 30;
    private static final int CONTAINER_HEIGHT = 20;
    private JScrollBar container_bar;

    // Field for the text input
    private JTextArea input_field;
    private static final int FIELD_WIDTH = 30;
    private static final int FIELD_HEIGHT = 4;

    // Field for the name container
    private JTextField name_field;
    private static final int NAME_FIELD = 30;

    public Chat(){
        this.setTitle("Dan's chat");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main = new JPanel();
        // Defining the input_field with width of FIELD_WIDTH
        input_field = new JTextArea(FIELD_HEIGHT, FIELD_WIDTH);
        input_field.addKeyListener(new Input_Key_Container());
        // Defining the text container with width of CONTAINER_WIDTH and
        // height of CONTAINER_HEIGHT
        container = new JTextArea(CONTAINER_HEIGHT, CONTAINER_WIDTH);
        container.setEditable(false);
    }

    public void visualize(){
        input_field.setText("Write a message...");
        main.add(container, BorderLayout.CENTER);
        main.add(input_field, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.setVisible(true);
    }

    class Input_Key_Container implements KeyListener {

        @Override
        public void keyTyped(KeyEvent event) {

        }

        @Override
        public void keyPressed(KeyEvent event) {
            int key_code = event.getKeyCode();
            Date current_time = new Date();
            if(key_code == KeyEvent.VK_ENTER){
                container.append("(" + current_time.getHours()  + ":" + (current_time.getMinutes() < 10 ? "0" + current_time.getMinutes() : current_time.getMinutes()) + ":" + (current_time.getSeconds() < 10 ? "0" + current_time.getSeconds() : current_time.getSeconds())+ "): " + input_field.getText() + "\n");
            }
        }

        @Override
        public void keyReleased(KeyEvent event) {
            int key_code = event.getKeyCode();
            if(key_code == KeyEvent.VK_ENTER){
                input_field.setText("");
                input_field.requestFocus();
            }
        }
    }

    // Implementing the editing possibility, reply possibility
    class Container_Mouse_Container implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
