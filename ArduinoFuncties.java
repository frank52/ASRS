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
            beweegt = false;
            while(vakken.size() >= 1)
            {

                if (beweegt == false)
                {
                    String xx = Integer.toString(xArray.get(0));
                    String yy = Integer.toString(yArray.get(0));
                    startRobot(xx + "," + yy);
                    pakken = true;
                    beweegt = true;
                    xArray.remove(0);
                    yArray.remove(0);
                    vakken.remove(0);
                }
                // beweegt = ardulink
                try
                {
                    while(!connectie.isOntvangen())
                    {
                        Thread.sleep(1);
                    }
                }
                catch (InterruptedException ie)
                {
                }
                beweegt = false;

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

    public void startRobot(String l){
       aansturing = new Aansturing(connectie);
        aansturing.stuur(l);
    }

    public void stopRobot(){
        aansturing = new Aansturing(connectie);
        aansturing.stuur("stop");
    }
}

