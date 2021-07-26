package Chapter11;

import java.util.*;

public class Page311 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fear = new int[n];

        for(int i=0;i<n;i++){
            fear[i] = sc.nextInt();
        }
        sc.close();
        //sort
        for(int i=0;i<fear.length;i++){
            for(int j=0;j<fear.length-i-1;j++){
                if(fear[j]>fear[j+1]){
                    int temp = fear[j+1];
                    fear[j+1] = fear[j];
                    fear[j]=temp;
                }
            }
        }
        int remainder =0;int result =0;
        for(int i=0;i<n;i++){
            remainder ++;
            if(fear[i] == remainder){
                result++;
                remainder=0;
            }
        }
        System.out.println(result);
    }

}
