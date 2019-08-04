package main;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {

    private List<Student> studentList = new ArrayList<>();
    private static final int BEGINNINGYEAR = 1900;
    private static final int CURRENTYEAR = 2019;


    public void addStudent(String firstName, String lastName, String CNP, String gender, String DoB) {
        int dob = -1;

        //checks if the inputed name is correct
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Check the first name");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Check the last name");
        }

        //checks if the inputed gender is correct
        if (gender == null) {
            throw new IllegalArgumentException("Check the gender");
        }
        gender = gender.toUpperCase();
        if (!gender.equals("M") && !gender.equals("F")) {
            throw new IllegalArgumentException("Check the gender");
        }

        if (CNP == null || CNP.length() != 13) {
            throw new IllegalArgumentException("The ID is not properly formatted");
        }

        //checks if the age is proper
        try {
            int checkedDob = Integer.parseInt(DoB);
            if (checkedDob > CURRENTYEAR || checkedDob < BEGINNINGYEAR) {
                throw new IllegalArgumentException("You might not be of legal age");
            }
            dob = checkedDob;
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Please check the age");
        }


        Student s = new Student();
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setCnp(CNP);
        s.setGender(gender);
        if (dob != -1) {
            s.setDoB(dob);
            studentList.add(s);
            dob = -1;
        }

    }

    public void removeStudent(String cnp) {
        boolean removed = false;
        if (cnp == null || cnp.length() != 13) {
            throw new IllegalArgumentException("The ID is not properly formatted");
        }

        for (int i = 0; i < studentList.size(); i++) {
            if ((studentList.get(i).getCNP()).equals(cnp)) {
                studentList.remove(i);
                removed = true;
            }
        }

        if (removed) {
            removed = false;
        } else {
            throw new IllegalArgumentException("the student does not exist");
        }

    }

    public void printStudents() {
        for (Student s : studentList
        ) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }

    public void printStudents(List<Student> list) {
        for (Student s : list
        ) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }

    public void printOffAge(String age) {
        List<Student> toPrint = new ArrayList<>();
        int studentAge;
        try {
            studentAge = Integer.parseInt(age);
            for (int i = 0; i < studentList.size(); i++) {
                if (CURRENTYEAR - studentAge == studentList.get(i).getDoB()) {
                    toPrint.add(studentList.get(i));
                }
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("This age has not arrived");
        }

        if (toPrint.size() > 0) {
            printStudents(toPrint);
        }
    }

    public void listStudentsAge() {
        int n = studentList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (studentList.get(j).getDoB() > studentList.get(j + 1).getDoB()) {
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }

        printStudents();
    }

    public void listStudentsName() {
        int n = studentList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (studentList.get(j).getFirstName().compareToIgnoreCase(studentList.get(j + 1).getFirstName()) > 0) {
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
        printStudents();
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
