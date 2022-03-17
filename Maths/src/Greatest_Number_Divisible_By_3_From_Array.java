import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
You have L, a list containing some digits (0 to 9).
Write a function solution(L) which finds the largest number that can be made from some or all of
these digits and is divisible by 3.
If it is not possible to make such a number, return 0 as the solution. L will contain anywhere from 1 to 9 digits.
The same digit may appear multiple times in the list, but each element in the list may only be used once.
 */
public class Greatest_Number_Divisible_By_3_From_Array {
    public static void main(String[] args) {
        int[] l = new int[]{3,1,4,1,5,9};
        System.out.println(solution(l));
    }
    public static int fillTemp(Queue<Integer> queue0,
                                  Queue<Integer> queue1, Queue<Integer> queue2,int temp[])
    {
        int first=0;
        while(!queue0.isEmpty())
        {
            temp[first++]=queue0.remove();
        }
        while(!queue1.isEmpty())
        {
            temp[first++]=queue1.remove();
        }
        while(!queue2.isEmpty())
        {
            temp[first++]=queue2.remove();
        }
        return first;
    }
    public static int solution(int[] l)
    {
        Arrays.sort(l);
        Queue<Integer> queue0=new LinkedList<>();
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        int sum=0;
        for (int i = 0; i < l.length; ++i)
        {
            sum += l[i];
            if ((l[i] % 3) == 0)
                queue0.add(l[i]);
            else if ((l[i] % 3) == 1)
                queue1.add(l[i]);
            else
                queue2.add(l[i]);
        }
        if ((sum % 3) == 1){
            if (!queue1.isEmpty())
                queue1.remove();
            else
            {
                if (!queue2.isEmpty())
                    queue2.remove();
                else
                    return 0;

                if (!queue2.isEmpty())
                    queue2.remove();
                else
                    return 0;
            }
        }
        else if ((sum % 3) == 2)
        {
            if (!queue2.isEmpty())
                queue2.remove();
            else
            {
                if (!queue1.isEmpty())
                    queue1.remove();
                else
                    return 0;

                if (!queue1.isEmpty())
                    queue1.remove();
                else
                    return 0;
            }
        }
        int temp[]=new int[l.length];
        int first=fillTemp(queue0,queue1,queue2,temp);
        Arrays.sort(temp,0,first);
        StringBuffer sb = new StringBuffer();
        for(int i=temp.length-1; i>=0;i--){
            sb.append(temp[i]);
        }
        if(sb.toString() == ""){
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }
//    static int MAX_NUM = 10;
//    public static int solution(int[] l){
//        int n = l.length;
//        if(n == 0){
//            return 0;
//        }
//        int sum = sumOfAllNumbers(l,n);
//        sortArray(l, n);
//        if (sum % 3 == 0){
//            return removeAndSend(l, n, -1, -1);
//        }
//        int remainder = sum % 3;
//        if (remainder == 1){
//            int[] remain_2 = new int[2];
//            remain_2[0] = -1;
//            remain_2[1] = -1;
//            for (int i=0; i<n; i++){
//                if (l[i] % 3 == 1){
//                    return removeAndSend(l, n, i, -1);
//                }
//                if (l[i] % 3 == 2){
//                    if (remain_2[0] == -1){
//                        remain_2[0] = i;
//                    }
//                    else if (remain_2[1] == -1){
//                        remain_2[1] = i;
//                    }
//                }
//            }
//            if (remain_2[0] != -1 && remain_2[1] != -1){
//                return removeAndSend(l,n,remain_2[0],remain_2[1]);
//            }
//        }
//        else if (remainder == 2){
//            int[] remain_1 = new int[2];
//            remain_1[0] = -1;
//            remain_1[1] = -1;
//            for (int i=0; i<n; i++){
//                if (l[i] % 3 == 2){
//                    return removeAndSend(l, n, i, -1);
//                }
//                if (l[i] % 3 == 1){
//                    if (remain_1[0] == -1){
//                        remain_1[0] = i;
//                    }
//                    else if (remain_1[1] == -1){
//                        remain_1[1] = i;
//                    }
//                }
//            }
//            if (remain_1[0] != -1 && remain_1[1] != -1){
//                return removeAndSend(l,n,remain_1[0],remain_1[1]);
//            }
//        }
//        return 0;
//    }
//    static Integer removeAndSend (int l[],int n,int ind_1,int ind_2){
//        StringBuffer sb = new StringBuffer();
//        for (int i=n - 1; i>=0; i--)
//        {
//            if (i!=ind_1 && i!=ind_2)
//            {
//                sb.append(l[i]);
//            }
//        }
//        if(sb.toString() == ""){
//            return 0;
//        }
//        return Integer.parseInt(sb.toString());
//    }
//    static int sumOfAllNumbers(int[] l,int n){
//        int sum = 0;
//        for (int i=0; i<n; i++){
//            sum += l[i];
//        }
//        return sum;
//    }
//    static void sortArray(int l[],int n){
//        int[] count = new int[MAX_NUM];
//        for (int i=0; i<n; i++){
//            count[l[i]]++;
//        }
//        int ind = 0;
//        for (int i=0; i<MAX_NUM; i++)
//        {
//            while (count[i] > 0)
//            {
//                l[ind++] = i;
//                count[i]--;
//            }
//        }
//    }
}
