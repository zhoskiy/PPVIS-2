package com.company.parsers;

import com.company.data.MyData;
import com.company.parsers.EValidParams;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class Sax {



    private String fullName;
    private String registrationAddress;
    private String mobileNumber;
    private String landLineNumber;
    private String accountNumber;


    private String endEl;

    private static List<MyData> customers = new ArrayList<>();

    public void parse(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bFullName = false;
                boolean bRegistrationAddress = false;
                boolean bMobileNumber = false;
                boolean bLandLineNumber = false;
                boolean bAccountNumber = false;


                public void startElement(String uri, String localName, String queryName,
                                         Attributes attributes) throws SAXException {
                    if (queryName.equalsIgnoreCase(EValidParams.FullName.toString())) {
                        bFullName = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.accountNumber.toString())) {
                        bAccountNumber = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.registrationAddress.toString())) {
                        bRegistrationAddress = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.mobileNumber.toString())) {
                        bMobileNumber = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.landLineNumber.toString())) {
                        bLandLineNumber = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    endEl = qName;


                }

                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (bFullName) {
                        System.out.println("full name: " + new String(ch, start, length));
                        setFullName(new String(ch, start, length));
                        bFullName = false;
                    } else if (bAccountNumber) {
                        System.out.println("account : " + new String(ch, start, length));
                        setAccountNumber(new String(ch, start, length));
                        bAccountNumber = false;
                    } else if (bRegistrationAddress) {
                        System.out.println("registration address : " + new String(ch, start, length));
                        setRegistrationAddress(new String(ch, start, length));
                        bRegistrationAddress = false;
                    } else if (bMobileNumber) {
                        System.out.println("mobile number : " + new String(ch, start, length));
                        setMobileNumber(new String(ch, start, length));
                        bMobileNumber = false;
                    } else if (bLandLineNumber) {
                        System.out.println("land line number : " + new String(ch, start, length));
                        setLandLineNumber(new String(ch, start, length));
                        bLandLineNumber = false;
                        MyData book = new MyData();
                        book.setFullName(getFullName());
                        book.setAccountNumber(getAccountNumber());
                        book.setRegistrationAddress(getRegistrationAddress());
                        book.setMobileNumber(getMobileNumber());
                        book.setLandLineNumber(getLandLineNumber());
                        customers.add(book);
                    }

                }

            };

            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static List<MyData> getCustomers() {
        return customers;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandLineNumber() {
        return landLineNumber;
    }

    public void setLandLineNumber(String landLineNumber) {
        this.landLineNumber = landLineNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
