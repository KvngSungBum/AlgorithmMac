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
        for(int i=0;i<turn_table.size();i++){
            System.out.print("turn_table.get(i).second = " + turn_table.get(i).second+" ");
            System.out.println("turn_table.get(i).direction = " + turn_table.get(i).direction);
        }

        int headWay=0;//headWay 0:우, 1:하, 2:좌, 3:상
        int time=0;
        int xpos = 0, ypos =0;
        snake.add(new snakeCoord(xpos, ypos));
        boolean endCheck = true;

        while (true) {// 종료 조건: 벽에 부딫히거나 자기 자신에 부딪히는 경우
            //headWay에 따른 방향 분기
            System.out.println("Entered while phrase "+ "headway: "+headWay+" time: "+time+" xpos: "+xpos + " ypos: "+ypos);

            int tailIndex = snake.size()-1;
            if(headWay==0){
                endCheck = endCondition(snake,map,xpos,ypos+1);
                if (endCheck == false) {
                    break;
                }else{
                    if (map[xpos][ypos + 1] == 1) {
                        snakeCoord temp = new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos);
                        snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).ypos = ypos+1;//대가리 이동
                        map[xpos][ypos+1] = 0;//사과 지우기
                        snake.get(tailIndex).xpos = temp.xpos;
                        snake.get(tailIndex).ypos = temp.ypos;
                        ypos++;
                    }else{
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).ypos++;//대가리 꼬리 이동
                        ypos++;
                    }
                }
            } else if (headWay == 1) {
                endCheck = endCondition(snake,map,xpos+1,ypos);
                if (endCheck == false) {
                    break;
                }else{
                    if (map[xpos + 1][ypos] == 1) {
                        snakeCoord temp = new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos);
                        snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).xpos = xpos+1;//대가리 이동
                        map[xpos+1][ypos] = 0;//사과 지우기
                        snake.get(tailIndex).xpos = temp.xpos;
                        snake.get(tailIndex).ypos = temp.ypos;
                        xpos++;
                    } else {
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).xpos++;//대가리 꼬리 이동
                        xpos++;
                    }
                }
            } else if (headWay == 2) {
                endCheck = endCondition(snake,map,xpos-1,ypos);
                if (endCheck == false) {
                    break;
                }else{
                    if (map[xpos - 1][ypos] == 1) {
                        snakeCoord temp = new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos);
                        snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).xpos = ypos-1;//대가리 이동
                        map[xpos-1][ypos] = 0;//사과 지우기
                        snake.get(tailIndex).xpos = temp.xpos;
                        snake.get(tailIndex).ypos = temp.ypos;
                        xpos--;
                    } else {
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).xpos--;//대가리 꼬리 이동
                        xpos--;
                    }
                }
            } else if (headWay == 3) {
                endCheck = endCondition(snake,map,xpos,ypos-1);
                if (endCheck == false) {
                    break;
                }else{
                    if (map[xpos][ypos - 1] == 1) {
                        snakeCoord temp = new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos);
                        snake.add(new snakeCoord(snake.get(tailIndex).xpos, snake.get(tailIndex).ypos));//늘어났으니깐 꼬리 추가
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).ypos = ypos-1;//대가리 이동
                        map[xpos][ypos-1] = 0;//사과 지우기
                        snake.get(tailIndex).xpos = temp.xpos;
                        snake.get(tailIndex).ypos = temp.ypos;
                        ypos--;
                    } else {
                        for(int i=1;i<snake.size();i++){
                            snake.get(i).xpos = snake.get(i-1).xpos;
                            snake.get(i).ypos = snake.get(i-1).ypos;
                        }
                        snake.get(0).ypos--;//대가리 꼬리 이동
                        ypos--;
                    }
                }
            }
            time++;
            headWay = checkDirection(turn_table, time, headWay);

        }
        System.out.println("time = " + (time+1));
    }

    public static boolean endCondition(ArrayList<snakeCoord> snake, int[][] map, int xpos, int ypos) {//여기서의 xpos,ypos는 이동할 칸에 대한 좌표
        boolean result = true;
        snakeCoord temp = new snakeCoord(xpos, ypos);
        if(xpos>=map.length || ypos>=map.length)
            result = false;//이동할 칸이 맵을 벗어나는 경우
        else if(xpos<0 || ypos<0)
            result = false;
        for(int i=0;i<snake.size();i++){
            if(snake.get(i).xpos == temp.xpos && snake.get(i).ypos == temp.ypos){
                System.out.println("crash");
                result = false;
            }
        }
        return result;
    }

    public static int checkDirection(ArrayList<table> turn_table,int time, int headWay) {//매번 time마다 turn_table에서 해당 초에 방향 전환이 되는지 확인 후 headWay전화
        for(int i=0;i<turn_table.size();i++){
            if (turn_table.get(i).second == time) {
                if (turn_table.get(i).direction.equals(" D")) {
                    headWay = (headWay+1)%4;
                }else if (turn_table.get(i).direction.equals(" L")) {
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
