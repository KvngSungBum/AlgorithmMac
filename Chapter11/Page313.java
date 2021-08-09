package Chapter11;

import java.util.*;

public class Page313 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine(); //문자열로 숫자 입력받음

        int[] source = new int[number.length()]; // 0과 1이 저장되어 있는 배열(int형)
        int count_zero = 0; //0의 개수
        int count_one=0; //1의 개수
        for(int i=0;i<number.length();i++){
            source[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            System.out.println(source[i]);
            if(source[i] == 1){
                count_one++;
            }else if(source[i] == 0){
                count_zero++;
            }
        }//문자열로 입력을 정수형 배열로 전환
        sc.close();

        //정상 입력 확인과 0,1 개수 확인
        System.out.printf("%d %d", count_one, count_zero);
        //Problem Solving

        int zero_count=0;
        int one_count=0;

        int iCheck =0, jCheck=0;
        while(true){
            if(source[iCheck] ==0 && iCheck<source.length){
                while(source[iCheck+jCheck]!=0){
                    jCheck++;
                }
                zero_count++;
                iCheck=jCheck;
            }
            else if(source[iCheck]==1 && iCheck<source.length)
                iCheck++;
            else if(iCheck == source.length)
                break;
        }



        while(true){
            if(source[iCheck] ==1 && iCheck<source.length){
                while(source[iCheck+jCheck]!=0){
                    jCheck++;
                }
                one_count++;
                iCheck=jCheck;
            }
            else if(source[iCheck]==0 && iCheck<source.length)
                iCheck++;
            else if(iCheck == source.length)
                break;
        }

        int result = Math.min(one_count, zero_count);
        System.out.println(result);
    }
}
