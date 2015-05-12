package ASRS;

/**
 * Created by Willem on 12-5-2015.
 */
public class Enumeratie extends MyMath implements Algoritme{

    private Order order;
    private Route route;
    Vak[] volgorder;
    int kortsteAfstand = 0xFFFFFF;

    public Enumeratie(Order order) {
        this.order = order;
        volgorder = new Vak[order.getVakken().size()];
        berekenRoute(order);
        for(int l = 0; l < volgorder.length; l++)
        {
            System.out.print(volgorder[l].getLocatie().toString());
        }
        System.out.println("");
    }

    @Override
    public void Algoritme(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public Route getRoute() {
        return route;
    }

    @Override
    public void berekenRoute(Order order) {
        Vak[] vakken = new Vak[order.getVakken().size()];
        int i = 0;
        for(Vak v : order.getVakken())
        {
            vakken[i] = v;
            i++;
        }

        System.out.println(order.getVakken().size() + "! = " + super.fac(order.getVakken().size()));
        berekenPerMogelijkheid(vakken);

    }

    public void berekenPerMogelijkheid(Vak[] vakken)
    {
        Vak[] originalVakOrder = new Vak[vakken.length];
        Vak vakToMove;
        Vak tempVak;
        int  x = vakken.length;
        System.out.println(x);

        for(int i = 0; i < vakken.length; i++)
        {
            originalVakOrder[i] = vakken[i];
        }

        for(int l = 0; l < x; l++)
        {
            System.out.print(vakken[l].getLocatie().toString());
        }
        System.out.println("");
        System.out.println("");

        if(x <= 3)
        {
            for(int i = 0; i < super.fac(x-1); i++)
            {
                //berekenPerMogelijkheid(vakken, x-1);
                vakToMove = vakken[x-1];
                for(int j = x-1; j > 0; j--)
                {
                    //for(int k = 0; k < x; k++)
                    //{
                    //System.out.println(j + " vak " + vakken[j-1] + " geruild met" + vakken[j]);
                    for(int l = 0; l < x; l++)
                    {
                        System.out.print(vakken[l].getLocatie().toString());
                    }
                    System.out.println();

                    if(calcAfstand(vakken) < kortsteAfstand)
                    {
                        kortsteAfstand = calcAfstand(vakken);
                        for(int l = 0; l < x; l++)
                        {
                            volgorder[l] = vakken[l];
                        }
                    }

                    if(vakken[j] == vakToMove && j !=0)
                    {
                        tempVak = vakken [j-1];
                        vakken[j-1] = vakken[j];
                        vakken[j] = tempVak;


                    }

                    //}
                }
            }
        }else if (x == 4)
        {

            for(int i = 0; i < x; i++)
            {
                berekenPerMogelijkheid(vakken, x-1);
                if(i == x-1)
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                }else
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                    tempVak = vakken [x-x];
                    vakken[x-x] = vakken[i+1];
                    vakken[i+1] = tempVak;
                }
            }
        }
        else if (x > 4)
        {


            for(int i = 0; i < x; i++)
            {
                berekenPerMogelijkheid(vakken, x-1);
                if(i == x-1)
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                }else
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                    tempVak = vakken [x-x];
                    vakken[x-x] = vakken[i+1];
                    vakken[i+1] = tempVak;
                }
            }
        }
        System.out.println("+");
    }

    public void berekenPerMogelijkheid(Vak[] vakken, int x)
    {
        Vak[] originalVakOrder = new Vak[vakken.length];
        Vak vakToMove;
        Vak tempVak;
        int  y = vakken.length;
        System.out.println(x);

        for(int i = 0; i < vakken.length; i++)
        {
            originalVakOrder[i] = vakken[i];
        }

        if(x <= 3)
        {
            for(int i = 0; i < 3; i++)
            {
                //berekenPerMogelijkheid(vakken, x-1);
                vakToMove = vakken[y-1];
                for(int j = y-1; j > y-3; j--)
                {
                    //for(int k = 0; k < x; k++)
                    //{


                    if(vakken[j] == vakToMove && j !=0)
                    {
                        for(int l = 0; l < y; l++)
                        {
                            System.out.print(vakken[l].getLocatie().toString());
                        }
                        System.out.println();

                        if(calcAfstand(vakken) < kortsteAfstand)
                        {
                            kortsteAfstand = calcAfstand(vakken);
                            for(int l = 0; l < y; l++)
                            {
                                volgorder[l] = vakken[l];
                            }
                        }

                        tempVak = vakken [j-1];
                        vakken[j-1] = vakken[j];
                        vakken[j] = tempVak;


                        //System.out.println(j + " vak " + vakken[j-1] + " geruild met" + vakken[j]);

                    }

                    //}
                }
            }
        }else if(x == 4)
        {

            for(int i = 0; i < x; i++)
            {
                berekenPerMogelijkheid(vakken, x-1);
                if(i == x-1)
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                }else
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                    tempVak = vakken [y-x];
                    vakken[y-x] = vakken[y-x+i+1];
                    vakken[y-x+i+1] = tempVak;
                }



            }
        }else if(x > 4)
        {

            for(int i = 0; i < x; i++)
            {
                berekenPerMogelijkheid(vakken, x-1);
                if(i == x-1)
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                }else
                {
                    for(int j = 0; j < vakken.length; j++)
                    {
                        vakken[j] = originalVakOrder[j];
                    }
                    tempVak = vakken [y-x];
                    vakken[y-x] = vakken[y-x+i+1];
                    vakken[y-x+i+1] = tempVak;
                }



            }
        }
        System.out.println("-");
    }

    private int calcAfstand(Vak[] v)
    {
        int afstand = 0;

        afstand += calcDelta(0, v.length, v[0].getX(), v[v.length-1].getY());

        for(int i = 0; i < v.length-1; i++)
        {
            afstand += calcDelta(v[i].getX(), v[i].getY(), v[i+1].getX(), v[i+1].getY());
        }

        return afstand;
    }

    private int calcDelta(int x1, int y1, int x2,int y2)
    {

        int deltaX = super.delta(x1, x2);
        int deltaY = super.delta(y1, y2);
        int tempDelta = deltaX + deltaY;
        return tempDelta;
    }


}
