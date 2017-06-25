package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Order {
    public javax.swing.JPanel JPanel;
    private JTextPane textPane1;
    private JButton orderNowButton;
    private JTextArea textArea1;
    private String responseId;
    private String serverAddress;

    public Order(String data, String responseId, String serverAddress){
        textPane1.setText(data);
        this.responseId=responseId;
        this.serverAddress=serverAddress;
        orderNowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                callBillingInfoForm();
            }
        });

    }
    private void callBillingInfoForm() {
        JFrame jFrame=new JFrame("ServiceSpecification");
        jFrame.setContentPane(new BillingInfo(responseId,serverAddress).JPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
