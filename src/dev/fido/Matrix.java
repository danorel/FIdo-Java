package dev.fido;

public class Matrix {
    // The sizes of the Matrix
    private int Width, Height;
    // Check the defining of the sizes of the Matrix
    private boolean is_defined = false;
    // Amount of ways
    private int amount_of_ways;

    public void set_sizes(int Width, int Height){
        this.Width = Width - 1;
        this.Height = Height - 1;
        is_defined = true;
    }

    public int get_amount_of_ways(){
        if(is_defined){
            amount_of_ways = C();
            return amount_of_ways;
        } else {
            return -1;
        }
    }

    private int C(){
        return (factorial(Width + Height) / (factorial(Height) * factorial(Width)));
    }

    private int factorial(int Number){
        if(Number == 0 || Number == 1){
            return Number;
        } else {
            return Number * factorial(Number - 1);
        }
    }

}
