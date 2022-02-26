/*

You are given an array and an integer K.
The challenge is to produce the  minimal array after at most K-swaps.
Only consecutive pairs of elements can be swapped.

Find the minimal array possible after at most K-swaps.

Test Case 1:
2
3 2
5 3 1
5 3
8 9 11 2 1


 */
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for(int t=0; t<test; t++){
            int len = sc.nextInt();

            int swap = sc.nextInt();

            int[] arr = new int[len];

            for(int i=0; i<len; i++){
                arr[i] = sc.nextInt();
            }

            for(int i=swap; i>=1; i--){
                if(arr[i] < arr[i-1]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }

            for(int i=0; i<len; i++){
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }
    }
}