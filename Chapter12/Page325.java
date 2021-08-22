package Chapter12;

import java.util.Arrays;
import java.util.Scanner;

public class Page325 {
    public static boolean solution(int[][] key, int[][] lock){
        boolean answer = true;
        int[][] expansion = new int[lock.length+(2*key.length)-2][lock.length+(2*key.length)-2];//확장된 lock

        reset(expansion,key,lock);//expansion 배열 초기화

        for(int i=0;i<expansion.length;i++){
            for(int j=0;j<expansion.length;j++){
                System.out.print(expansion[i][j]);
            }
            System.out.println();
        }//expansion 함수 출력 확인

        int count=0;
        int rotate_count=1;
        //확인 연산하기
        for(int ew = 0;ew<lock.length+key.length-1;ew++){
            for(int eh =0;eh<lock.length+key.length-1;eh++){
                while(rotate_count<=4){
                    for(int i=0;i<key.length;i++){//key랑 expansion더하기
                        for(int j=0;j<key.length;j++){
                            expansion[ew+i][eh+j] = key[i][j]+expansion[ew+i][eh+j];
                        }
                    }
                    answer = check(expansion,key,lock);
                    if(answer == true)
                        return answer;
                    else{
                        reset(expansion,key,lock);
                        key = rotate(key);
                        rotate_count++;
                    }
                }
                rotate_count=1;
            }
        }
        return answer;
    }

    public static boolean check(int[][] expansion, int[][] key,int[][] lock){
        int e = expansion.length;
        int k = key.length;
        int l = lock.length;
        int count =0;
        for(int i = k-1; i<e-k+1;i++){
            int[] temp = new int[l];
            for(int j=0;j<l;j++){
                temp[j] = expansion[i][j];
            }
            if(Arrays.stream(temp)
            .allMatch(a->a==1))
                count++;
        }
        if(count==3)
            return true;
        else
            return false;
    }

    public static void reset(int[][] expansion, int[][] key, int[][] lock){
        for(int i=0;i<expansion.length;i++){
            for(int j=0;j<expansion.length;j++){
                expansion[i][j] = 1;
            }
        }//expansion에 대한 요소 1로 초기화

        for(int i=0;i<lock.length;i++){
            for(int j=0; j<lock.length;j++){
                expansion[i+key.length-1][j+key.length-1] = lock[i][j];
            }
        }//expansion에 원래 lock대입
    }

    public static int[][] rotate(int[][] key){
        int n = key.length;
        int m = key[0].length;
        int[][] result =new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[j][n-i-1] = key[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] key = new int[n][n];
        int[][] lock = new int[m][m];

        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                key[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                lock[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        boolean result = solution(key, lock);
        System.out.println(result);
    }
}
