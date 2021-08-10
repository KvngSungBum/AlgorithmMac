package Chapter11;

import java.util.*;

public class Page313 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine(); //문자열로 숫자 입력받음

        int[] source = new int[number.length()]; // 0과 1이 저장되어 있는 배열(int형)

        for(int i=0;i<number.length();i++){
            source[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }//문자열로 입력을 정수형 배열로 전환
        sc.close();

        int count0=0, count1=0;//count0은 0에서 1로, count1은 1에서 0으로
        if(source[0]==0)
            count0++;
        else
            count1++;

        for(int i=1;i<source.length-1;i++){
            if(source[i] != source[i+1]){
                if(source[i+1] == 1)
                    count1++;
                else
                    count0++;
            }
        }

        int result = Math.min(count0, count1);
        System.out.println(result);
    }
}
