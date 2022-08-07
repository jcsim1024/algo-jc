package fold.codility;

import static java.lang.System.*;

/**
 * import static java.lang.Math.*;
 *
 * count numbers of 1 in binary rep of number (negativ or positiv
 */
public class BinaryRepSonar {

    public static  void main(String args[]) {

        var sol = new BinaryRepSonar().solution(3,7);
        out.println(sol);

    }
    public int solution(int A,int B) {

        int C = A*B;
        String strC = Integer.toBinaryString(C);
        long res= strC.chars().filter(value -> value=='1').count();
        return (int)res;
    }

}
