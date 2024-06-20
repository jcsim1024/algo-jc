package fold.codility.task.b;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class Solution {


    public int solution(String A) {
        int ops= 0;
        var a = A.chars().toArray();
        var indexfirst1=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]=='1') {
                indexfirst1 = i;
                break;
            }
        }

        for (int i = a.length-1; i >= indexfirst1 ; i--) {
            if(a[i] == '0'){
                ops++;
            }else {
                ops+=2;
            }
        }
        return ops;
    }

    public static  void main(String args[]) {
        int n = 4;
        IntStream streamInt= IntStream.concat( rangeClosed(1, 3),  iterate(5, i->i+3).limit(n));
        List<Integer> ranged = IntStream.concat(iterate(5, i->i+2).limit(n),streamInt).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        Object[] aaa =ranged.stream().toArray();
        Object[][] A= new Object[][]{
                {new Object[]{"mesage"},new Object[] { 3, 8, 9, 7, 6 }, 3,  new Object[]{  9, 7, 6,  3, 8 }}
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
                            new Solution().solution("arrayInt1")
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
