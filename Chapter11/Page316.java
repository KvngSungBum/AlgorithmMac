package Chapter11;

import java.util.*;

public class Page316 {
    public static int solution(int[] food_times, long k){
        int answer = 0;
        int status=0;

        while(status ==k){
            if(food_times[answer]!=0){
                food_times[answer] --;
                answer = (answer+1)% food_times.length;
                status++;
            }
            else{
                answer = (answer+1)% food_times.length;
                status++;
            }

        }
        answer = answer+1;
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int foodNum = sc.nextInt();
        long k = sc.nextLong();

        int[] food_times = new int[foodNum];

        for(int i=0;i<foodNum;i++){
            food_times[i] = sc.nextInt();
        }

        int result = solution(food_times, k);
        System.out.println(result);

    }
}
