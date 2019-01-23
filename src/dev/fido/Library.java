package dev.fido;

import java.io.*;

public class Library {
    // ASCII table as helper class
    private ASCII ascii;

    // Directory src and object
    private File directory;
    private String directory_src;

    // Input/output files names and objects
    private File input_file, output_file;
    private String input_filename, output_filename;
    private BufferedWriter writer;
    private BufferedReader reader;

    // Remember the encode step
    private int step;

    // Constructor, which defines the ASCII table
    public Library(){
        ascii = new ASCII();
    }

    public void encode_file(int step){
        this.step = step;
        try {
            String line;
            if(!directory_src.equals("")){
                reader = new BufferedReader(new FileReader(directory_src + "/" + input_filename));
                writer = new BufferedWriter(new FileWriter(directory_src + "/" + output_filename));
            } else {
                reader = new BufferedReader(new FileReader(input_filename));
                writer = new BufferedWriter(new FileWriter(output_filename));
            }
            while((line = reader.readLine()) != null){
                line = move_line(line, step);
                writer.write(line + "\n");
            }
            writer.close();
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String move_line(String line, int step){
        char[] line_characters = line.toCharArray();
        int index = 0;
        for(char ch : line_characters){
            if((int)ch >= ascii.get_MIN_value() && (int)ch <= ascii.get_MAX_value()){
                line_characters[index++] = move_symbol(ch, step);
            } else {
                line_characters[index++] = ch;
            }
        }
        line = "";
        for(char ch : line_characters){
            line += ch;
        }
        return line;
    }

    private char move_symbol(char symbol, int step){
        if(step > 0){
            return ((int)symbol >= ascii.get_MAX_value() - step) ? (char)((int)symbol - ((ascii.get_MAX_value() - ascii.get_MIN_value()) - step)) : (char)((int)symbol + step);
        } else {
            return ((int)symbol <= ascii.get_MIN_value() - step) ? (char)((int)symbol + ((ascii.get_MAX_value() - ascii.get_MIN_value()) + step)) : (char)((int)symbol + step);
        }
    }

    public void decode_file(){
        try {
            if(!directory_src.equals("")){
                reader = new BufferedReader(new FileReader(directory_src + "/" + output_filename));
            } else {
                reader = new BufferedReader(new FileReader(output_filename));
            }
            String text = "", line;
            while((line = reader.readLine()) != null){
                text += line.toString();
            }
            if(!directory_src.equals("")){
                writer = new BufferedWriter(new FileWriter(directory_src + "/" + output_filename));
            } else {
                writer = new BufferedWriter(new FileWriter(output_filename));
            }
            text = move_line(text, -step);
            writer.write(text);
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write_to_input_file(String data){
        try {
            if(!directory_src.equals("")){
                writer = new BufferedWriter(new FileWriter(directory_src + "/" + input_filename));
            } else {
                writer = new BufferedWriter(new FileWriter(input_filename));
            }
            writer.write(data);
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void create_directory(String directory_src){
        this.directory_src = directory_src;
        directory = new File(this.directory_src);
        directory.mkdir();
    }

    public void create_file(String filename, boolean state){
        if(state){
            input_filename = filename;
            if(!directory_src.equals("")){
                input_file = new File(directory_src + "/" + input_filename);
            } else {
                input_file = new File(input_filename);
            }
            try {
                input_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            output_filename = filename;
            if(!directory_src.equals("")){
                output_file = new File(directory_src + "/" + output_filename);
            } else {
                output_file = new File(output_filename);
            }
            try {
                output_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
