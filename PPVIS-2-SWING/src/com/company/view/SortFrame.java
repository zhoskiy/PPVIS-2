package com.company.view;

import com.company.controler.DataController;

import javax.swing.*;
import java.awt.*;

public class SortFrame extends JFrame {

   private DataController dataController;

   private JRadioButton fullNameRadioButton = new JRadioButton("Full name");
   private JRadioButton accountNumberRadioButton = new JRadioButton("Account number");
   private JRadioButton addressRegistrationRadioButton = new JRadioButton("Registration address");

   private boolean fullName = false;
   private boolean accountNumber = false;
   private boolean addressRegistration = false;

   public JButton sort = new JButton("Sort");

    public  SortFrame(DataController dc){
        super("Sort");
        this.dataController = dc;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        fullNameRadioButton.setSelected(true);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fullNameRadioButton);
        buttonGroup.add(accountNumberRadioButton);
        buttonGroup.add(addressRegistrationRadioButton);

        sort.setMaximumSize(new Dimension(75, 25));


        add(fullNameRadioButton);
        add(accountNumberRadioButton);
        add(addressRegistrationRadioButton);
        add(sort);

        setSize(250, 150);
    }
    public void sortCustomers(){
        if (fullNameRadioButton.isSelected()) fullName = true;
        if (accountNumberRadioButton.isSelected())  accountNumber = true;
        if (addressRegistrationRadioButton.isSelected()) addressRegistration = true;

        dataController.sortCustomers(fullName, accountNumber, addressRegistration);

    }
}
