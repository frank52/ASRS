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
    private Connectie connectie;
    private Aansturing aansturing;
    private boolean bezig;
    private Timer timer;
    private beweeg bewegen;

    private int i = 0;

    public ArduinoFuncties(Scherm scherm, Connectie c, Aansturing a, Timer t)
    {
        this.scherm = scherm;
        connectie = c;
        aansturing = a;
        vakken = scherm.getVakken();
        timer = t;
        arduino();
        bewegen = new beweeg(true);
        t.scheduleAtFixedRate(bewegen, 0, 1);

    }

    public ArduinoFuncties(Scherm scherm, Connectie c, Aansturing a)
    {
        this.scherm = scherm;
        connectie = c;
        aansturing = a;
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
            //System.out.println(x3);
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

    public void startRobot(String l)
    {
        connectie.sendData(l);
    }

    public void stopRobot()
    {
        aansturing.stuur("stop");
    }

    public void stuurLopendeBand(String richting)
    {
        if (richting.equals("naarRechts"))
        {
            connectie.sendData("right");

        }
        else if (richting.equals("naarLinks"))
        {
            connectie.sendData("left");
        }

        else if (richting.equals("nieuwRechts"))
        {
            connectie.sendData("newRight");
            while (!connectie.isOntvangen())
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                }

            }

        }
        else if (richting.equals("nieuwLinks"))
        {
            connectie.sendData("newLeft");
            while (!connectie.isOntvangen())
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                }

            }
        }

    }

    public class beweeg extends TimerTask
    {

        public beweeg(boolean b)
        {
            bezig = b;
        }

        public void setBeweeg(boolean b)
        {
            bezig = b;
        }

        public void run()
        {
            int iii = 0;
            boolean pakken = false;
            boolean beweegt;
            while (bezig == true)
            {
                beweegt = false;
                while (vakken.size() >= 1)
                {
                    if (beweegt == false)
                    {
                        String xx = Integer.toString(xArray.get(0));
                        String yy = Integer.toString(yArray.get(0));
                        String xyString = xx + "," + yy;
                        startRobot(xyString);
                        pakken = true;
                        beweegt = true;
                        xArray.remove(0);
                        yArray.remove(0);

                    }
                    // beweegt = ardulink
                    try
                    {
                        while (!connectie.isOntvangen())
                        {
                            Thread.sleep(1);

                        }
                    }
                    catch (InterruptedException ie)
                    {
                    }
                    beweegt = false;
                    iii++;
                    if (iii == 3)
                    {
                        String beweegHo = "" + (0 - vakken.get(0).getX()) + "";
                        String beweegVe = "" + (4 - vakken.get(0).getY()) + "";
                        String beweegVeHo = beweegHo + "," + beweegVe;
                        vakken.remove(0);
                        connectie.sendData("startpositie");
                        while (!connectie.isOntvangen())
                        {
                            try
                            {
                                Thread.sleep(1);
                            }
                            catch (InterruptedException e)
                            {
                            }

                        }
                        connectie.sendData(beweegVeHo);
                        while (!connectie.isOntvangen())
                        {
                            try
                            {
                                Thread.sleep(1);
                            }
                            catch (InterruptedException e)
                            {
                            }

                        }
                        connectie.sendData("drop");
                        while (!connectie.isOntvangen())
                        {
                            try
                            {
                                Thread.sleep(1);
                            }
                            catch (InterruptedException e)
                            {
                            }

                        }

                        String beweegHo2 = "" + (vakken.get(0).getX()) + "";
                        String beweegVe2 = "" + (vakken.get(0).getY() - 4) + "";
                        String beweegVeHo2 = beweegHo2 + "," + beweegVe2;
                        connectie.sendData(beweegVeHo2);
                        while (!connectie.isOntvangen())
                        {
                            try
                            {
                                Thread.sleep(1);
                            }
                            catch (InterruptedException e)
                            {
                            }

                        }
                        xArray.remove(0);
                        yArray.remove(0);
                        iii = 1;
                        if (iii == vakken.size())
                        {
                            String beweegHo3 = "" + (0 - vakken.get(0).getX()) + "";
                            String beweegVe3 = "" + (4 - vakken.get(0).getY()) + "";
                            String beweegVeHo3 = beweegHo3 + "," + beweegVe3;
                            connectie.sendData("startpositie");
                            while (!connectie.isOntvangen())
                            {
                                try
                                {
                                    Thread.sleep(1);
                                }
                                catch (InterruptedException e)
                                {
                                }

                            }
                            connectie.sendData(beweegVeHo3);
                            while (!connectie.isOntvangen())
                            {
                                try
                                {
                                    Thread.sleep(1);
                                }
                                catch (InterruptedException e)
                                {
                                }

                            }
                            connectie.sendData("drop");
                            while (!connectie.isOntvangen())
                            {
                                try
                                {
                                    Thread.sleep(1);
                                }
                                catch (InterruptedException e)
                                {
                                }

                            }

                        }
                        vakken.remove(0);

                    }
                    else
                    {
                        if (iii == 2 && vakken.size() == 1)
                        {
                            String beweegHo = "" + (0 - vakken.get(0).getX()) + "";
                            String beweegVe = "" + (4 - vakken.get(0).getY()) + "";
                            String beweegVeHo = beweegHo + "," + beweegVe;
                            connectie.sendData("startpositie");
                            while (!connectie.isOntvangen())
                            {
                                try
                                {
                                    Thread.sleep(1);
                                }
                                catch (InterruptedException e)
                                {
                                }

                            }
                            connectie.sendData(beweegVeHo);
                            while (!connectie.isOntvangen())
                            {
                                try
                                {
                                    Thread.sleep(1);
                                }
                                catch (InterruptedException e)
                                {
                                }

                            }
                            connectie.sendData("drop");
                            while (!connectie.isOntvangen())
                            {
                                try
                                {
                                    Thread.sleep(1);
                                }
                                catch (InterruptedException e)
                                {
                                }

                            }

                        }
                        try
                        {
                            vakken.remove(0);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                }

            }
            connectie.close();
        }
    }

}
