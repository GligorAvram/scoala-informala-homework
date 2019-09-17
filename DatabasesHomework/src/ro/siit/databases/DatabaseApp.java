package ro.siit.databases;

import java.sql.*;

/**
 * Databases & JDBC homework written so that it complies with the following requirements:
 *
 * The school database consists of these five tables:
 * classes
 * Fields: classid, courseid, days, starttime, endtime, bldg, roomnum
 *
 * courses
 * Fields: courseid, area, title, descrip, prereqs
 * The courseid field of the courses table is related to the courseid field of the classes table.
 *
 * crosslistings
 * Fields: courseid, dept, coursenum
 * The courseid field of the crosslistings table is related to the courseid field of the courses table.
 *
 * coursesprofs
 * Fields: courseid, profid
 * The courseid field of the coursesprofs table is related to the courseid field of the courses table.
 *
 * profs
 * Fields: profid, profname
 * The profid field of the profs table is related to the profid field of the coursesprofs table.
 *
 * implement in java method to:
 * - Display data for all classes.
 * - Display data for a course with specified id.
 * - Display data for all classes whose title (when converted to all lowercase letters) begins with "intro".
 * - Display data for all classes whose dept (when converted to all lowercase letters) is "cos" and whose coursenum begins with "3".
 * - Display data for all classes whose profname (when converted to all lowercase letters) begins with "cos".
 *
 * You will have to supply the queries used to create the database, tables and data, as well as the Java code that executes the queries described above.
 */
public class DatabaseApp {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        displayClasses();
        System.out.println("============================================================================================");
        getCourseId("3");
        System.out.println("============================================================================================");
        getCourseTitleIntro();
        System.out.println("============================================================================================");
        classesFromDptCn();
        System.out.println("============================================================================================");
        findProff();
    }

    /**
     * Connection with the parameters used to obtain a connection to the database.
     */
    public static Connection getConnection(String dbType, String host, String port, String dbName, String username, String password) {
        Connection conn = null;
        DriverManager.setLoginTimeout(60);
        try {
            StringBuilder connectionUrl = new StringBuilder();
            connectionUrl.append("jdbc:");
            connectionUrl.append(dbType);
            connectionUrl.append("://");
            connectionUrl.append(host);
            connectionUrl.append(":");
            connectionUrl.append(port);
            connectionUrl.append("/");
            connectionUrl.append(dbName);
            connectionUrl.append("?user=");
            connectionUrl.append(username);
            connectionUrl.append("&password=");
            connectionUrl.append(password);

            return DriverManager.getConnection(connectionUrl.toString());
        } catch (SQLException e) {
            System.out.println("cannot connect to database");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method that displays all the fields of the classes table
     */
    public static void displayClasses() {
        Connection c = getConnection("mysql", "localhost", "3306", "school", "root", "Malfurion1");
        if (c == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%3s|%3s|%15s|%7s|%7s|%3s|%5s|\n";

        try {
            st = c.createStatement();
            rs = st.executeQuery("select * from classes");

            while (rs.next()) {
                String classid = rs.getString("classid");
                String courseid = rs.getString("courseid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomnum = rs.getString("roomnum");

                System.out.printf(format, classid, courseid, days, starttime, endtime, bldg, roomnum);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that displays the data for the given id from the courses table
     */
    public static void getCourseId(String id) {
        Connection c = getConnection("mysql", "localhost", "3306", "school", "root", "Malfurion1");
        if (c == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%3s|%10s|%15s|%15s|%15s|\n";

        try {
            st = c.createStatement();
            rs = st.executeQuery("select * from courses where courseid = " + id);

            if (rs.next()) {
                String classid = rs.getString("courseid");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                String prereqs = rs.getString("prereqs");

                System.out.printf(format, classid, area, title, descrip, prereqs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that displays all the fields of the courses table whose title begins with intro
     */
    public static void getCourseTitleIntro() {
        Connection c = getConnection("mysql", "localhost", "3306", "school", "root", "Malfurion1");
        if (c == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%3s|%10s|%15s|%5s|%15s|\n";

        try {
            st = c.createStatement();
            rs = st.executeQuery("select * from courses where title like 'intro%'");

            while (rs.next()) {
                String classid = rs.getString("courseid");
                String area = rs.getString("area");
                String title = rs.getString("title");
                String descrip = rs.getString("descrip");
                String prereqs = rs.getString("prereqs");

                System.out.printf(format, classid, area, title, descrip, prereqs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that displays all the clases whose dept begins with cos and their course id is 3
     */
    public static void classesFromDptCn() {
        Connection c = getConnection("mysql", "localhost", "3306", "school", "root", "Malfurion1");
        if (c == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%3s|%5s|%5s|%3s|%15s|%7s|%7s|%3s|%5s|\n";

        try {
            st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM crosslistings LEFT JOIN classes ON crosslistings.courseid = classes.courseid where LOWER(crosslistings.dept) like'cos%' and crosslistings.courseid = 3");

            while (rs.next()) {
                String courseid = rs.getString("courseid");
                String dept = rs.getString("dept");
                String coursenum = rs.getString("coursenum");
                String classid = rs.getString("classid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomnum = rs.getString("roomnum");

                System.out.printf(format, courseid, dept, coursenum, classid, days, starttime, endtime, bldg, roomnum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method which displays all classes whose professors name begins with cos
     */
    public static void findProff() {
        Connection c = getConnection("mysql", "localhost", "3306", "school", "root", "Malfurion1");
        if (c == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%3s|%3s|%25s|%3s|%15s|%7s|%7s|%3s|%5s|\n";

        try {
            st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM coursesprofs INNER JOIN profs ON coursesprofs.profid = profs.profid INNER JOIN classes ON coursesprofs.courseid = classes.courseid where LOWER(profs.profname) like'cos%'");

            while (rs.next()) {
                String courseid = rs.getString("courseid");
                String profid = rs.getString("profid");
                String profname = rs.getString("profname");
                String classid = rs.getString("classid");
                String days = rs.getString("days");
                String starttime = rs.getString("starttime");
                String endtime = rs.getString("endtime");
                String bldg = rs.getString("bldg");
                String roomnum = rs.getString("roomnum");

                System.out.printf(format, courseid, profid, profname, classid, days, starttime, endtime, bldg, roomnum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
