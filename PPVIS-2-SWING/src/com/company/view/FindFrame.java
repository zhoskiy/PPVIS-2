package com.company.view;

import com.company.controler.DataController;

import javax.swing.*;
import java.util.List;

public class FindFrame extends JFrame {
    private DataController DC;

    private JButton findButton;

    private TablePanel tablePanel;

    private ChoosePanel choosePanel = new ChoosePanel();
    public FindFrame(DataController DC){
        super("Find Customers");
        this.DC = DC;
        setSize(800, 320);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        findButton = new JButton("Find");
        findButton.addActionListener(actionEvent -> {
            List<String> list = choosePanel.getCustomerFromFields();
            DataController temp = new DataController();
            temp.setCustomers(this.DC.FindCustomers(list.get(0), list.get(1), list.get(2), list.get(3)));
            tablePanel.setCustomers(temp);
            tablePanel.showTable(temp);
        });

        tablePanel = new TablePanel(DC);
        JPanel pan = new JPanel();
        pan.add(findButton);

        add(choosePanel);
        add(pan);
        add(tablePanel);
    }

}
