import java.util.*;

public class PopUpStore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        //다이나믹 프로그래밍
        int[] dp = new int[n*m];

        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                map[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        sc.close();

        int max=0;
        int k=0;
        int pos_x=0, pos_y=0;
        while(pos_x<n && pos_y<m){
            dp[k] = map[pos_x][pos_y];
            if(map[pos_x][pos_y+1]>map[pos_x+1][pos_y]){
                pos_y++;
            }else{
                pos_x++;
            }
            k++;
        }
    }
}
