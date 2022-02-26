/*

You are given a number N, you've to find the number of different ways to write it as the sum of 1, 3 and 4.

Test Case 1:
5

Ans: 6
 */

import java.util.Scanner;

class Main1{
    static long arr[];

    public static long ways(int num){
        if(num == 0 || num == 1 || num == 2){
            return 1;
        }
        if(num == 3){
            return 2;
        }
        if(arr[num] != 0){
            return arr[num];
        }

        arr[num] = ways(num-1) + ways(num-3) + ways(num-4);

        return arr[num];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        arr = new long[10000000];

        System.out.println(ways(num));
    }
}