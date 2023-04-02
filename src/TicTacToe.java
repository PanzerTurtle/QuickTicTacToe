/*
 * จัดทำขึ้นโดย นายอธิบดีทวีทรัพย์
 */

import javax.swing.JButton;

public class TicTacToe {
    Player currentPlayer;
    boolean hasWinner;
    boolean isDraw;
    JButton[][] board;

    public TicTacToe() {
    }

    public void switchPlayer() { // self explanatory
        if (currentPlayer == Player.O) {
            currentPlayer = Player.X;
        } else {
            currentPlayer = Player.O;
        }
    }

    public void hasWinner(JButton[][] board) { // win condition check
        String winner = currentPlayer.toString();
        // rows check
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equalsIgnoreCase(winner) && board[i][1].getText().equals(winner)
                    && board[i][2].getText().equals(winner)) {
                hasWinner = true;
            }
        }

        // columns check
        for (int j = 0; j < 3; j++) {
            if (board[0][j].getText().equals(winner) && board[1][j].getText().equals(winner)
                    && board[2][j].getText().equals(winner)) {
                hasWinner = true;
            }
        }

        // diagonal check
        if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText())
                && !board[0][0].getText().equals("")) {
            hasWinner = true;
        }
        if (board[2][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[0][2].getText())
                && !board[2][0].getText().equals("")) {
            hasWinner = true;
        }
    }

    public void gameDraw(JButton[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().equals("")) {
                    isDraw = false;
                    return;
                } else {
                    isDraw = true; // no empty cell, it's a draw
                }
            }
        }
    }

    public void resetBoard(JButton[][] board) { // seld explanatory
        this.currentPlayer = Player.X;
        this.hasWinner = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
                board[i][j].setEnabled(true);
            }
        }
    }
}