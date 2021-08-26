package Chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class Page332 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//도시 크기
        int m = sc.nextInt();//수익 내는 치킨집 개수
        int[][] chickenMap = new int[n][n];

        ArrayList<coordinate> home = new ArrayList<coordinate>();
        ArrayList<coordinate> shop = new ArrayList<coordinate>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chickenMap[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        sc.close();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(chickenMap[i][j] ==1){//집
                    home.add(new coordinate(i+1,j+1));//양수 좌표값으로 저장
                }else if(chickenMap[i][j] ==2){//가게
                    shop.add(new coordinate(i+1, j+1));//양수 좌표값으로 저장
                }else continue;
            }
        }

        for(int i=0;i<home.size();i++){
            System.out.println("home: " + home.get(i).xpos +" "+ home.get(i).ypos);
        }
        for(int i=0;i<shop.size();i++){
            System.out.println("shop: " + shop.get(i).xpos +" "+ shop.get(i).ypos);
        }
        //치킨집 위치 확인 필요
        //집 위치 확인 필요

    }

    //Math.abs(value) 절댓값 반환
    public int distance(coordinate home, coordinate shop) {
        int distanceX = Math.abs(home.xpos - shop.xpos);
        int distanceY = Math.abs(home.ypos - shop.ypos);
        int totalDistance = distanceX + distanceY;
        return totalDistance;
    }

    static class coordinate{
        int xpos;
        int ypos;

        public coordinate(int x, int y){
            this.xpos =x;
            this.ypos = y;
        }
    }
}
