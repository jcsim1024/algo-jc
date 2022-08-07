package fold.codility;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.out;

public class BinaryGapCountOccurenceofZeros {

    public static  void main(String args[]) {
        //
        var A= new Object[][]{
                new Object[]{1},
                new Object[]{1},
                new Object[]{1},
                new Object[]{Integer.parseInt("10100000000000000000000000001", 2)}
        };
        for (Object[] a: A) {
            long reference=System.nanoTime();
            out.println("\nInput:" + Arrays.deepToString(a)
                    +"\nOutput:"+ new BinaryGapCountOccurenceofZeros().solution((int) a[0]));
            long finishm=System.nanoTime();
            out.println("Time " + ( (double)(finishm-reference)/1000000 )+ "ms");  //in seconds
        }



    }
    public int solution(int B) {

        var A= Integer.toBinaryString(B).toCharArray();
        int N = A.length;
        var nextOccOfEachLetter = new HashMap<Character,Integer>();// keep occurence of each letter
        var dp = new int[N+1];
        var dps = new int[N+1];
        dps[N] = dp[N] =0;

        for (int i = N-1; i >-1 ; i--) {
            dps[i] = 0; //No occurence for current letter

            if(A[i]=='1' ){
                if (nextOccOfEachLetter.containsKey(A[i])) {
                    var j = nextOccOfEachLetter.get(A[i]);
                    dps[i] = max(j-i-1,dp[j+1]);
                }else {
                    dps[i] =0;
                }

            }
            dp[i] = max( dp[i+1], dps[i]);
            nextOccOfEachLetter.put(A[i],i);
        }
        //out.println(Arrays.toString(dp));
        //out.println(Arrays.toString(dps));
        return dp[0];

    }

}
