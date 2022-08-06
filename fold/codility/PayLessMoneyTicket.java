package fold.codility;

import java.util.Arrays;

public class PayLessMoneyTicket {

    public static  void main(String args[]) {

        var sol = new PayLessMoneyTicket().solution(new int[]{1, 2, 4, 5, 7, 29, 30});
        System.out.println(sol);

    }
    public int solution(int[] A) {
        var M = Arrays.stream(A).max().getAsInt() + 30 ;
        int[] dp = new int[M+1];
        int[] day = new int[M];
        for (int i = 0; i < A.length; i++) {
            day[A[i]]=1;
        }

        for (int i = M-1 ; i > -1; i--) {
            if (day[i] ==0){
                dp[i] = dp[i+1];
            } else {
                var min = new int[] { 2+ dp[i+1]
                        ,7+dp[i+7]
                        ,25 + dp[i+30]};
                dp[i] = Arrays.stream(min).min().getAsInt();
            }

        }
        return dp[1];
    }
}
