package com.company.controler;

import com.company.parsers.Dom;
import com.company.data.MyData;
import com.company.parsers.Sax;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private List<MyData> tableData;

    private boolean bName;
    private boolean bSurname;
    private boolean bAccountNumber;
    private boolean bPhoneNumber;

    public DataController(){
        tableData = new ArrayList<MyData>();
    }

    private List<MyData> FindTemplate(String surname, String name, String accountNumber, String phoneNumber) {
        List<MyData> temp = new ArrayList<>();
        for (MyData tableDatum : tableData) {
            boolean bIsFits = (tableDatum.getName().equals(name) || bName)
                    && (tableDatum.getSurname().equals(surname) || bSurname)
                    && (tableDatum.getAccountNumber().equals(accountNumber) || bAccountNumber)
                    && (tableDatum.getMobileNumber().equals(phoneNumber) ||
                    tableDatum.getLandLineNumber().equals(phoneNumber) || bPhoneNumber);
            if(bIsFits){
                temp.add(tableDatum);
            }
        }
        return temp;
    }

    public List<MyData> FindStudents(String surname, String name, String accountNumber, String phoneNumber){

        bSurname = (surname.equals(""));
        bName = (name.equals(""));
        bAccountNumber = (accountNumber.equals(""));
        bPhoneNumber = (phoneNumber.equals(""));

        return FindTemplate(surname, name, accountNumber, phoneNumber);
    }

    public int DeleteCustomers(String surname, String name, String accountNumber, String phoneNumber){
        bSurname = (surname.equals(""));
        bName = (name.equals(""));
        bAccountNumber = (accountNumber.equals(""));
        bPhoneNumber = (phoneNumber.equals(""));

        List<MyData> temp = FindTemplate(surname, name, accountNumber, phoneNumber);
        int amount = temp.size();
        tableData.removeAll(temp);
        return amount;
    }

    public void Add(MyData customer){
        tableData.add(customer);
    }

    public void Read(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(pathToFile);
        tableData = sax.getCustomers();
    }

    public void Write(String pathToFile){
        Dom dom = new Dom();
        dom.setStuds(tableData, pathToFile);
        dom.setBooks();
    }

    public MyData atIndex(int index){
        return tableData.get(index);
    }

    public boolean isExists(int index){
        return index < tableData.size();
    }

    public void setCustomers(List<MyData> data){
        tableData = data;
    }
}
