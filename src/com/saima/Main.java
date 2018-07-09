package com.saima;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        int[][] pv = new int[m][2];
        for(int i=0; i<m;i++)
        {
            for(int j=0; j<2;++j)
            {
                pv[i][j] = cin.nextInt();
            }
        }
    }

    public static int sum(int m) {
        if (m == 1)
            return 0;
        if (m == 2)
            return 1;
        if (m == 3)
            return 2;
        int f1 = 1;
        int f2 = 2;
        int sum = 0;
        for (int i = 4; i <= m; ++i) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

    public static int stockPrice(int n)
    {
        int plusDays = 1;
        int i = 2;
        int plus = 1;
        int price = 1;
        while (i<=n)
        {
            if(plus <= plusDays)
            {
                price++;
                plus++;
            }
            else
            {
                price--;
                plusDays++;
                plus = 1;
            }
            i++;
        }
        return price;
    }

//    int n, money, i;
//	while (cin >> n) {
//        if(n >= 1 && n <= 10 ^ 9) {
//            money = n;
//            n = n - 1;
//            i = 2;
//            while (n - i >= 0)
//            {
//                n = n - i;
//                money -= 2;
//                i++;
//            }
//            cout << money << endl;
//        }
//    }
//	return 0;

}
