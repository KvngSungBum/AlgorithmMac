package Chapter11;

import java.util.*;
import java.util.ArrayList;

public class Page316 {
    public static int solution(int[] food_times, long k){
        int answer = 0;
        int status=0;
        int index = 0;
        ArrayList<Integer> check = new ArrayList<>();

        while(status <=k){
            if(food_times[index]!= 0){
                food_times[index]--;
                index = (index+1)% food_times.length;
                answer = index;
                status++;
            }
            else{
                if(!check.contains(index))
                    check.add(index);
                index = (index+1)%food_times.length;
            }
            if(check.size()== food_times.length){
                answer = -1;
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
