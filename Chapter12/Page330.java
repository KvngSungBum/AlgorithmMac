package Chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Page330 {
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int xpos, ypos, gradient, install;
        int[][] wall = new int[n][n];//wall에 0이면 기둥 1이면 보, 2이면 공백

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                wall[i][j] = 2;
            }
        }//우선 모든 칸이 공백이라고 초기화

        for(int i=0;i<build_frame.length;i++){
            boolean possible=false;
            xpos = build_frame[i][0];
            ypos = build_frame[i][1];
            gradient = build_frame[i][2];
            install = build_frame[i][3];

            if(install ==0){
                if(gradient==0){
                    possible = checkCondition(wall,xpos,ypos,gradient,install);
                    if (possible) {
                        wall[xpos][ypos] = 0;
                    }
                } else if (gradient == 1) {
                    possible = checkCondition(wall, xpos, ypos, gradient, install);
                    if (possible) {
                        wall[xpos][ypos] = 1;
                    }
                }
            } else if (install == 1) {
                if (gradient == 0) {
                    possible = checkCondition(wall,xpos,ypos,gradient,install);
                    if (possible) {
                        wall[xpos][ypos] = 2;
                    }
                } else if (gradient == 1) {
                    possible = checkCondition(wall,xpos,ypos,gradient,install);
                    if (possible) {
                        wall[xpos][ypos] = 2;
                    }
                }
            }
        }

        ArrayList<coord> ans = new ArrayList<>();
        for(int i=0;i<wall.length;i++){
            for(int j=0;j<wall.length;j++){
                if (wall[i][j] != 2) {
                    ans.add(new coord(i, j, wall[i][j]));
                }
            }
        }

        for(int i=0;i<ans.size();i++){
            System.out.println("["+ans.get(i).answerX+", "+ans.get(i).answerY+", "+ans.get(i).answerGradient+" ]");
        }

        return answer;
    }

    public static boolean checkCondition(int[][] wall, int xpos, int ypos, int gradient, int install){//설치할 위치의 xpos, ypos
        boolean result = false;
        if (install == 0) {
            if (gradient == 0) {//기둥 설치
                if(xpos==0 && ypos==0){
                    result = true;
                }else if(xpos-1>=0 && ypos-1 >=0){
                    if(wall[xpos][ypos-1]== 0 || wall[xpos-1][ypos]==1 || wall[xpos][ypos]==1){//설치 가능한 경우(아래에 기둥이 있거나 왼쪽 좌표에 보가 있는 경우, 설치할 위치에 보가 있는 경우)
                        if(wall[xpos-1][ypos-1]==2)
                            result = false;//설치할 위치에 보가 있지만 보를 받치는 기둥이 없는 경우 false 반환
                        result = true;
                    }else{//설치 불가능한 경우
                        result = false;
                    }
                }else{
                    result =false;
                }
            } else if (gradient == 1) {//보 설치
                if(xpos==0){
                    result =false;
                }else if((xpos-1>=0 && ypos-1>=0) || (xpos+1<wall.length && ypos+1<wall.length)){
                    if((wall[xpos-1][ypos] == 1 &&wall[xpos+1][ypos]==1) || wall[xpos][ypos-1]==0){//설치 가능한 경우(설치할 위치의 양측에 보가 존재하거나 설치할 위치 아래에 기둥이 있는 경우)
                        result = true;
                    }else{//설치 불가능한 경우
                        result = false;
                    }
                }
                else{
                    return false;
                }
            }else System.out.println("gradient error");
        } else if (install == 1) {
            if(gradient == 0){//기둥 삭제
                if((xpos-1>=0 && ypos-1>=0) || (xpos+1<wall.length && ypos+1<wall.length)){
                    if(wall[xpos][ypos+1]==2){//삭제 가능한 경우
                        result = true;
                    }else if(wall[xpos][ypos+1]==1 && wall[xpos-1][ypos]==1){
                        result = true;
                    }else{//삭제 불가능한 경우
                        result = false;
                    }
                }
            } else if (gradient == 1) {//보 삭제
                if(xpos-1>=0 && ypos-1 >=0){
                    if(wall[xpos][ypos-1]==0){//삭제 가능한 경우(지우는 위치에 기둥이 있으면 가능,
                        result = true;
                    }else{//삭제 불가능한 경우
                        if(wall[xpos-1][ypos-1]==0 ||wall[xpos+1][ypos-1]==0)
                            result = true;
                        result = false;
                    }
                }
            }else System.out.println("gradient error");
        } else System.out.println("installation error");

        return result;
    }

    public static class coord{
        int answerX;
        int answerY;
        int answerGradient;

        public coord(int answerX, int answerY, int answerGradient) {
            this.answerX = answerX;
            this.answerY = answerY;
            this.answerGradient = answerGradient;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] build_frame = new int[4][8];//10개만 입력받는다고 가정
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                build_frame[i][j]= sc.nextInt();
            }
            sc.nextLine();
        }
        sc.close();

        int[][] result;
        result = solution(n, build_frame);
        for(int i =0;i<4;i++){
            for(int j=0;j<10;j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
