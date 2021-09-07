package ETC;

import java.util.ArrayList;
import java.util.Scanner;

public class classWave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_size = sc.nextInt();
        int[] test = new int[test_size];

        for(int i=0;i<test_size;i++){
            test[i] = sc.nextInt();
        }
        sc.close();
        //입력부 종료

        //처리부
        //P[N] = P[N-1] + P[N-5] (단 N은 6부터 적용됨)
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<test_size;i++){
            ArrayList<Integer> waveList = new ArrayList<>();
            waveList.add(1);//index =0
            waveList.add(1);//index =1
            waveList.add(1);//index =2
            waveList.add(2);//index =3
            waveList.add(2);//index =4
            for (int j = 5; j < test[i]; j++) {
                waveList.add(waveList.get(j - 1) + waveList.get(j - 5));
            }
            result.add(waveList.get(test[i]-1));
        }

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }


    }
}
