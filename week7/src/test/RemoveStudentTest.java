package test;

import main.StudentDB;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RemoveStudentTest {

    @Test
    public void happyRemoveTest() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "bbb", "ccccccccccccc", "f", "1987");
        s.addStudent("ddd", "eee", "fffffffffffff", "m", "1947");
        s.removeStudent("ccccccccccccc");
        assertEquals(s.getStudentList().size(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cnpTooShort() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "bbb", "ccccccccccccc", "f", "1987");
        s.addStudent("ddd", "eee", "fffffffffffff", "m", "1947");
        s.removeStudent("ccccccc");
        assertEquals(s.getStudentList().size(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCNP() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "bbb", "ccccccccccccc", "f", "1987");
        s.addStudent("ddd", "eee", "fffffffffffff", "m", "1947");
        s.removeStudent(null);
        assertEquals(s.getStudentList().size(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cnpNotFound() {
        StudentDB s = new StudentDB();
        s.addStudent("aaa", "bbb", "ccccccccccccc", "f", "1987");
        s.addStudent("ddd", "eee", "fffffffffffff", "m", "1947");
        s.removeStudent("ddddddddddddd");
        assertEquals(s.getStudentList().size(), 1);
    }
}
