package Chapter12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Page323 {
    public static int solution(String s){
        int answer = s.length();
        for(int size = 1; size<s.length()/2 +1;size++){
            String compressed = "";
            String prev = s.substring(0,size);
            int temp_count =1;

            for(int index = size;index<s.length();index+=size){
                String sub = "";
                for(int k= index; k< index + size;k+=size){
                    if (k < s.length()) {
                        sub += s.charAt(k);
                    }
                }
                if(prev.equals(sub)) temp_count++;
                else{
                    compressed += (temp_count>=2) ? temp_count +prev : prev;
                    sub="";
                    for(int k=index;k<index+size;k++){
                        if(k<s.length()) sub += s.charAt(k);
                    }
                    prev = sub;
                    temp_count=1;
                }
            }
            compressed += (temp_count >= 2) ? temp_count + prev : prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = solution(str);
        System.out.println(result);
    }
}
