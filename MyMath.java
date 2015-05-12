package ASRS;

/**
 * Created by Willem on 12-5-2015.
 */
public class MyMath {
    public int delta(int a, int b)
    {
        if(a - b >= 0)
        {
            return a - b;
        }else
        {
            return b-a;
        }
    }

    public long fac(long a)
    {
        if(a > 20)
        {
            return 0;
        }
        else if(a == 1 || a == 0)
        {
            return 1;
        }
        else
        {
            return a * fac(a-1);
        }
    }
}
