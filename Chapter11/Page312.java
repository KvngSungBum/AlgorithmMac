package Chapter11;

import java.util.Scanner;

public class Page312 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        sc.close();

        char[] number2 = new char[number.length()];
        int[] arr = new int[number.length()];

        //입력받은 문자열 int형 배열로
        number2 = number.toCharArray();
        for(int i=0;i<number2.length;i++){
            arr[i] = number2[i] -'0';
        }
        
        int result = calculate(arr);
        System.out.println(result);

    }

    private static int calculate(int[] arr) {
        int result = arr[0];
        if (arr[0] == 1 || arr[0] == 2) {
            result = result +arr[1];
            for(int i=1;i<arr.length-1;i++){
                if(arr[i] == 0){
                    result = result + arr[i + 1];
                }else{
                    if(arr[i+1]==0){
                        result = result + arr[i+1];
                    }else{
                        result = result * arr[i + 1];
                    }
                }
            }
        }else{
            for(int i=0;i<arr.length-1;i++){
                if(arr[i] == 0){
                    result = result + arr[i + 1];
                }else{
                    if(arr[i+1]==0){
                        result = result + arr[i+1];
                    }else{
                        result = result * arr[i + 1];
                    }
                }
            }
        }
        return result;
    }
}
