package com.acmday.series.jdk.entry;

import com.acmday.series.jdk.bo.Numb;
import com.acmday.series.jdk.util.ThreadPoolUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author acmday.
 * @date 2020/4/4.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        submitDemo();
    }

    private static void submitDemo(){
        List<Future<Numb>> futures = new ArrayList<>();
        for(int i = 10010; i<10110; ++i) {
            int code = i;
            Future<Numb> future = ThreadPoolUtil.executor.submit(new Callable<Numb>() {
                @Override
                public Numb call() throws Exception {
                    System.out.println("提交成功,code="+code);
                    //Thread.sleep(1000 * 3600);
                    //这里不能直接用i
                    return new Numb(code);
                }
            });
            futures.add(future);
        }
        futures.forEach(elem -> {{
            try {
                Numb nu = elem.get();
                System.out.println(nu.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
            try {
                Numb nu = elem.get();
                System.out.println(nu.getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        ThreadPoolUtil.executor.shutdownNow();
    }

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final Integer CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int workerCountOf(int c)  {
        return c & CAPACITY;
    }

    /**
     bit29.length=30
            bit29=  100000000000000000000000000000
         capacity=   11111111111111111111111111111
                a=11100000000000000000000000000000
        runStatOf=11100000000000000000000000000000
      ----RUNNING=-536870912
         SHUTDOWN=0
             STOP=536870912
          TIDYING=1073741824
       TERMINATED=1610612736
     0
     */
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    @Test
    public void bitCal() {
        //RUNNING状态的值
        int a = -536870912;
        System.out.println("bit29.length="+Integer.toBinaryString(1 << COUNT_BITS).length());
        System.out.println("       bit29="+Integer.toBinaryString(1 << COUNT_BITS));
        System.out.println("    capacity="+Integer.toBinaryString(CAPACITY));
        System.out.println("           a="+Integer.toBinaryString(a));

        System.out.println("   runStatOf="+Integer.toBinaryString(a & ~CAPACITY));
        System.out.println(" ----RUNNING="+RUNNING);
        System.out.println("    SHUTDOWN="+SHUTDOWN);
        System.out.println("        STOP="+STOP);
        System.out.println("     TIDYING="+TIDYING);
        System.out.println("  TERMINATED="+TERMINATED);
        System.out.println(workerCountOf(a));
    }
}
