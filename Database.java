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



    public void DatabaseBestelling(int ordernnr, String datum) {



        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement("Insert into bestelling(ordernr, datum )VALUES(?,?)");
            myStmt.setInt(1, ordernnr); // set input parameter 1
            myStmt.setString(2, datum); // set input parameter 2
            myStmt.executeUpdate(); // execute insert statement

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DatabaseBestelRegel(int ordernnr, int artikelnr) {



        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement("Insert into bestelregel(ordernr, artikelnr , aantal)VALUES(?,?, 1)");

            myStmt.setInt(1, ordernnr); // set input parameter 1
            myStmt.setInt(2, artikelnr); // set input parameter 2
            myStmt.executeUpdate(); // execute insert statement

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

