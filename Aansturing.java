package ASRS;

/**
 * Created by Willem on 19-5-2015.
 */
public class Aansturing {
    private Connectie c;

    public Aansturing(Connectie c)
    {
        this.c = c;
    }

    public void stuur(String s)
    {
        c.sendData(s);
        try
        {
            while(!c.isOntvangen())
            {
                Thread.sleep(1);
            }
        }
        catch (InterruptedException ie)
        {
        }
    }
}
