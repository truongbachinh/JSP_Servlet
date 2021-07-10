package main.java.model;

import java.io.Serializable;

public class UserInfor implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String head;
    private String notifi;
    private String kind_email;

    public UserInfor()
    {
        firstName = "";
        lastName = "";
        email = "";
        head = "";
        notifi = "";
        kind_email = "";
    }
    public UserInfor(String firstName, String lastName, String email, String head, String notifi, String kind_email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.head = head;
        this.notifi = notifi;
        this.kind_email = kind_email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNotifi() {
        return notifi;
    }

    public void setNotifi(String notifi) {
        this.notifi = notifi;
    }

    public String getKind_email() {
        return kind_email;
    }

    public void setKind_email(String kind_email) {
        this.kind_email = kind_email;
    }
}
