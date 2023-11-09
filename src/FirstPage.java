import java.awt.Container;
import java.awt.FlowLayout;
import java.io.Serial;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FirstPage extends JFrame{
    @Serial
    private static final long serialVersionUID = 1L;
    public static String userIx, userNol;

    JTextField userX, userO;

    public FirstPage() {

        super("Для начала представтесь");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));

//              Создаем меню бар
        JMenuBar menuBar = new JMenuBar();
        JMenuItem exit = new JMenuItem(new ExitAction());
        exit.setIcon(new ImageIcon("resourсes/exit.png"));
        menuBar.add(exit);
        container.add(menuBar);

        userX = new JTextField(20);
        userO = new JTextField(20);

        userX.setToolTipText("Имя игрока крестик");
        userO.setToolTipText("Имя игрока нолик");

        JButton button = new JButton("OK");
        button.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setBounds(400, 100, 400, 400);
            TicTakToe game = new TicTakToe();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(game);
            frame.setVisible(true);
            userIx = userX.getText();
            userNol = userO.getText();
            System.out.println(userX.getText());
            System.out.println(userO.getText());

        });

        container.add(new JLabel("                                                           "));
        container.add(new JLabel("Имя игрока X  "));
        container.add(userX);
        container.add(new JLabel("Имя игрока 0  "));
        container.add(userO);
        container.add(new JLabel("                                               "));
        container.add(button);
        setBounds(400, 100, 400, 200);
        setVisible(true);
    }
}
