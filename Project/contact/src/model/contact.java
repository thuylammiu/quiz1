package model;

import java.util.ArrayList;
import java.util.List;
public class contact {
    String firstName;
    String lastName;
    String company;
    String jobTitle;
    List<phone> phoneNumbers;
    List<email> emailAddresses;

    public contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumbers = new ArrayList<>();
        this.emailAddresses = new ArrayList<>();
    }
    public void addPhoneNumber(String number, String label) {
        phoneNumbers.add(new phone(number, label));
    }
    public void addEmailAddress(String address, String label) {
        emailAddresses.add(new email(address, label));
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getCompany() {
        return company;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public List<phone> getPhones() {
        return phoneNumbers;
    }

    public List<email> getEmails() {
        return emailAddresses;
    }
}
