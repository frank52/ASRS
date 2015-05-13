package ASRS;

/**
 * Created by Willem on 1-5-2015.
 */
public class Vak {
    private Locatie locatie;


    public Vak(int x, int y) {
        this.locatie = new Locatie(x, y);

    }





    public String getLocatie() {
        return locatie.toString();
    }

    public int getX()
    {
        return locatie.getX();
    }

    public int getY()
    {
        return locatie.getY();
    }





    @Override
    public String toString() {
        //return "Vak{" + "locatie=" + locatie + '}';
        return ""+locatie+"";
    }

}
