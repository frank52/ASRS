package ASRS;

import java.sql.Statement;
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
            Statement myStmt = database.createStatement();

        int rowsAffected = myStmt.executeUpdate(
                "insert into bestelling" +
                        "('ordern', 'datum', 'artikel', 'artikel_locatie' )"+
                        "values"+
                                "('32', '24-4-2015', '5', 'A5')"
        );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

