package com.company.view;

import com.company.data.MyData;
import com.company.controler.DataController;

import javax.swing.*;
import java.awt.*;

public class AddFrame extends JFrame {

    JPanel labelPanel;
    JPanel textPanel;

    DataController DC;

    JTextField fullName;
    JTextField accountNumber;
    JTextField registrationAddress;
    JTextField landLineNumber;
    JTextField mobileNumber;


    public JButton add;

    public AddFrame(DataController DC){
        super("Add Window");
        this.DC = DC;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add = new JButton("Add");
        createFields();
        createLabels();

        add(labelPanel);
        add(textPanel);
        add(add);

        setSize(800, 150);
        setResizable(false);

    }

    public void createLabels(){
        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel fullName = new JLabel("Full name");
        JLabel accountNumber = new JLabel("Account number");
        JLabel registrationAddress = new JLabel("registration address");
        JLabel mobileNumber = new JLabel("Mobile number");
        JLabel landLineNumber = new JLabel("Land line number");



        labelPanel.add(fullName);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(accountNumber);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(registrationAddress);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(mobileNumber);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(landLineNumber);
        labelPanel.add(Box.createHorizontalGlue());

    }

    public void createFields(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 300;
        final int HEIGHT = 20;



        fullName = new JTextField();
        fullName.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        accountNumber = new JTextField();
        accountNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        registrationAddress = new JTextField();
        registrationAddress.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        mobileNumber = new JTextField();
        mobileNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        landLineNumber = new JTextField();
        landLineNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));




        textPanel.add(fullName);
        textPanel.add(accountNumber);
        textPanel.add(registrationAddress);
        textPanel.add(mobileNumber);
        textPanel.add(landLineNumber);

    }

    public void addCustomer(){
        String fullName = this.fullName.getText();
        String accountNumber = this.accountNumber.getText();
        String registrationAddress = this.registrationAddress.getText();
        String mobileNumber = this.mobileNumber.getText();
        String landLineNumber = this.landLineNumber.getText();
        this.fullName.setText(null);
        this.accountNumber.setText(null);
        this.registrationAddress.setText(null);
        this.mobileNumber.setText(null);
        this.landLineNumber.setText(null);


        DC.Add(new MyData(fullName, accountNumber, registrationAddress, mobileNumber, landLineNumber));

    }

}
