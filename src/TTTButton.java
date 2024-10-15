import javax.swing.*;
import java.awt.*;


public class TTTButton extends JButton{
    private int row;
    private  int col;
    PlayerX playerX = new PlayerX();
    PlayerO playerO = new PlayerO();
    String currentPlayer;


    public TTTButton(int row, int col){
        super();
        this.row = row;
        this.col = col;
        this.setFont(new Font("Arial", Font.BOLD, 120));
        this.setFocusable(false);
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    //Do the logic of the button that checks for a button who's txt is empty
    //if is, set the text to the current player. Else, do a message box saying it's an invalid move.

}
