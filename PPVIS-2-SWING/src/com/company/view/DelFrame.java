package com.company.view;

import com.company.controler.DataController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DelFrame extends JFrame {
    private DataController dataController;

    private ChoosePanel choosePanel = new ChoosePanel();

    private JButton delete;

    public DelFrame(DataController dataController){
        super("Delete frame");
        this.dataController = dataController;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        init();
        setSize(800, 120);
        setResizable(false);
    }

    private void init() {
        delete = new JButton("Delete");
        delete.setMaximumSize(new Dimension(100, 20));

        add(choosePanel);
        add(delete);
    }

    public int deleteCustomers(){
        List<String> list = choosePanel.getCustomerFromFields();
        return  this.dataController.DeleteCustomers(list.get(0), list.get(1), list.get(2), list.get(3));
    }

    public JButton getDelete() {
        return delete;
    }
}
