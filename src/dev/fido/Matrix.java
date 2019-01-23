package dev.fido;

public class Matrix {
    // The sizes of the Matrix
    private int Width, Height;
    // The Matrix itself
    private int[][] Matrix;
    // Check the defining of the sizes of the Matrix
    private boolean is_defined = false;

    // My current location
    private int location[][];
    private int current_X, current_Y;

    public Matrix(){
        location = new int[1][2];
        current_X = 0;
        current_Y = 0;
        location[current_X][0] = 0;
        location[current_Y][1] = 0;
    }

    public void set_sizes(int Width, int Height){
        this.Width = Width;
        this.Height = Height;
        Matrix = new int[this.Width][this.Height];
        fill_matrix();
        is_defined = true;
    }

    private void fill_matrix(){
        int pointer = 10;
        for(int x_axis = 0; x_axis < Width; x_axis++){
            for(int y_axis = 0; y_axis < Height; y_axis++){
                Matrix[x_axis][y_axis] = pointer++;
            }
        }
    }

    public int get_amount_of_ways(){
        if(is_defined){
            return 0;
        } else {
            return -1;
        }
    }

    public int[][] move_right(){
        return new int [++current_X][current_Y];
    }

    public int[][] move_down(){
        return new int [current_X][++current_Y];
    }

    public void show_matrix(){
        for(int x_axis = 0; x_axis < Width; x_axis++){
            for(int y_axis = 0; y_axis < Height; y_axis++){
                System.out.print(Matrix[x_axis][y_axis] + " ");
            }
            System.out.println();
        }
    }

}
