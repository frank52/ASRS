package ASRS;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ArduinoFuncties
{
    private ArrayList<Vak> vakken;
    private ArrayList<Integer> xArray;
    private ArrayList<Integer> yArray;
    private Scherm scherm;
    Connectie connectie;
    Aansturing aansturing;
    private boolean bezig;
    private Timer timer;
    private beweeg bewegen;

    private int i = 0;

    public ArduinoFuncties(Scherm scherm, Connectie c, Aansturing a, Timer t)
    {
        this.scherm = scherm;
        connectie = c;
        a = a;
        vakken = scherm.getVakken();
        timer = t;
        arduino();
        bewegen = new beweeg(true);
        t.scheduleAtFixedRate(bewegen,0,1);

    }
    public beweeg getBeweeg()
    {
        return bewegen;
    }

    public void arduino()
    {
        

            int x = 0;
            int x2 = 0;
            int x3 = 0;
            int y = 4;
            int y2 = 0;
            int y3 = 0;
            xArray = new ArrayList<>();
            yArray = new ArrayList<>();
            for (Vak a : vakken)
            {
                x2 = a.getX();
                x3 = x2 - x;
                System.out.println(x3);
                xArray.add(x3);
                x = x2;
            }
            for (Vak a : vakken)
            {
                y2 = a.getY();
                y3 = (y2 - y);
                //System.out.println(y3);
                yArray.add(y3);
                y = y2;
            }

            for (Integer i : xArray)
            {

            }
        
    }
    public class beweeg extends TimerTask {


        public beweeg(boolean b) {
            bezig = b;
        }

        public void setBeweeg(boolean b)
        {
            bezig = b;
        }

        public void run() {
            boolean pakken;
            pakken = false;
            boolean beweegt;
            while (bezig == true) {
                beweegt = false;
                while (vakken.size() >= 1) {

                    if (beweegt == false) {
                        String xx = Integer.toString(xArray.get(0));
                        String yy = Integer.toString(yArray.get(0));
                        String xyString = xx + "," + yy;
                        startRobot(xyString);
                        pakken = true;
                        beweegt = true;
                        xArray.remove(0);
                        yArray.remove(0);
                        vakken.remove(0);
                    }
                    // beweegt = ardulink
                    try {
                        while (!connectie.isOntvangen()) {
                            Thread.sleep(1);

                        }
                    } catch (InterruptedException ie) {
                    }
                    beweegt = false;

                }



            }

        }
    }

    public void startRobot(String l)
    {
        connectie.sendData(l);
    }

    public void stopRobot()
    {
        aansturing.stuur("stop");
    }

    public void stuurLopendeBand(String richting){

            if(connectie.isOntvangen()) {
                if (richting == "naarRechts") {
                    aansturing.stuur("right");
                } else if (richting == "naarLinks") {
                    aansturing.stuur("left");
                }
            }

    }
}
