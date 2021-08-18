package Chapter12;

import java.util.Scanner;

public class Page323_2 {
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

            for(int index = 0; index +(2*size) <= limit;index++){
                temp1 = s.substring(index, index + size);
                temp2 = s.substring(index + size, index + (2*size));
                if(temp1.equals(temp2)){
                    temp_count++;
                }
                else{
                    if(index !=0){
                        if(temp_count!=1){
                            compressedStr.append(temp_count);
                            contains_num=true;
                        }
                        compressedStr.append(temp1);
                        temp_count=1;
                        indexStatus = index;
                    }
//                    if(temp_count!=1){
//                        compressedStr.append(temp_count);
//                    }
//                    compressedStr.append(temp1);
//                    temp_count=1;
//                    indexStatus = index;
                }
            }
            for(int i=indexStatus+1;i+(2*size)<=s.length();i++){
                temp1 = s.substring(i,i+size);
                temp2 = s.substring(i+size,i+(2*size));
                if(temp1.equals(temp2)) {
                    remainder_count++;
                    if(i+(2*size)==s.length()){
                        if(remainder_count!=1){
                            compressedStr.append(remainder_count);
                        }
                        compressedStr.append(temp1);
                        remainder_count=1;
                    }
                }
                else {
                    if(remainder_count!=1){
                        compressedStr.append(remainder_count);
                    }
                    compressedStr.append(temp1);
                    remainder_count=1;
                }
            }
            System.out.print(indexStatus+" ");
            result = compressedStr.length();
            System.out.println(compressedStr);
            if(contains_num==true){
                answer = Math.min(result, answer);
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
