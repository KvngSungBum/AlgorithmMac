package Chapter11;

import java.util.*;

public class Page315 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weight = sc.nextInt();//왜 필요할까....
        HashMap<Integer, Integer> ball = new HashMap<>();

        for(int i=1;i<=n;i++){
            int addValue = sc.nextInt();
            ball.put(i, addValue);
        }
        int result=0;
        for(int i=1;i<=ball.size();i++){
            for(int j=i+1;j<=ball.size();j++){
                if (ball.get(i) != ball.get(j)) {
                    result ++;
                }
            }
        }
        System.out.println(result);
    }
}
