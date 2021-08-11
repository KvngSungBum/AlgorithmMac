package Chapter12;

import java.util.Scanner;

public class Page321 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        sc.close();

        int n = number.length();
        if(n%2!=0)
            System.out.println("Wrong input");

        int[] score = new int[n];
        for(int i=0;i<n;i++){
            score[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        int[] left = new int[(n/2)];
        int[] right = new int[(n/2)];
        //n=6
        int sumLeft =0;
        int sumRight =0;
        for(int i=0;i<n/2;i++){
            left[i] = score[i];
            sumLeft +=left[i];
        }
        for(int i=0;i<n/2;i++){
            right[i] = score[i+(n/2)];
            sumRight +=right[i];
        }

        if(sumLeft == sumRight)
            System.out.println("Lucky");
        else
            System.out.println("Ready");
    }
}
