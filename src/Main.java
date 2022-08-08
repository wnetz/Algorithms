import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        JFrame window = new JFrame("Algorithms");
        ImageIcon imageIcon = new ImageIcon("./src/logo.png");
        //GamePanel gamePanel = new GamePanel();

        //window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setIconImage(imageIcon.getImage());
        //window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);

        new InitialWindow();

        //gamePanel.start();
    }
}
