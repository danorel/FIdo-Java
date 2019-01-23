package dev.fido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Note extends JFrame {
    // Parameters of the Note appearance
    private static final String title = "Note";
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    // Panels on the frame
    private JPanel main;
    private JPanel utilities;

    // Buttons on the frame
    private JButton create;
    private static final String CREATE_LABEL = "Create";
    private JButton edit;
    private static final String EDIT_LABEL = "Edit";
    private JButton save;
    private static final String SAVE_LABEL = "Save";

    // Text area as the text container of the Note
    private JTextArea container;
    private static final int CONTAINER_WIDTH = 35;
    private static final int CONTAINER_HEIGHT = 20;
    private JScrollBar container_bar;

    // Text field for input the file name
    private JTextField input_field;
    private static final int FIELD_WIDTH = 10;

    // File container of the text content
    private File file;
    private BufferedWriter writer;

    public Note(){
        this.setSize(WIDTH, HEIGHT);
        this.setName(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Defining the frame panels
        main = new JPanel();
        utilities = new JPanel();
        // Defining the frame buttons
        create = new JButton(CREATE_LABEL);
        edit = new JButton(EDIT_LABEL);
        save = new JButton(SAVE_LABEL);
        // Defining the frame text container
        container = new JTextArea(CONTAINER_HEIGHT, CONTAINER_WIDTH);
        // Defining the input field
        input_field = new JTextField(FIELD_WIDTH);
    }

    public void visualize(){
        utilities.add(create, BorderLayout.SOUTH);
        utilities.add(edit, BorderLayout.CENTER);
        main.add(container, BoxLayout.X_AXIS);
        main.add(input_field, BoxLayout.X_AXIS);
        save.addActionListener(new save_function());
        main.add(save, BoxLayout.X_AXIS);

        this.add(main, BorderLayout.CENTER);
        this.add(utilities, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public class edit_function implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class save_function implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filename = input_field.getText();
            file = new File(filename);
            try {
                file.createNewFile();
                writer = new BufferedWriter(new FileWriter(filename));
                writer.write(container.getText());
                writer.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            container.setText("");
            input_field.setText("");
        }
    }

}
