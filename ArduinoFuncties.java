package ASRS;

import java.util.ArrayList;

/**
 * Created by Maarten on 19-5-2015.
 */
public class ArduinoFuncties {
    private ArrayList<Vak> vakken;
    private  ArrayList<Integer> xArray;
    private ArrayList<Integer> yArray;
    private Scherm scherm;
    Connectie connectie;
    Aansturing aansturing;

    private int i=0;

    public ArduinoFuncties(Scherm scherm) {
        this.scherm = scherm;
        vakken = scherm.getVakken();
        arduino();
    }

    public void arduino()
    {
        startConnectie();
        int x = 0;
        int x2 =0;
        int x3 =0;
        int y = 4;
        int y2 = 0;
        int y3 = 0;
        xArray = new ArrayList<>();
        yArray = new ArrayList<>();
        for(Vak a: vakken)
        {
            x2 = a.getX();
            x3 = x2 - x;
            System.out.println(x3);
            xArray.add(x3);
            x = x2;
        }
        for (Vak a: vakken)
        {
            y2 = a.getY();
            y3 = (y2 - y) * -1;
            //System.out.println(y3);
            yArray.add(y3);
            y = y2;
        }

        for(Integer i: xArray)
        {

        }
    }
    public void beweeg(boolean bezig)
    {
        boolean beweegt;
        boolean pakken;
        pakken = false;
        while(bezig == true)

        {
            while(vakken.size() >= 1)
            {
                beweegt = false;
                if (beweegt == false)
                {
                    xArray.get(0);
                    yArray.get(0);
                    pakken = true;
                    beweegt = true;
                    xArray.remove(0);
                    yArray.remove(0);
                    vakken.remove(0);
                }
                // beweegt = ardulink
                if (beweegt == false && pakken == true)
                {
                    //pakken
                }

            }
            //sorteer
        }
    }

    public void startConnectie(){
        connectie = new Connectie();
        aansturing= new Aansturing(connectie);

        if (connectie.initialize())
        {

            connectie.close();
        }

        // Wait 5 seconds then shutdown
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie)
        {
        }
    }

    public void startRobot(){
       aansturing = new Aansturing(connectie);
        aansturing.stuur("start");
    }

    public void stopRobot(){
        aansturing = new Aansturing(connectie);
        aansturing.stuur("stop");
    }
}

