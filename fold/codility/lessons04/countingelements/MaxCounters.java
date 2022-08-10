package fold.codility.lessons04.countingelements;


import fold.codility.SolutionA;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int [] counters = new int[N];

        int maxCounter = 0; //for the next re-set will know what high score to set all values
        int lastResetCounter = 0; //for setting values that were never explicitly set - at the end

        for(int i=0; i<A.length; i++) {
            if(A[i] <= N) {
                if(counters[A[i]-1] < lastResetCounter) {
                    counters[A[i]-1] = lastResetCounter; //bring it up to last reset value } counters[A[i]-1]++; //store max counter in case need to set all counters to this value on next reset if(counters[A[i]-1] > maxCounter) {
                    maxCounter = counters[A[i]-1];
                }

            }
            else {
                //keep track of last reset counter
                lastResetCounter = maxCounter;
            }
        }
        //set all values to last reset value that was never explicitly changed after last reset
        for(int i=0; i<counters.length; i++) {
            if(counters[i] < lastResetCounter) {
                counters[i]  = lastResetCounter;
            }
        }

        return counters;
    }
    public static  void main(String args[]) {
        int n = 4;
        var streamInt= IntStream.concat( rangeClosed(1, 3),  iterate(5, i->i+3).limit(n));
        var ranged = IntStream.concat(iterate(5, i->i+2).limit(n),streamInt).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        Object[] aaa =ranged.stream().toArray();
        Object[][] A= new Object[][]{
                {new Object[]{"mesage"},  new Object [] { 5, new int [] { 3, 4, 4, 6, 1, 4, 4 }, new int [] { 3, 2, 2, 4, 2 } }}
                ,{new Object[]{""},new Object[] { 3, 8, 9, 7, 6 }, 3,  new Object[]{  9, 7, 6,  3, 8 }}
        };
        executeTest(A);
    }

    private static void executeTest(Object[][] A) {
        for (Object[] a: A) {
            long reference=System.nanoTime();
            var arrayInt1 = toIntAt((Object[]) a[2]);
            int sec = (int) a[1];
            out.println("\nInput:" + Arrays.deepToString(a));

            out.println("\nOutput:"
                    + //Arrays.toString(
                    new SolutionA().solution(sec)
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