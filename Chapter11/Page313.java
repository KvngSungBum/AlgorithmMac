package Chapter11;

import java.util.*;

public class Page313 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = new String();
        number = sc.nextLine();
        int[] source = new int[number.length()]; // 0과 1이 저장되어 있는 배열
        int count_zero = 0;
        int count_one=0;
        for(int i=0;i<number.length();i++){
            source[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            System.out.println(source[i]);
            if(source[i] == 1){
                count_one++;
            }else if(source[i] == 0){
                count_zero++;
            }
        }
        sc.close();
        int result = 0;
        //1의 개수가 0의 개수보다 작은경우 : 1을 뒤집는다
        if(count_one<count_zero){
            for(int i=0;i<source.length;i++){
                 if(source[i]==1){
                     source[i]=0;
                     if(source[i+1]==1){
                         source[i+1]=0;
                     }
                 }
            }
        }
        //Problem Solving
    }
}
