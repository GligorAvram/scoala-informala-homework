package main;

public class Student {

    private String cnp, firstName, lastName, gender;
    private int DoB;

    //getters
    public String getCNP() {
        return cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getDoB() {
        return DoB;
    }

    //setters
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDoB(int DoB) {
        this.DoB = DoB;
    }
}
