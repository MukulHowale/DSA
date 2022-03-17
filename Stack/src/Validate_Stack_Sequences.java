import java.util.Stack;

/*
Given two integer arrays pushed and popped each with distinct values,
return true if this could have been the result of a sequence of push and pop operations on an initially empty stack,
or false otherwise.

Test 1 :
pushed = 1,2,3,4,5
popped = 4,5,3,2,1

ans = true

Test 2 :
pushed = 1,2,3,4,5
popped = 4,3,5,1,2

ans = false
 */

public class Validate_Stack_Sequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int push = 0, pop = 0;

        while(push < pushed.length){
            st.push(pushed[push]);
            push++;
            while(!st.isEmpty() && st.peek() == popped[pop]){
                st.pop();
                pop++;
            }
        }

        while(pop < popped.length){
            if(st.peek() == popped[pop]){
                st.pop();
                pop++;
            }
            else{
                break;
            }
        }

        if(st.isEmpty()){
            return true;
        }

        return false;
    }
}
