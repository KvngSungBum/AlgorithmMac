package Chapter12;

import java.util.Arrays;
import java.util.Scanner;

public class Page323 {
    public static int solution(String s){
        int answer =s.length();

        for(int size =1;size<=s.length()/2;size++){
            StringBuilder compressedStr = new StringBuilder();
            String temp1 = "";
            String temp2 = "";
            int limit = s.length() - (s.length()%size);
            int temp_count=1;

            for(int i=0;i+(2*size)<=limit;i+=size){
                temp1 =s.substring(i,i+size);
                temp2 = s.substring(i+size, i+(2*size));

                if (temp1.equals(temp2)) {
                    temp_count++;
                }else{
                    compressedStr.append(temp_count);
                    compressedStr.append(temp1);
                    temp_count=1;
                }
            }
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
