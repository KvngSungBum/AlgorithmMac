package Chapter12;

import java.util.Scanner;

public class Page330 {
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] build_frame = new int[4][10];//10개만 입력받는다고 가정
        for(int i=0;i<4;i++){
            for(int j=0;j<10;j++){
                build_frame[j][i]= sc.nextInt();
            }
            sc.nextLine();
        }

        int[][] result = new int[4][10];
        result = solution(n, build_frame);
        for(int i =0;i<4;i++){
            for(int j=0;j<10;j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
