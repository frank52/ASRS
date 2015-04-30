package ASRS;



import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Willem on 24-4-2015.
 */
public class Database {
    private String dbUrl = "jdbc:mysql://stephanschrijver.nl:3306/stephhq105_kbs";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "stephhq105_kbs";
    private String pass = "WKJ03";
    private ArrayList<Logboek> logboek1;
    private ArrayList<Artikel> artikel2;
    private ArrayList<Artikel> artikel3;



    public void DatabaseBestelling(int ordernnr, String datum, String voornaam, String achternaam, int aantalArtikelen) {



        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement("Insert into bestelling(ordernr, datum, voornaamKlant, achternaamKlant, aantalArtikelen)VALUES(?,?,?,?,?)");
            myStmt.setInt(1, ordernnr); // set input parameter 1
            myStmt.setString(2, datum); // set input parameter 2
            myStmt.setString(3, voornaam); // set input parameter 2
            myStmt.setString(4, achternaam); // set input parameter 2
            myStmt.setInt(5, aantalArtikelen);

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

    public void Select() {
        logboek1 = new ArrayList<Logboek>();


        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            String query = "select ordernr, voornaamKlant, achternaamKlant, datum, aantalArtikelen from stephhq105_kbs.bestelling ORDER BY datum DESC";
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement(query);
            ResultSet rs = myStmt.executeQuery(query);


            while(rs.next()) {


                int ordernummer = rs.getInt("ordernr"); // set input parameter 1

                String voornaam = rs.getString("voornaamKlant"); // set input parameter 1
                String achternaam = rs.getString("achternaamKlant"); // set input parameter 1
                String datum2 = rs.getString("datum");
                int aantalArtikelen = rs.getInt("aantalArtikelen");
                Logboek logboek = new Logboek(ordernummer, aantalArtikelen, voornaam, achternaam, datum2);
                logboek1.add(logboek);

             //   System.out.println(ordernummer + " " + datumm);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public ArrayList<Logboek> getlist() {
            return logboek1;
    }

    public void SelectArtikelTop(){

        artikel2 = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            String query = "SELECT BR.artikelnr, A.grootte, A.locatie, COUNT(BR.artikelnr), A.naam FROM bestelregel BR JOIN artikel A ON BR.artikelnr = A.artikelnr GROUP BY BR.artikelnr ORDER BY COUNT(*) DESC LIMIT 5";
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement(query);
            ResultSet rs = myStmt.executeQuery(query);


            while(rs.next()) {


                int artikelnr = rs.getInt("artikelnr");
                int grootte = rs.getInt("grootte");
                String locatie = rs.getString("locatie");
                int aantalArt = rs.getInt("COUNT(BR.artikelnr)");
                String naam = rs.getString("naam");

                Artikel artikel = new Artikel(artikelnr,locatie,grootte, aantalArt, naam);
                artikel2.add(artikel);


            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Artikel> getlistArtikel2() {
        return artikel2;
    }
    public void SelectArtikel(){

        artikel2 = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            Connection database = DriverManager.getConnection(dbUrl, user, pass);
            String query = "SELECT * FROM artikel";
            PreparedStatement myStmt = (PreparedStatement) database.prepareStatement(query);
            ResultSet rs = myStmt.executeQuery(query);


            while(rs.next()) {


                int artikelnr = rs.getInt("artikelnr");
                int grootte = rs.getInt("grootte");
                String locatie = rs.getString("locatie");
                String naam = rs.getString("naam");

                Artikel artikel = new Artikel(locatie, grootte, artikelnr, naam);
                artikel3.add(artikel);


            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Artikel> getlistArtikel() {
        return artikel3;
    }
}

