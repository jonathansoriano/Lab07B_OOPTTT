import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard extends JFrame implements ActionListener {
    private TTTButton[][] board;
    private boolean xTurn;
    private PlayerX playerX;
    private PlayerO playerO;
    private JPanel mainPanel;
    private JPanel boardPanel;
    private JPanel titlePanel;

    private JLabel titleLabel;

    private int boardHeight = 650;
    private int boardWidth = 600;



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

        playerX = new PlayerX();
        playerO = new PlayerO();
        xTurn = true;
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

    public void generateBoardPanel() {
        boardPanel = new JPanel(new GridLayout(3, 3));
        boardPanel.setSize(600, 600);
        board = new TTTButton[3][3];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = new TTTButton(r, c);
                board[r][c].addActionListener(this);
                boardPanel.add(board[r][c]);

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TTTButton button = (TTTButton) e.getSource();
        if (button.getText().equals("")){
            if (xTurn) {
                button.setText(String.valueOf(playerX.getPlayerMove()));
            } else {
                button.setText(String.valueOf(playerO.getPlayerMove()));
            }
            xTurn = !xTurn;
            checkForWin();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid move! Please Try again.");
            int result = JOptionPane.OK_OPTION;
        }
    }

    private void checkForWin() {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            String winner = xTurn ? "O" : "X";
            int result = JOptionPane.showConfirmDialog(null, "Player " + winner + " won. Do you want to play again?");
            if (result == JOptionPane.YES_OPTION) {
                // Reset the game board
                resetGame();
            } else{
                System.exit(0);
            }
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            int result = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
            if (result == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        }
    }
    private boolean checkRows() {
        for (int r = 0; r < 3; r++) {
            if (checkLine(board[r][0], board[r][1], board[r][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int c = 0; c < 3; c++) {
            if (checkLine(board[0][c], board[1][c], board[2][c])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return checkLine(board[0][0], board[1][1], board[2][2]) ||
                checkLine(board[0][2], board[1][1], board[2][0]);
    }

    private boolean checkLine(TTTButton b1, TTTButton b2, TTTButton b3) {
        return !b1.getText().equals("") &&
                b1.getText().equals(b2.getText()) &&
                b2.getText().equals(b3.getText());
    }

    private boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setText("");
            }
        }
        xTurn = true;
    }
}
