package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChoosePanel extends JPanel {

    private JPanel textPanel;

    private JTextField surname;
    private JTextField name;

    private JTextField accountNumber;
    private JTextField phoneNumber;

    ChoosePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createLabels();
        createText();
    }

    private void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel surname = new JLabel("surname");
        JLabel name = new JLabel("name");
        JLabel accountNumber = new JLabel("account number");
        JLabel phoneNumber = new JLabel("phone number");


        labelPanel.add(surname);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(accountNumber);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(phoneNumber);
        labelPanel.add(Box.createHorizontalGlue());

        add(labelPanel);
    }

    private void createText(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 200;
        final int HEIGHT = 20;

        surname = new JTextField();
        surname.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        surname.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        name.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        accountNumber = new JTextField();
        accountNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        accountNumber.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        phoneNumber = new JTextField();
        phoneNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        phoneNumber.setMinimumSize(new Dimension(WIDTH, HEIGHT));


        textPanel.add(surname);
        textPanel.add(name);
        textPanel.add(accountNumber);
        textPanel.add(phoneNumber);

        add(textPanel);
    }

    public List<String> getCustomerFromFields(){
        List<String> result = new ArrayList<>();
        result.add(getSurname());
        result.add(getFieldName());
        result.add(getAccountNumber());
        result.add(getPhoneNumber());
        return result;
    }

    public String getFieldName() {
        return name.getText();
    }
    public String getSurname() {
        return surname.getText();
    }
    public String getAccountNumber() {
        return accountNumber.getText();
    }
    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

}
