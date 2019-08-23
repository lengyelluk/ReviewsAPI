import java.sql.PreparedStatement;

public class UpdateWithoutTransaction {


    //update without transaction => only insert statement is executed
    /*String insertTableSQL = "INSERT INTO DBUSER"
            + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
            + "(?,?,?,?)";

    String updateTableSQL = "UPDATE DBUSER SET USERNAME =? "
            + "WHERE USER_ID = ?";

    PreparedStatement ps = getConnection().prepareStatement(insertTableSQL);
    ps.setInt(1, 100);
    ps.setString(2, "jdoe");
    ps.setString(3, "app");
    ps.setTimestamp(4, getCurrentTimeStamp());
    ps.executeUpdate(); // data is committed once this method returns.

    psu = getConnection().prepareStatement(updateTableSQL);
    psu.setString(1, "A very very long string that will cause an error");
    psu.setInt(2, 999);

    psu.executeUpdate(); //Error, value too big*/


    //UPDATE with transaction => nothing is inserted because of the error in update

    /*
    dbConnection.setAutoCommit(false); //transaction block start

    String insertTableSQL = "INSERT INTO DBUSER"
            + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
            + "(?,?,?,?)";

    String updateTableSQL = "UPDATE DBUSER SET USERNAME =? "
            + "WHERE USER_ID = ?";

    ps = getConnection().prepareStatement(insertTableSQL);
    ps.setInt(1, 100);
    ps.setString(2, "jdoe");
    ps.setString(3, "app");
    ps.setTimestamp(4, getCurrentTimeStamp());
    ps.executeUpdate(); // this UPDATE is not committed

        psu = dbConnection.prepareStatement(updateTableSQL);
    psu.setString(1, "A very very long string that will cause an error");
    psu.setInt(2, 999);
    psu.executeUpdate(); //Error, rollback, including the first insert statement.

    dbConnection.commit(); //transaction block end*/
}
