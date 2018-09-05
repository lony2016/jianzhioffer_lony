package com.test;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lony on 2018/5/17.
 */
public class ValueOrRef {
    public static void main(String[] args) {
        Person zhangsan = null;
        changePerson(zhangsan);
        zhangsan.printName();
    }
    public static void changePerson(Person person){
        person = new Person("LI Si");
    }


    public boolean findRepeatNum (int[] nums, int[] duplication) throws Exception
    {
        int len = nums.length;
        if(nums == null && len <= 0)
        {
            return false;
        }


        int i = 0, j = 0;
        int temp = 0;
        while(i < len)
        {
            if(i == nums[i])
            {
                ++i;
                continue;
            }
            else if(nums[i] == nums[nums[i]])
            {
                duplication[j++] = nums[i];
            }
            else
            {
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return true;
    }
}

class Person {
    String name = "default";
    public Person(String name) {
        this.name = name;
    }
    public void changeName(String name){
        this.name = name;
    }
    void printName() {
        System.out.println(this.name);
    }
}

//测试异常
class TestException {

    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;//return会覆盖掉catch块中throw e的值
        }
    }

    public static void main(String[] args) {
        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class BootstrapTest
{
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(int i=0; i<urls.length; ++i)
        {
            System.out.println(urls[i].toExternalForm());
        }
    }
}