package fold.codility;

import static java.lang.System.*;

/**
 * import static java.lang.Math.*;
 */
public class BinaryRep {

    public static  void main(String args[]) {

        var sol = new BinaryRep().solution(3,7);
        out.println(sol);

    }
    public int solution(int A,int B) {

        int C = A*B;
        String strC = Integer.toBinaryString(C);
        long res= strC.chars().filter(value -> value=='1').count();
        return (int)res;
    }

}
