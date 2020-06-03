package com.company.view;

import com.company.data.MyData;
import com.company.controler.DataController;
import com.sun.source.util.SourcePositions;

import javax.swing.*;

public class TablePanel extends JPanel {
    DataController DC;

    JTable table;
    JPanel controlPane;
    JLabel count;
    JLabel page;

    int left;
    int right;
    int pageCounter;

    public TablePanel(DataController DC){
        this.DC = DC;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        table = new JTable(10,5);

        makeControlButtons();
        createLabels();
        add(table);
        add(controlPane);
    }

    public void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel fullName = new JLabel("Full name");
        JLabel accountNumber = new JLabel("Account number");
        JLabel registrationAddress = new JLabel("registration address");
        JLabel mobileNumber = new JLabel("mobile number");
        JLabel landLineNumber = new JLabel("land line number");


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

        add(labelPanel);
    }

    void makeControlButtons(){
        left = 1;
        right = 10;
        pageCounter = 1;

        controlPane = new JPanel();
        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.LINE_AXIS));
        count = new JLabel("Customers " + left + " - " + right);
        page = new JLabel("Page: " + pageCounter);

        JButton nextPage = new JButton("Next");
        nextPage.addActionListener(actionEvent -> {
            if(DC.isExists(right+1)) {
                left += 10;
                right += 10;
                pageCounter++;
                count.setText("Customers " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        JButton prevPage = new JButton("Previous");
        prevPage.addActionListener(actionEvent -> {
            if(pageCounter > 1) {
                left -= 10;
                right -= 10;
                pageCounter--;
                count.setText("Customers " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        controlPane.add(count);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(page);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(prevPage);
        controlPane.add(nextPage);
    }

    private void addCustomer(int row, MyData customer){
        table.setValueAt(customer.getFullName(), row, 0);
        table.setValueAt(customer.getAccountNumber(), row, 1);
        table.setValueAt(customer.getRegistrationAddress(), row, 2);
        table.setValueAt(customer.getMobileNumber(), row, 3);
        table.setValueAt(customer.getLandLineNumber(), row, 4);
    }

    private void addEmpty(int row){
        table.setValueAt(" ", row, 0);
        table.setValueAt(" ", row, 1);
        table.setValueAt(" ", row, 2);
        table.setValueAt(" ", row, 3);
        table.setValueAt(" ", row, 4);
    }

    public void setCustomers(DataController data){
        DC = data;
    }
    
    public  void showTable(DataController DC){
        int index = 0;
        for(int i = left-1; i < right; i++){
            if(DC.isExists(i)) {
                addCustomer(index, DC.atIndex(i));
            }else{
                addEmpty(index);
            }
            index++;
        }
    }
}
