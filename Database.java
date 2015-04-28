package ASRS;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;


/**
 * Created by Willem on 24-4-2015.
 */
public class Database {
    String dbUrl = "jdbc:mysql://stephanschrijver.nl:3306/stephhq105_kbs";
    String driver = "com.mysql.jdbc.Driver";
    String user = "stephhq105_kbs";
    String pass = "WKJ03";



    public void DatabaseBestelling() {


        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement("Insert into bestelling(ordernr, datum , artikel, artikel_locatie)VALUES(?,?,?,?)");
            myStmt.setInt(1, 1); // set input parameter 1
            myStmt.setString(2, "14-2-2015"); // set input parameter 2
            myStmt.setInt(3, 2); // set input parameter 3
            myStmt.setString(4, "A5");
            myStmt.executeUpdate(); // execute insert statement

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

