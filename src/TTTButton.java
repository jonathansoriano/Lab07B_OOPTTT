import javax.swing.*;
import java.awt.*;

public class TTTButton extends JButton{
    private int row;
    private  int col;


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



}
