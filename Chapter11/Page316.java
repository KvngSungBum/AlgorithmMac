package Chapter11;

import java.util.*;

public class Page316 {
    public static int solution(int[] food_times, long k){
        int answer = 0;
        int status=0;
        int index = 0;
        int flag = 0;

        while(true) {
            if (food_times[index] != 0 && status != k) {
                food_times[index]--;
                index = (index + 1) % food_times.length; // 순환시키기 위함
                status++;
                flag = 0;
            } else if (food_times[index] == 0 && status != k) {
                index = (index + 1) % food_times.length; // 순환시키기 위함
                for (int i = 0; i < food_times.length; i++) {
                    if (food_times[i] != 0)
                        flag = 1;
                }
                if(flag==0){
                    answer = -1;
                    break;
                }
            }
            else{
                answer = (index+1)%3;
                break;
            }
        }

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
