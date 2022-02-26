/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

TestCase - 1:
input : [[0,0,0],[1,1,0],[1,1,0]]
output : 4

TestCase - 2:
input : [[1,0,0],[1,1,0],[1,1,0]]
output : -1

 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Shortest_Path_In_Binary_Matrix {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int[][] grid = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(shortestPathBinaryMatrix(grid));
        }
        catch (Exception e){
            System.out.println(e + " " + e.getStackTrace()[0].getLineNumber());
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int[][] visitedGrid = new int[grid.length][grid.length];

        Arrays.stream(visitedGrid).forEach(a -> Arrays.fill(a, -1));

        if(grid[0][0] == 1){
            return -1;
        }

        visitedGrid[0][0] = 1;

        Queue<int[]> q = getAllZeros(0,0,grid,new LinkedList<>(),1,visitedGrid);

        while(!q.isEmpty()){
            int[] arr = q.remove();
            q = getAllZeros(arr[0],arr[1],grid,q,visitedGrid[arr[0]][arr[1]],visitedGrid);
        }

        return visitedGrid[grid.length-1][grid.length-1];
    }

    public static Queue getAllZeros(int i, int j, int[][]grid, Queue q, int breadth,
                                    int[][] visitedGrid){

        int[][] direction = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};

        for(int k=0; k<direction.length; k++){
            int m = i + direction[k][0];
            int n = j + direction[k][1];

            if(m < 0 || m >= grid.length || n < 0 || n >= grid.length){
                continue;
            }
            else{
                if(grid[m][n] != 1 && visitedGrid[m][n] == -1){
                    visitedGrid[m][n] = breadth + 1;
                    int[] zeroPosition = new int[2];
                    zeroPosition[0] = m;
                    zeroPosition[1] = n;
                    q.add(zeroPosition);
                }
            }
        }

        return q;

    }
}
