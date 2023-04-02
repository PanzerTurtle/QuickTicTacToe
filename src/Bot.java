/*
 * จัดทำขึ้นโดย นายอธิบดีทวีทรัพย์
 */

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

public class Bot {
    ArrayList<JButton> legalMoves = new ArrayList<>();
    TicTacToeGUI GUI;

    public Bot(TicTacToeGUI GUI) { //active as long as MainFrame is active
        this.GUI = GUI;
        while(GUI.frame != null){
            makeMove();
        }
    }

    void getLegalMove() { // all unclicked bottuns are legal moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (GUI.board[i][j].getText().equalsIgnoreCase("")) {
                    legalMoves.add(GUI.board[i][j]);
                }
            }
        }
    }

    void makeMove() { // click random legal button
        getLegalMove();
        int move;
        try{
            move = new Random().nextInt(legalMoves.size());
            if (GUI.currentPlayer.toString().equalsIgnoreCase("o")) {
                legalMoves.get(move).doClick();
            }
        }catch(IllegalArgumentException e){
            legalMoves.clear();
        }
        legalMoves.clear();
    }
}
