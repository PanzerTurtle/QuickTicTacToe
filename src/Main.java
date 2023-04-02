/*
 * จัดทำขึ้นโดย นายอธิบดีทวีทรัพย์
 */

public class Main {
    public static void main(String[] args) {
        TicTacToeGUI ttt = new TicTacToeGUI();
        ttt.mainFrame();
        new Bot(ttt);
    }
}
