package com.company.data;

public class MyData {
    private String surname;
    private String name;
    private String patronymic;
    private String registrationAddress;
    private String landLineNumber;
    private String accountNumber;
    private String mobileNumber;




    public MyData(){}

    public void setFullName(String fullName) {
        String[] subString;
        String delimeter = " ";
        subString = fullName.split(delimeter);
        this.surname = new String(subString[0]);
        this.name = new String(subString[1]);
        this.patronymic = new String(subString[2]);
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public MyData(String fullName, String accountNumber, String registrationAddress, String mobileNumber, String landLineNumber){
        this.setFullName(fullName);
        this.accountNumber = accountNumber;
        this.registrationAddress = registrationAddress;
        this.mobileNumber = mobileNumber;
        this.landLineNumber = landLineNumber;
    }


}
