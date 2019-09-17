import java.sql.*;

public class toDelete {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        getConnection("mysql", "localhost", "3306", "books", "root", "Malfurion1");

        //displayAuthors();
        //System.out.println("============================");
//        insertAuthors();
//        displayAuthors();

        getOrders();
    }

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

    public static void displayAuthors() {
        Connection conn = getConnection("mysql", "localhost", "3306", "books", "root", "Malfurion1");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%30s|%30s|%12s|\n";


        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from authors");

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthdate = rs.getDate("birthdate");

                System.out.format(format, name, email, birthdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertAuthors() {

        Connection conn = getConnection("mysql", "localhost", "3306", "books", "root", "Malfurion1");
        if (conn == null) return;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("insert into authors (name, email, birthdate) values (?, ?, ?)");
            ps.setString(1, "Malfurion1");
            ps.setString(2, "Malfurion1@gmail.com");
            ps.setDate(3, Date.valueOf("1976-11-05"));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getOrders() {
        Connection conn = getConnection("mysql", "localhost", "3306", "shop", "root", "Malfurion1");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;
        String format = "|%30s|%30s|%12s|\n";


        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from customers left join orders on customers.id = orders.customer_id order by order.amount desc");

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthdate = rs.getDate("birthdate");

                System.out.format(format, name, email, birthdate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
