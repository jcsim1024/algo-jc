package fold.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class Spooktober {


    public int solution(int[] A) {
        int [] dp = new int[A.length];
        int[] dps = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            dp[i]= (dp[i-1] +A[i-1])/2 ;
        }

        int maxDps= dp[A.length-1] + dps[A.length-1] + A[A.length-1];

        for (int j = A.length-2; j >= 0; j--) {
            dps[j]= (dps[j+1] +A[j+1])/2 ;
            maxDps= Math.max(dp[j] + dps[j] + A[j], maxDps);

        }

        return maxDps;
    }

    public static  void main(String args[]) {
        int n = 4;
        IntStream streamInt= IntStream.concat( rangeClosed(1, 3),  iterate(5, i->i+3).limit(n));
        List<Integer> ranged = IntStream.concat(iterate(5, i->i+2).limit(n),streamInt).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        Object[] aaa =ranged.stream().toArray();
        Object[][] A= new Object[][]{
  //              {new Object[]{"Case nominal"},new Object[] { 2, 3, 1, 3 }, 3,  new Object[]{  5 }}
//,                {new Object[]{"Case limit right "},new Object[] { 15, 3, 1, 3 }, 3,  new Object[]{  17 }}
//,
                {new Object[]{"Case double"},new Object[] { 2, 2, 2, 1 }, 3,  new Object[]{  4 }}
                //,{new Object[]{""},new Object[] { 3, 8, 9, 7, 6 }, 3,  new Object[]{  9, 7, 6,  3, 8 }}
        };
        executeTest(A);
    }

    private static void executeTest(Object[][] A) {
        for (Object[] a: A) {
            long reference=System.nanoTime();
            int[] arrayInt1 = toIntAt((Object[]) a[1]);
            int sec = (int) a[2];
            out.println("\nInput:" + Arrays.deepToString(a));

            out.println("\nOutput:"
                    + //Arrays.toString(
                            new Spooktober().solution(arrayInt1)
                    + " \nExpect:"
                    + Arrays.toString((Object[]) a[3])
            );
            long finishm=System.nanoTime();
            out.println("Time " + ( (double)(finishm-reference)/1000000 )+ "ms");  //in seconds
        }
    }

    private static int[] toIntAt(Object[] a) {
        return Arrays.stream(a)
                .mapToInt(x -> (int) x)
                .toArray();
    }


}
