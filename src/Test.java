import java.awt.*;


import javax.swing.*;
public class Test {

    public static void main(String[] args) {

        JFrame window = new JFrame("Крестики нолики");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);

        TicTakToe game = new TicTakToe();
        window.add(game);
        window.setVisible(true);

    }

}
