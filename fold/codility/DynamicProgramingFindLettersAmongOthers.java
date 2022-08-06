package fold.codility;

import java.util.HashMap;

import static java.lang.Math.min;
import static java.lang.System.out;

public class DynamicProgramingFindLettersAmongOthers {

    public static  void main(String args[]) {
        //abcdabcdabcd
        //
        var sol = new DynamicProgramingFindLettersAmongOthers().solution("abadbabbcac");
        out.println(sol);


    }
    public int solution(String B) {
        var A= B.toCharArray();
        int N = A.length;
        var nextOccOfEachLetter = new HashMap<Character,Integer>();// keep occurence of each letter
        var dp = new int[N+1];
        var dps = new int[N+1];
        dps[N] = dp[N] =0;
        for (int i = N-1; i >-1 ; i--) {
            dps[i] = N-i; //No occurence for current letter
            if(nextOccOfEachLetter.containsKey(A[i]) ){
                var j = nextOccOfEachLetter.get(A[i]);
                dps[i] = min( dps[j],dp[j+1]);
            }
            dp[i] = min(1 + dp[i+1], dps[i]);
            nextOccOfEachLetter.put(A[i],i);
        }
        return dp[0];
    }

}
