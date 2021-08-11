package Chapter12;

import java.util.Arrays;
import java.util.Scanner;

public class Page322 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str2 = new String[str.length()];

        for(int i=0;i<str.length();i++){
            str2[i] = String.valueOf(str.charAt(i));
        }
        Arrays.sort(str2);

        int sum =0;
        for(int i=0;i<str2.length;i++){
            if((int)str2[i].charAt(0)>=48 && (int)str2[i].charAt(0)<=57){
                sum += Integer.valueOf(str2[i]);
            }
            else{
                System.out.print(str2[i]);
            }
        }
        System.out.print(sum);
    }
}
