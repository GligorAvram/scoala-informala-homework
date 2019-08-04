package test;

import main.Student;
import main.StudentDB;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestStudentCreation {

    @Test
    public void testFirstName() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "bbb", "ccccccccccccc", "f", "1987");
        assertEquals(s.getStudentList().get(0).getFirstName(), "aaa");
        assertEquals(s.getStudentList().get(0).getLastName(), "bbb");
        assertEquals(s.getStudentList().get(0).getCNP(), "ccccccccccccc");
        assertEquals(s.getStudentList().get(0).getGender(), "F");
        assertEquals(s.getStudentList().get(0).getDoB(), 1987);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullFirstName() {
        StudentDB s = new StudentDB();
        s.addStudent(null, null, "ccccccccccccc", "f", "1987");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyLastName() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "", "ccccccccccccc", "f", "1987");
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongGender() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "sadsad", "ccccccccccccc", "terafluid", "1987");
    }

    @Test(expected = IllegalArgumentException.class)
    public void idTooShort() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "sadsad", "ccccccccccccc", "terafluid", "1987");
    }

    @Test(expected = IllegalArgumentException.class)
    public void olderThanLife() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "sadsad", "ccccccccccccc", "terafluid", "1100");
    }
}

