import java.util.Scanner;
import java.util.Arrays;

class Main{
    public static void reverseString(char[] s) {
        int p1 = 0;

        int p2 = s.length - 1;

        while(p1 <= p2){
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;
            p1++;
            p2--;
        }

        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        char str[] = s.toCharArray();

        reverseString(str);
    }
}