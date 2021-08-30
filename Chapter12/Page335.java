package Chapter12;

import java.util.HashMap;
import java.util.Scanner;

public class Page335 {
    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int distance = dist[dist.length-1];

        //dist는 오름차순으로 제시됨
        //환형 큐로 만들고
        //인덱스 하나씩 확인하면서 여기서 dist에서 하나씩 꺼내서 다 덮을 수 있는지 확인
        //다 못덮는 경우라면 dist에서 하나 더 꺼내서 확인
        int index = weak[0];
        int count =1;
        int result = dist.length;//처음에는 dis 수 만큼이 result로 반환하고 이후에는 최솟값을 반환
        int weakCount =1;


        //Math.min 사용
        HashMap<Integer, Boolean> checkList = new HashMap<>();
        for(int i=0;i<weak.length;i++){
            checkList.put(weak[i], false);
        }//처음에는 모든 값들 false로 저장(weak요소, false)가 default

        while(weakCount <=weak.length){//사용된
            index = weak[weakCount];//처음에는 1로 시작
            for(int i=0;i<distance;i = (i+1)%n){
                if (checkList.containsKey(i)) {
                    checkList.put(i,true);
                }else continue;
            }
            boolean checkResult = checkHash(checkList, weak);
            if(checkResult = true){
                return weakCount;
            }else weakCount++;

        }

        return answer;
    }

    public static boolean checkHash(HashMap<Integer,Boolean> hash,int[] weak){
        int count =0;
        for(int i=0;i<hash.size();i++){
            if (hash.get(weak[i]) == true) {
                count++;
            }
        }
        if (count == weak.length) {
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weak = new int[15];
        int[] dist = new int[8];

        for(int i=0;i<weak.length;i++){
            weak[i] = sc.nextInt();
        }
        for(int i=0;i<dist.length;i++){
            dist[i] = sc.nextInt();
        }

        int result = solution(n, weak, dist);
        System.out.println(result);
    }
}
