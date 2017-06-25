package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Order {
    public javax.swing.JPanel JPanel;
    private JTextPane textPane1;
    private JButton orderNowButton;
    private JLabel priceLabel;
    private JTextArea textArea1;
    private String responseId;
    private String serverAddress;

    public Order(String data, String responseId, String serverAddress,String price){
        textPane1.setText(data);
        this.responseId=responseId;
        this.serverAddress=serverAddress;
        this.priceLabel.setText("The price of the requested service is:"+price);
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
