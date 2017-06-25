package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddressValidate extends JFrame {
    public javax.swing.JPanel JPanel;
    private JTextField latitude;
    private JTextField longitude;
    private JButton submit;
    private String serverAddress;

    public AddressValidate(String serverAddress){
        super("Address Validation");
        this.serverAddress=serverAddress;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(latitude.getText().length()==0|| longitude.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields");
                }
                else{
                    try {
                        if(checkAddressValidation(latitude.getText(),longitude.getText())){
                            JOptionPane.showMessageDialog(null,"Address is valid.\n status code:201.");
                            callServiceForm();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Not valid Address.\nStatus Code:404.");
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Not valid Address.\nStatus Code:404.");
                        e.printStackTrace();
                    }
                }

            }
        });

    }
    private void callServiceForm(){
        JFrame jFrame=new JFrame("ServiceSpecification");
        jFrame.setContentPane(new ServiceSpecification(serverAddress,latitude.getText(),longitude.getText()).JPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    private boolean checkAddressValidation(String latitude,String longitude) throws IOException {
        System.out.println(serverAddress);
        String url = serverAddress+"/api/address/validate";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        String postJsonData="{\n" +
                "\t\"address\":{\n" +
                "\t\t\"GeoCode\":{\n" +
                "\t\t\t\"latitude\": \""+ latitude+ "\",\n" +
                "\t\t\t\"longitude\": \""+longitude+"\"\n" +
                "\t\t}\t\n" +
                "\t}\n" +
                "}" ;
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println(responseCode);
        return (responseCode==201);
    }

}
