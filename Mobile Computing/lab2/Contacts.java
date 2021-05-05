package com.phonebook;

public class Contacts {

    int id;
    String firstname;
    String lastname;
    String phonenumber;
    String contacttype;

    public Contacts() {
    }

    public Contacts(int id, String firstname, String lastname, String phonenumber, String contacttype) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.contacttype = contacttype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype;
    }
}
