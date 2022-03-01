import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Shortest_Unsorted_Continuous_Subarray {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];
            for(int i=0; i<len; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st1.nextToken());
            }
            findUnsortedSubarray(arr);
        }
        catch(Exception e){
            System.out.println(e + " " + e.getStackTrace()[0].getLineNumber());
        }
    }

    public static int findUnsortedSubarray(int[] nums) {

        int leftIndex = -1, rightIndex = -2;

        int maxNum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
            }
            if(nums[i] < maxNum){
                rightIndex = i;
            }
        }

        int minNum = Integer.MAX_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            if(minNum > nums[i]){
                minNum = nums[i];
            }
            if(nums[i] > minNum){
                leftIndex = i;
            }
        }

        return (rightIndex - leftIndex) + 1;
    }
}
