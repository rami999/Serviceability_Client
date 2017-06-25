package GUI;

import javax.swing.*;

@SuppressWarnings("Duplicates")
public class mainContainer {
    private JFrame serverAddress;
    private JFrame addressValidate;

    public static void main(String[] args) {
        JFrame jFrame=new JFrame("ServiceSpecification");
        jFrame.setContentPane(new ServerAddress().JPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }
}
