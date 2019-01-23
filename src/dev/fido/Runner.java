package dev.fido;

import java.util.Scanner;

public class Runner {
    private Scanner scanner;
    private Library library;


    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
    }

    public void start(){
        scanner = new Scanner(System.in);

        // Working with encoding/decoding
        library = new Library();
        String directory_name, input_filename, output_filename, text;
        // Defining the directory name, creating the directory
        System.out.print("Enter the directory name: ");
        directory_name = scanner.nextLine();
        library.create_directory(directory_name);
        // Defining the input/output files names
        System.out.print("Enter the input file name: ");
        input_filename = scanner.nextLine();
        library.create_file(input_filename, true);
        System.out.print("Enter the output file name: ");
        output_filename = scanner.nextLine();
        library.create_file(output_filename, false);
        System.out.print("Enter the text you want to encode: ");
        text = scanner.nextLine();
        library.write_to_input_file(text);
        library.encode_file(3);
        library.decode_file();
    }
}
