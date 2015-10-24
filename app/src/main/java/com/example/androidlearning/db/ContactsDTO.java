package com.example.androidlearning.db;

/**
 * Created by fcwl on 7/6/2015.
 */
public class ContactsDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String zip;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NEW_LINE);
        result.append(" fname:   " + firstName + NEW_LINE);
        result.append(" name:   " + lastName + NEW_LINE);
        result.append(" email : " + email + NEW_LINE);
        result.append(" street :   " + street + NEW_LINE);
        result.append(" zip : " + zip + NEW_LINE);
        result.append(" id : "  + id + NEW_LINE);

        result.append("}");
        return result.toString();
    }

}
