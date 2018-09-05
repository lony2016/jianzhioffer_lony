package com.testextends;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 12038 on 2018/9/4.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int num = in.nextInt();
        int time = in.nextInt();
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
        int[] arr = new int[3];
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<num; ++i)
        {
            for(int j=0; j<3; ++j)
            {
                arr[i] = in.nextInt();
            }
            if(time >= arr[1] && time <= arr[2])
            {
                res.add(arr[0]);
            }
        }
        if(res.size() == 0)
        {
            System.out.println("null");
        }
        else
        {
            for(int i=0; i<res.size(); ++i)
                System.out.println(res.get(i));
        }
    }

}
