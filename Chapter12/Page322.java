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
            //System.out.print(str2[i]);
        }

        Arrays.sort(str2);

        for(int i=0;i<str.length();i++){
            System.out.print(str2[i]);
        }
    }
}
