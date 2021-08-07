package Chapter11;

import java.util.*;

public class Page314 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        for(int i=0; i < n;i++){
            money[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(money);

        ArrayList<Integer> available = new ArrayList<>();
        ArrayList<Integer> minimumAvailable = new ArrayList<>();


        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                //배열 값 추가
                if(!available.contains(money[i]))
                    available.add(money[i]);
                //배열 합 추가
                int avaNum = available.get(i) + money[j];
                if(!available.contains(avaNum)){
                    available.add(avaNum);
                }
            }
        }
        Collections.sort(available);
        int max = available.get(available.size() - 1);

        for(int i=1;i<max;i++){
            if(!available.contains(i)){
                minimumAvailable.add(i);
            }
        }
        Collections.sort(minimumAvailable);
        System.out.println(minimumAvailable.get(0));
//        for(int i=0;i<available.size();i++){
//            System.out.println(available.get(i));
//        }
    }
}
