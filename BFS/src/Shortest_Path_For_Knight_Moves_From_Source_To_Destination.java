import java.util.LinkedList;
import java.util.Queue;

/*
Given a grid of 2d matrix from 0 to 63, find the shortest path from source to destination for how a knight moves.
PS :- knight moves in a 'L' shaped way

Test 1 :-
src = 0, destination = 1
ans = 3

Test 2 :-
src = 0, destination = 63
ans = 6

Test 3 :-
src = 19, destination = 36
ans = 1
 */

public class Shortest_Path_For_Knight_Moves_From_Source_To_Destination {
    public static void main(String[] args) {
        System.out.println(solution(19,36));
    }
    public static int solution(int src, int dest) {
        if(src == dest){
            return 0;
        }
        int[][] arr = returnGrid();
        int[] srcPosition = searchSrc(src,arr);
        int[][] checkArr = returnCheckGrid();
        int[][] positions = new int[][]{{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        int moves = bfs(dest,arr,positions,srcPosition[0],srcPosition[1],checkArr);
        return moves;
    }
    public static int bfs(int dest, int[][] arr,int[][] positions,int m,int n,int[][] checkArr){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{m,n});
        while(!queue.isEmpty()){
            int[] pos = queue.remove();
            for(int i=0; i<positions.length; i++){
                int a = pos[0] + positions[i][0];
                int b = pos[1] + positions[i][1];
                if((a >= 0 && a <=7) && (b >=0 && b <= 7) && (checkArr[a][b] == 0)){
                    checkArr[a][b] = checkArr[pos[0]][pos[1]] + 1;
                    queue.add(new int[]{a,b});
                    if(arr[a][b] == dest){
                        return checkArr[a][b];
                    }
                }
            }
        }
        return -1;
    }
    public static int[] searchSrc(int src, int[][] arr){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(arr[i][j] == src){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static int[][] returnGrid(){
        int[][] arr = new int[8][8];
        int count = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                arr[i][j] = count;
                count++;
            }
        }
        return arr;
    }
    public static int[][] returnCheckGrid(){
        int[][] arr = new int[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                arr[i][j] = 0;
            }
        }
        return arr;
    }
}
