package main;

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
