package Chapter12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Page323 {
    public static int solution(String s){
        int answer = s.length();
        for(int size = 1; size<=s.length()/2;size++){
            StringBuilder compressedStr = new StringBuilder();
            int limit = s.length() - (s.length()%size);
            int temp_count =1;
            int remainder_count=1;
            int result =0;
            int indexStatus =0;
            String temp1 = "";
            String temp2 = "";
            boolean contains_num = false;
            ArrayList<String> same = new ArrayList<>();

            if(s.substring(0,size).equals(s.substring(size,size+size))){//0부터 같아야지만 진행
                String temp="";
                for(int i=0;i+size<=s.length();i+=size){
                    same.add(s.substring(i, i + size));
                }
                temp=same.get(0);
                for(int i=1;i<same.size();i++){
                    if (same.get(i).equals(temp)) {
                        temp_count++;
                    }else{
                        if(temp_count!=1)
                            compressedStr.append(temp_count);
                        compressedStr.append(same.get(i));
                        temp_count=1;
                    }
                    temp=same.get(i);
                }
                System.out.println(compressedStr);
                answer = Math.min(answer, compressedStr.length());
            }

//            System.out.println(size);
//            for(int i=0;i<same.size();i++){
//                System.out.print(same.get(i)+" ");
//            }
//            System.out.println();
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
