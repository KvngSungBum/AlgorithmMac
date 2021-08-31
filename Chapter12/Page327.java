package Chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class Page327 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//map size
        int k = sc.nextInt();//number of apple
        int[][] map = new int[n][n];
        ArrayList<snakeCoord> snake = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 0;
            }
        }//모든 맵 우선 0으로 초기화

        for(int i=0;i<k;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a-1][b-1] = 1;
        }//입력받은 사과 위치에 따른 사과 배치(사과가 있으면 1)

        int turn_count = sc.nextInt();
        ArrayList<table> turn_table = new ArrayList<>();

        for(int i=0;i<turn_count;i++){
            int second = sc.nextInt();
            String direction = sc.nextLine();

            turn_table.add(new table(second, direction));

        }//setting changing_direction
        sc.close();//입력부 종료

        int headWay=0;//headWay 0:우, 1:하, 2:좌, 3:상
        int time=0;
        int xpos = 0, ypos =0;
        snake.add(new snakeCoord(xpos, ypos));
        while (true) {// 종료 조건: 벽에 부딫히거나 자기 자신에 부딪히는 경우
            boolean endCondition = true;

            //headWay에 따른 방향 분기
            int tailIndex = snake.size()-1;
            if(headWay==0){
                endCondition = endCondition(snake,map,xpos,ypos+1);
                if (endCondition == false) {
                    break;
                }
                if (map[xpos][ypos + 1] == 1) {
                    snake.get(0).ypos = ypos+1;//대가리 이동
                    map[xpos][ypos+1] = 0;//사과 지우기
                    snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                    ypos++;
                }else{
                    snake.get(0).ypos++;//대가리 꼬리 이동
                    for(int i=1;i<snake.size();i++){
                        snake.get(i).xpos = snake.get(i-1).xpos;
                        snake.get(i).ypos = snake.get(i-1).ypos;
                    }
                }
            } else if (headWay == 1) {
                endCondition = endCondition(snake,map,xpos+1,ypos);
                if (endCondition == false) {
                    break;
                }
                if (map[xpos + 1][ypos] == 1) {
                    snake.get(0).xpos = xpos+1;//대가리 이동

                    map[xpos+1][ypos] = 0;//사과 지우기
                    snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                    xpos++;
                } else {
                    snake.get(0).xpos++;//대가리 꼬리 이동
                    for(int i=1;i<snake.size();i++){
                        snake.get(i).xpos = snake.get(i-1).xpos;
                        snake.get(i).ypos = snake.get(i-1).ypos;
                    }
                }
            } else if (headWay == 2) {
                endCondition = endCondition(snake,map,xpos-1,ypos);
                if (endCondition == false) {
                    break;
                }
                if (map[xpos - 1][ypos] == 1) {
                    snake.get(0).xpos = xpos-1;//대가리 이동

                    map[xpos-1][ypos] = 0;//사과 지우기
                    snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                    xpos--;
                } else {
                    snake.get(0).xpos--;//대가리 꼬리 이동
                    for(int i=1;i<snake.size();i++){
                        snake.get(i).xpos = snake.get(i-1).xpos;
                        snake.get(i).ypos = snake.get(i-1).ypos;
                    }
                }
            } else if (headWay == 3) {
                endCondition = endCondition(snake,map,xpos,ypos-1);
                if (endCondition == false) {
                    break;
                }
                if (map[xpos][ypos - 1] == 1) {
                    snake.get(0).ypos = ypos-1;//대가리 이동

                    map[xpos][ypos-1] = 0;//사과 지우기
                    snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                    ypos--;
                } else {
                    snake.get(0).ypos--;//대가리 꼬리 이동
                    for(int i=1;i<snake.size();i++){
                        snake.get(i).xpos = snake.get(i-1).xpos;
                        snake.get(i).ypos = snake.get(i-1).ypos;
                    }
                }
            }

            time++;
            checkDirection(turn_table, time, headWay);
        }
        System.out.println("time = " + time);
    }

    public static boolean endCondition(ArrayList<snakeCoord> snake, int[][] map, int xpos, int ypos) {//여기서의 xpos,ypos는 이동할 칸에 대한 좌표
        boolean result = true;
        if(xpos>=map.length ||ypos>=map.length) result = false;//이동할 칸이 맵을 벗어나는 경우
        //이동할 칸에 뱀의 몸통이 있는 경우
        if(snake.contains(new snakeCoord(xpos,ypos)))
            result = false;
        return result;
    }

    public static int checkDirection(ArrayList<table> turn_table,int time, int headWay) {//매번 time마다 turn_table에서 해당 초에 방향 전환이 되는지 확인 후 headWay전화
        for(int i=0;i<turn_table.size();i++){
            if (turn_table.get(i).second == time) {
                if (turn_table.get(i).direction.equals("D")) {
                    headWay = (headWay+1)%4;
                }else if (turn_table.get(i).direction.equals("L")) {
                    headWay = (headWay-1)%4;
                }
            }else continue;
        }
        return headWay;
    }//초에 맞는 방향이 있을시 방향 반환, 없을 시 steady 반환

    static class table{
        int second;
        String direction;

        public table(int second, String direction) {
            this.second = second;
            this.direction = direction;
        }
    }
    static class snakeCoord{
        int xpos;
        int ypos;

        public snakeCoord(int xpos, int ypos) {
            this.xpos = xpos;
            this.ypos = ypos;
        }
    }
}
