package test;

import java.util.HashMap;

public class MemoryLeak {
    HashMap hm = new HashMap();
    long curValue;
    
    MemoryLeak()
    {
        curValue = 0;
    }
    
    public static void main ( String [] args )
    {
        try {
            MemoryLeak ml = new MemoryLeak();
            for ( int j = 0; j < 100; j++ )
            {
                for ( int u = 0; u < 5000; u++ )
                {
                    ml.leakMemory();
                    ml.curValue++;
                }
                Thread.currentThread().sleep(2000); // Wait 2 seconds
            }
        }
        catch ( Exception ex )
        {
            System.out.println("exception: ex = " + ex);
        }
    }
    
    void setReference( GeneralClass gc )
    {
        hm.put( curValue, gc );
    }
    
    public void leakMemory()
    {
        try {
            GeneralClass gc = new GeneralClass();
            setReference( gc );
        }
        catch ( Exception ex )
        {
            System.out.println("exception: ex = " + ex);
        }
    }
}
class GeneralClass
{
    int a;
    int b;
    String s1;
    String s2;
    GeneralClass()
    {
        a = 0;
        b = 4;
        s1 = "s1";
        s2 = "s2";
    }
}