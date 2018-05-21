package com.test;

import java.util.Vector;

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
