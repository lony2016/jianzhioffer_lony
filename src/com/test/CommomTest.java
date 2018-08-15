package com.test;

/**
 * Created by 12038 on 2018/7/30.
 * 1.finally test
 */
public class CommomTest {
}
class FinallyTest4 {

    public static void main(String[] args) {

        System.out.println(test4());
    }

    public static int test4() {
        int b = 20;

        try {
            System.out.println("try block");

            b = b / 0;//出现异常

            return b += 80;
        } catch (Exception e) {

            b += 15;
            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            b += 50;
        }

        return b;
    }


}

class FinallyTest
{
    public synchronized int aMethod(int i)throws Exception
    {
        try{
            return 10 / i;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }

    public static void main(String [] args) throws Exception {
        try
        {
//            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");

        FinallyTest te = new FinallyTest();
        te.aMethod(2);
        
    }
}

