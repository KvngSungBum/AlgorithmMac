package Chapter09;

import java.util.*;

public class Page262 {
    static int INF = 10000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        int src = sc.nextInt();
        int[][] map = new int[node][node]; //노드

        for(int i=0;i<node;i++){
            for(int j=0 ; j<node;j++){
                map[i][j] = INF;
            }
        }
        for(int i=0;i<edge;i++){
            int input_src = sc.nextInt();
            int input_dst = sc.nextInt();
            int input_weight = sc.nextInt();
            map[input_src-1][input_dst-1] = input_weight;
        }
        int route_exist = 0;
        int maximum_time =0;
        for(int i=0;i<node;i++){
            if(map[src-1][i] != INF){
                route_exist++;
                if(map[src-1][i] >maximum_time)
                    maximum_time = map[src-1][i];
            }
        }
        System.out.println(route_exist+" "+maximum_time);
    }
}
