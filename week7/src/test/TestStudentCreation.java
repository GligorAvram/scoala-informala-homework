package test;

import main.StudentDB;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for the StudentDatabase program.
 */
public class TestStudentCreation {

    /**
     * Tests if students can be added to the list and if the info can be successfully retrieved
     */
    @Test
    public void params() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "bbb", "ccccccccccccc", "f", "1987");
        assertEquals(s.getStudentList().get(0).getFirstName(), "aaa");
        assertEquals(s.getStudentList().get(0).getLastName(), "bbb");
        assertEquals(s.getStudentList().get(0).getCNP(), "ccccccccccccc");
        assertEquals(s.getStudentList().get(0).getGender(), "F");
        assertEquals(s.getStudentList().get(0).getDoB(), 1987);
    }

    /**
     * Tests if the first name parameter was null or not.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullFirstName() {
        StudentDB s = new StudentDB();
        s.addStudent(null, null, "ccccccccccccc", "f", "1987");
    }

    /**
     * Tests if the last name parameter specified
     */
    @Test(expected = IllegalArgumentException.class)
    public void emptyLastName() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "", "ccccccccccccc", "f", "1987");
    }

    /**
     * Tests if the gender is correct
     */
    @Test(expected = IllegalArgumentException.class)
    public void wrongGender() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "sadsad", "ccccccccccccc", "terafluid", "1987");
    }

    /**
     * Tests if the ID is too short
     */
    @Test(expected = IllegalArgumentException.class)
    public void idTooShort() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "sadsad", "ccccccccccccc", "terafluid", "1987");
    }

    /**
     * Tests if the date of birth goes past 1900
     */
    @Test(expected = IllegalArgumentException.class)
    public void olderThanLife() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "sadsad", "ccccccccccccc", "terafluid", "1100");
    }
}

