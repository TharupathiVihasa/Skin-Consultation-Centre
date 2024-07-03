package admin;

import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String surname;
    private String dob;
    private String mobileNumber;

    public Person(String firstName, String surname, String mobileNumber, String dob) {
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return
                "  firstName= " + firstName + '\n' +
                "  surname=" + surname + '\n' +
                "  dob=" + dob +'\n' +
                "  mobileNumber='" + mobileNumber + '\n'
                ;
    }
}
