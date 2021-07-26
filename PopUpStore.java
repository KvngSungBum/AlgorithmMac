import java.util.*;

public class PopUpStore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//가로
        int n = sc.nextInt();//세로
        int[][] map = new int[n][m];
        //다이나믹 프로그래밍
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                map[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        sc.close();

        dp[0][0] = map[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0)
                    dp[i][j] = map[i][j];
                else if(i<n&& i >=0 && j>=0 && j<m){
                    if(j==0){
                        dp[i][j] = dp[i-1][j] + map[i][j];
                    }
                    else if(i==0){
                        dp[i][j] = dp[i][j-1] +map[i][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + map[i][j];
                    }
                }
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n-1][m-1]);
        System.out.println("수정");
    }
}
