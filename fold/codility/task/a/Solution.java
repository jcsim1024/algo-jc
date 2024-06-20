package fold.codility.task.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class Solution {


    public int solution(int[] A) {
        int res = 0;

        ArrayList<Integer> deltas = new ArrayList<>();
        int H = 0;
        int V = 0;
        //normalization
        int ones = 0;
        int minusOnes = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1] && ones < 3) {
                deltas.add(1);
                ones++;
                minusOnes = 0;
            }
            if (A[i] < A[i - 1] && minusOnes < 3) {
                deltas.add(-1);
                minusOnes++;
                ones = 0;
            }
        }
        //out.println(deltas);

        if (deltas.size() == 0) return 1;

        //I=0
        if (deltas.get(0) == 1) {
            V++;
        }
        if (deltas.get(deltas.size() - 1) == 1) {
            H++;
        }
        if (deltas.get(0) == -1) {
            H++;
        }
        if (deltas.get(deltas.size() - 1) == -1) {
            V++;
        }

        // 0<i<last-1
        for (int i = 0; i + 1 < deltas.size(); i++) {
            if (("" +
                    deltas.get(i) +
                    deltas.get(i + 1)).equals("1-1")
            ) {
                H++;
            }
            if (("" +
                    deltas.get(i) +
                    deltas.get(i + 1)).equals("-11")) {
                V++;
            }

        }
        //I=last
        return H + V;
    }

    public static void main(String args[]) {
        int n = 4;
        IntStream streamInt = IntStream.concat(rangeClosed(1, 3), iterate(5, i -> i + 3).limit(n));
        List<Integer> ranged = IntStream.concat(iterate(5, i -> i + 2).limit(n), streamInt).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        Object[] aaa = ranged.stream().toArray();
        Object[][] A = new Object[][]{
                {new Object[]{"mesage"}, new Object[]{2, 3, 4, 3, 2, 1, 2, 5}, 3, new Object[]{4}}
                //,{new Object[]{""},new Object[] { 3, 8, 9, 7, 6 }, 3,  new Object[]{  9, 7, 6,  3, 8 }}
        };
        executeTest(A);
    }

    private static void executeTest(Object[][] A) {
        for (Object[] a : A) {
            long reference = System.nanoTime();
            int[] arrayInt1 = toIntAt((Object[]) a[1]);
            int sec = (int) a[2];
            out.println("\nInput:" + Arrays.deepToString(a));

            out.println("\nOutput:"
                    + //Arrays.toString(
                    new Solution().solution(arrayInt1)
                    + " \nExpect:"
                    + Arrays.toString((Object[]) a[3])
            );
            long finishm = System.nanoTime();
            out.println("Time " + ((double) (finishm - reference) / 1000000) + "ms");  //in seconds
        }
    }

    private static int[] toIntAt(Object[] a) {
        return Arrays.stream(a)
                .mapToInt(x -> (int) x)
                .toArray();
    }


}
