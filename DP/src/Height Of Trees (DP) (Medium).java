/*
You are given n trees and their heights.
Your task is to write a program that calculates the maximum number of trees whose height is in increasing order.
They need not be in continuous manner.

For instance, if heights of 9 trees are 10, 22, 9, 33, 21, 50, 41, 60, 80.
The maximum number of trees whose height is in increasing order is 6 : (10, 22, 33, 50, 60, 80).

(9,21, 41, 60, 80) is also in increasing manner, but you need to find the maximum number of trees whose height is increasing.
So, the answer is 6

Test Case 1:
9
10 22 9 33 21 50 41 60 80

Ans: 6

Test Case 2:
100
35 92 59 15 40 14 71 9 71 110 68 149 114 27
51 110 134 15 96 145 20 27 43 94 111 125 34
144 11 29 63 91 80 89 14 30 148 19 3 141 13
104 142 108 87 64 68 115 95 47 47 131 122 82
24 127 59 97 48 114 67 123 112 145 1 2 73 110
62 66 104 28 8 64 40 98 136 138 119 75 116 1
53 82 60 90 81 147 107 1 96 18 64 50 58 3 147 147 137 50

Ans: 16

*/

import java.util.Scanner;

class Main{
    public static int height(int[] arr, int count, int len, int[] tempArr){
        if (len == 1){
            return count;
        }

        for(int i=1; i<len; i++){
            int temp = arr[i];
            for(int j=0; j<i; j++){
                if(arr[j] < temp){
                    if(tempArr[i] <= tempArr[j]){
                        tempArr[i]++;
                    }
                }
            }
        }

        for(int i=0; i<len; i++){
           count = Math.max(count, tempArr[i]);
        }

        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int[] arr = new int[len];

        for(int i=0; i<len; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 1;

        int[] tempArr = new int[len];

        for(int i=0; i<len; i++){
            tempArr[i] = 1;
        }

        System.out.println(height(arr,count,len,tempArr));
    }
}
