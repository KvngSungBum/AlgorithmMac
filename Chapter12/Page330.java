package Chapter12;

import java.util.Scanner;

public class Page330 {
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int xpos, ypos, gradient, install;
        int[][] wall = new int[n][n];//wall에 0이면 기둥 1이면 보, 2이면 공백
        boolean installCodition;
        //build_frame으로부터 데이터 읽어오기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                wall[i][j] = 2;
            }
        }//우선 모든 칸이 공백이라고 초기화

        for(int i=0;i< build_frame.length;i++){
            xpos = build_frame[i][0];
            ypos = build_frame[i][1];
            gradient = build_frame[i][2];
            install = build_frame[i][3];

            if(gradient == 0){//기둥 설치
                if(install==0){//삭제냐
                    //여기에서 조건확인
                    if(checkCondition(wall, xpos, ypos, gradient, install)){
                        //삭제 진행
                    }else{
                        continue;
                    }
                }else if(install == 1){//설치냐
                    //여기에서 조건확인
                    if (checkCondition(wall, xpos, ypos, gradient, install)) {
                        //설치 진행
                    }else{
                        continue;
                    }
                }

            }else if(gradient == 1){//보 설치
                if(install==0){//삭제냐
                    //여기에서 조건확인
                    if(checkCondition(wall, xpos, ypos, gradient, install)){
                        //삭제 진행
                    }else{
                        continue;
                    }
                }else if(install == 1){//설치냐
                    //여기에서 조건확인
                    if (checkCondition(wall, xpos, ypos, gradient, install)) {
                        //설치 진행
                    }else{
                        continue;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean checkCondition(int[][] wall,int xpos, int ypos, int gradient ,int install){//map에서 install에 따라서 설치 및 삭제가 가능한지 조건 확인 후 여부 반환
        boolean possible = false;
        if(gradient == 0){//기둥 설치 또는 삭제
            if(install == 0){//기둥 삭제

            }else if(install == 1){//기둥 설치
                if(ypos == 0){//바닥 위에 기둥 설치하는지
                    possible = true;
                }else if(ypos>0){//바닥 외에 기둥 설치하는 경우
                    if(wall[xpos-1][ypos]==1 || wall[xpos][ypos]==1 || wall[xpos][ypos-1]==0){//좌 우 중에 보가 존재하거나 밑에 기둥이 존재한다면
                        possible = true;
                    }
                }
            }
        }else if(gradient == 1){//보 설치 또는 삭제
            if(install == 0){//보 삭제

            }else if(install == 1){//보 설치
                if(wall[xpos-1][ypos]==0 || wall[xpos-1][ypos] == 1 || (wall[xpos-1][ypos] == 1 && wall[xpos+1][ypos]==1)){
                    possible = true;
                }
            }
        }
        return possible;
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
        sc.close();

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
