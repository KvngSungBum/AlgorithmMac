package Chapter12;

import java.util.Arrays;
import java.util.Scanner;

public class Page323 {
    public static int solution(String s){
        int answer = 0;
        int[] shortest = new int[s.length()];

        for(int cutter=1;cutter<=s.length();cutter++){
            int result =0;
            int temp_count=1;
            StringBuilder compressedStr = new StringBuilder();
            String temp1 = "";
            String temp2 = "";
            int end=0;
            for(int index=0;(index+cutter+cutter)<=cutter*(s.length()/cutter);index+=cutter){
                temp1 = s.substring(index,index+cutter);
                temp2 = s.substring(index+cutter, index+cutter+cutter);
                if(temp1.equals(temp2)){
                    temp_count++;
                }
                else {
                    if (temp_count != 1)
                        compressedStr.append(temp_count);
                    compressedStr.append(temp1);
                    temp_count = 1;
                }
                end = index;
            }
            compressedStr.append(s.substring(end));
            result = compressedStr.length();
            shortest[cutter-1] = result;
        }

        Arrays.sort(shortest);
//        for(int i=0;i< shortest.length;i++){
//            if(shortest[i]!=0){
//                answer = shortest[i];
//                break;
//            }
//        }
        answer = shortest[0];
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = solution(str);
        System.out.println(result);
    }
}
