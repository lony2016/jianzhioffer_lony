import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int k = scan.nextInt();

        int[] score = new int[num];
        int[] isSleep = new int[num];

        int i = 0;
        while(scan.hasNext()){
            if(i<num){
                score[i] = scan.nextInt();
            }else if(i>=num){
                isSleep[i-num] = scan.nextInt();
            }
            i++;
            if(i==2*num) break;
        }

        int sum = 0;
        int temp = 0;
        int right = 0;
        for (int j = 0; j < num; j++) {

            if(isSleep[j] == 1){
                sum += score[j];
            }else{
                temp = 0;
                for(int u=j; u<j+k && u<num; u++){
                    if(isSleep[u] == 0){
                        temp += score[u];
                    }
                }
                if(right < temp){
                    right = temp;
                }
            }
        }

        int res = sum + right;

        System.out.println(res);
    }
}