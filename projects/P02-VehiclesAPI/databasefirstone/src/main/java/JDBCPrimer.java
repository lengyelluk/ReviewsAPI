import java.sql.*;

public class JDBCPrimer {

    public static void main(String[] args) {
        try{
            //url => database, ip address (port if not default), database name (username and password as query params
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/JDND")) {
                System.out.println("Connected to: " + connection.getMetaData().getDatabaseProductName());

                try(Statement statement = connection.createStatement()) {

                    try(ResultSet resultSet = statement.executeQuery("SELECT * FROM orders")) {

                        System.out.println("SQL query executed");

                        //loop through each row of the result
                        while (resultSet.next()) {
                            int order = resultSet.getInt("Order_id");
                            String customer_name = resultSet.getString(2);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
            System.out.println("SQLState " + ex.getSQLState());
            System.out.println("VendorError " + ex.getErrorCode());
        }
    }

}
