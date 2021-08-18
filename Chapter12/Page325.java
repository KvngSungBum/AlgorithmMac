package Chapter12;

import java.util.Scanner;

public class Page325 {
    public static boolean solution(int[][] key, int[][] lock){
        boolean answer = true;

        

        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] key = new int[n][n];
        int[][] lock = new int[m][m];

        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                key[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                lock[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        boolean result = solution(key, lock);
        System.out.println(result);
    }
}
