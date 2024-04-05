package model;

public class email {
    String address;
    String label;

    email(String address, String label) {
        this.address = address;
        this.label = label;
    }

    public String getEmail() {
        return address;
    }

    public String getLabel() {
        return label;
    }
}
