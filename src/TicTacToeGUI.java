/*
 * จัดทำขึ้นโดย นายอธิบดีทวีทรัพย์
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends TicTacToe {
    Container pane;
    JFrame frame;

    public TicTacToeGUI() {

    }

    public void mainFrame() { // JFrame window
        frame = new JFrame();
        pane = frame.getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        initializeBoard();
        frame.setJMenuBar(initializeMenuBar());
        frame.setTitle("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JMenuBar initializeMenuBar() { //option bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Option");

        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(e -> {
            System.exit(0);
        });

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(e -> {
            this.resetBoard(board);
        });

        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);

        return menuBar;
    }

    private void initializeBoard() { // starting board
        currentPlayer = Player.X;
        board = new JButton[3][3];
        hasWinner = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = new JButton();
                tile.setFocusable(false);
                tile.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("") && hasWinner == false) {
                            tile.setText(currentPlayer.toString());
                            hasWinner(board);
                            gameDraw(board);
                            tile.setEnabled(false);
                            if (hasWinner == true) {
                                JOptionPane.showMessageDialog(frame, currentPlayer.toString() + " wins");
                                resetBoard(board);
                            } else if (isDraw == true) {
                                JOptionPane.showMessageDialog(frame, "Draw");
                                resetBoard(board);
                            } else {
                                switchPlayer();
                            }
                        }
                    }
                });

                board[i][j] = tile;
                pane.add(tile);
            }
        }
    }

}
