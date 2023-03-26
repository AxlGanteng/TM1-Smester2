package gui;

import model.ResponModel;
import network.network;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class gui {
    private JPanel panel1;
    private JTextField textstatus;
    private JTextField textmassage;
    private JTextField textcomments;
    private JButton closeButton;
    private JButton applyButton;
    private JButton minimize;

    public JPanel getPanel1() {
    return panel1;
}

    public JButton getMinimize(){
        return minimize;
    }

    public gui() {
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textmassage.setText("");
                textstatus.setText("");
                textcomments.setText("");
                try{
                    network connection = new network();
                    URL myAddress = connection.buildURL("http://harber.mimoapps.xyz/api/getaccess.php");
                    String response = connection.getResponseFromHttpUrl(myAddress);

                    JSONArray responseJSON = new JSONArray(response);
                    ArrayList<ResponModel> responseModel = new ArrayList<>();
                    for (int i = 0; i < responseJSON.length(); i++) {
                        ResponModel resModel = new ResponModel();
                        JSONObject myJSONObject = responseJSON.getJSONObject(i);
                        resModel.setMassege(myJSONObject.getString("message"));
                        resModel.setStatus(myJSONObject.getString("status"));
                        resModel.setComent(myJSONObject.getString("comment"));
                        responseModel.add(resModel);
                    }
                    for(ResponModel respond : responseModel){
                        textmassage.setText(respond.getMassege());
                        textstatus.setText(respond.getStatus());
                        textcomments.setText(respond.getComent());
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//    }
}

