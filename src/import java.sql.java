import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LegacyUserManager {

    public void addUser(String name, int age) {
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "root");
            st = con.createStatement();

            if (name != null) {
                if (age > 0) {
                    String query = "INSERT INTO users VALUES ('" + name + "', " + age + ")";
                    st.execute(query);
                } else {
                    System.out.println("Invalid age");
                }
            } else {
                System.out.println("Name is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUsers() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
