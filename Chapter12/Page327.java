package Chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class Page327 {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//map size
        int k = sc.nextInt();//number of apple
        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 0;
            }
        }//map setting

        for(int i=0;i<k;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a-1][b-1] = 1;
        }//setting apple location

        int turn_count = sc.nextInt();
        ArrayList<table> turn_table = new ArrayList<>();

        for(int i=0;i<turn_count;i++){
            int second = sc.nextInt();
            String direction = sc.nextLine();

            turn_table.set(i, new table(second, direction));
        }//setting changing_direction
    }

    class table{
        int second;
        String direction;

        public table(int second, String direction) {
            this.second = second;
            this.direction = direction;
        }
    }
}
