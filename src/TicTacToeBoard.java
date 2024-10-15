import javax.swing.*;
import java.awt.*;

public class TicTacToeBoard extends JFrame {
    private JButton [][] board;

    private JPanel mainPanel;
    private JPanel boardPanel;
    private JPanel titlePanel;

    private JLabel titleLabel;

    private int boardHeight = 650;
    private int boardWidth = 600;

    PlayerX playerX = new PlayerX();
    PlayerO playerO = new PlayerO();
    private String currentPlayer = playerX.getPlayerMove();

    private boolean isWin = false;

    public TicTacToeBoard(){
        mainPanel = new JPanel(new BorderLayout());

        //Creating the title Panel
        generateTitlePanel();
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        //Creating the Board Panel
        generateBoardPanel();
        mainPanel.add(boardPanel,BorderLayout.CENTER);

        this.add(mainPanel);
        this.setTitle("Tic Tac Toe Game");
        this.setSize(boardWidth, boardHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void generateTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setSize(600, 50);
        titleLabel = new JLabel("Tic-Tac-Toe");
        titleLabel.setFont(new Font("Ariel", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setOpaque(true);

        titlePanel.add(titleLabel);
    }

    public void generateBoardPanel(){
        boardPanel = new JPanel(new GridLayout(3, 3));
        boardPanel.setSize(600, 600);
        board = new JButton[3][3];

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                board[r][c] = new TTTButton(r, c);
                boardPanel.add(board[r][c]);

            }
        }

    }
}
