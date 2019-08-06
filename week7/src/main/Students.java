package main;

/**
 * Homework for week 7 with the following requirements:
 * ===============================================================================================================
 * Create a student repository which supports:
 * <p>
 * - add student
 * * exceptions when validating conditions mentioned bellow
 * - delete student (by ID)
 * * exceptions: ID is empty, student does not exist
 * - retrieve all students with Age X (for each student the age must be calculated, not stored in a field).
 * * exceptions: age is not a number, age is negative
 * - (optional) list students order by Last Name or Birth Date
 * * exceptions: any input is empty
 * These methods must validate inputs and throw exceptions if necessary.
 * <p>
 * For each Student the following information needs to be collected:
 * - First Name
 * - Last Name
 * - Date of Birth
 * - Gender
 * - ID (CNP)
 * <p>
 * The following validations are expected:
 * - date of birth between 1900 and current year - 18
 * - first name and last name should not be empty
 * - gender should be male or female (or M and F), upper/lower case should both be accepted
 * <p>
 * For all the validations, the corresponding exception(s) should be thrown when a Student is created
 * with data which breaks the validation constraint.
 * <p>
 * The testing application can demonstrate the implementation of the above requirements without
 * requiring a special menu for creating the students or for choosing the operation. Just create
 * several test methods which perform separately a given scenario.
 * <p>
 * Additionally, you should use Logger for tracing and error handling.
 * ===============================================================================================================
 * <p>
 * - A logger was not used in this implementation
 *
 * @author Gligor
 * @version 1.0.0
 */

public class Students {
    public static void main(String[] args) {
        StudentDB stdb = new StudentDB();

        stdb.addStudent("Mihai", "Banderas", "1234567890qwe", "m", "1999");
        stdb.addStudent("Vali", "Matala", "ksjjfhfhhhhha", "F", "1956");
        stdb.addStudent("gfdg", "yhrtj", "jhdgstayKAMST", "f", "1976");
        stdb.addStudent("werw", "ytrytr", "JGIFKR,TMCGDF", "f", "1976");
        stdb.addStudent("aascc", "kjkj", "PRHDTSKKHFNBD", "f", "1976");
        System.out.println("==========================================");
        System.out.println("Print Students");
        stdb.printStudents();
        System.out.println("==========================================");
        System.out.println("Print arranged by age");
        stdb.listStudentsAge();
        System.out.println("==========================================");
        System.out.println("print all of  the same age");
        stdb.printOffAge("43");
        System.out.println("==========================================");
        System.out.println("print alphabetically");
        stdb.listStudentsName();


    }
}
