package com.bridgelabz.csvandgson;

import com.opencsv.bean.CsvBindByName;

/**
 * @desc : CSV User Class
 */
public class CSVUser {
    @CsvBindByName
    private String name;
    @CsvBindByName(column = "email", required = true)
    private String email;
    @CsvBindByName(column = "phone")
    private String phoneNo;
    @CsvBindByName
    private String country;

    /**
     * @desc : Constructor to create CSVUser object
     * @param : name
     * @param : email
     * @param  : phoneNo
     * @param : country
     */
    public CSVUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }
    /**
     * @desc : Method to get the name of CSV user
     * @return : name
     */
    public String getName() {
        return name;
    }

    /**
     * @desc : Method to get the email of CSV user
     * @return : email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @desc : Method to get the phone no of CSV user
     * @return : phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @desc : Method to get the country of the CSV user
     * @return : country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @desc : Method to return formatted string of CSV User object
     * @return : formatted string object
     */
    @Override
    public String toString() {
        return String.format("CSVUser{ name = %s , email = %s , phoneNo = %s , country = %s }", name, email, phoneNo, country);
    }
}
