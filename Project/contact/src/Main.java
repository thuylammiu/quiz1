import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.google.gson.Gson;
import model.email;
import model.phone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<contact> contacts = new ArrayList<>();
        // Create contact for David Sanger
        contact david = new contact("David", "Sanger", "Argos LLC", "Sales Manager");
        david.addPhoneNumber("240-133-0011", "Home");
        david.addPhoneNumber("240-112-0123", "Mobile");
        david.addEmailAddress("dsanger@argos.com", "Work");
        david.addEmailAddress("dave.sang@gmail.com", "Home");
        contacts.add(david);
        // Create contact for Carlos Jimenez
        contact carlos = new contact("Carlos", "Jimenez", "Gafar", "");
        carlos.addPhoneNumber("412-116-9988", "Mobile");
        contacts.add(carlos);

        // Create contact for Ali
        contact ali = new contact("Ali", "", "BMI Services", "HR Manager");
        ali.addEmailAddress("ali@bmi.com", "Work");
        contacts.add(ali);

        Collections.sort(contacts, Comparator.comparing(c -> c.getLastName()));

        Gson gson = new Gson();
        for (contact contact : contacts) {
            JsonObject contactJson = new JsonObject();
            contactJson.addProperty("first_name", contact.getFirstName());
            contactJson.addProperty("last_name", contact.getLastName());
            contactJson.addProperty("company", contact.getCompany());
            contactJson.addProperty("job_title", contact.getJobTitle());

            JsonArray phoneNumbersJson = new JsonArray();
            for (phone phoneNumber : contact.getPhones()) {
                JsonObject phoneNumberJson = new JsonObject();
                // phoneNumberJson.addProperty("number", phoneNumber.number);
                //  phoneNumberJson.addProperty("label", phoneNumber.label);
                phoneNumbersJson.add(phoneNumberJson);
            }
            contactJson.add("phone_numbers", phoneNumbersJson);

            JsonArray emailAddressesJson = new JsonArray();
            for (email emailAddress : contact.getEmails()) {
                JsonObject emailAddressJson = new JsonObject();
                emailAddressJson.addProperty("address", emailAddress.getEmail());
                emailAddressJson.addProperty("label", emailAddress.getLabel());
                emailAddressesJson.add(emailAddressJson);
            }
            contactJson.add("email_addresses", emailAddressesJson);

            System.out.println(gson.toJson(contactJson));
        }
    }
}