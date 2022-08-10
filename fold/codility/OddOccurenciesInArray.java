package fold.codility;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class OddOccurenciesInArray {

    public int solutionB(int[] A) {
        //Arrays
                //.stream(A).collect(Collectors.toMap(i->i,i->1,(a,b)->(a+b))));

        Map.Entry<Integer,Integer> mapedValues = Arrays
                .stream(A)
                .boxed()
                .collect(Collectors.toMap(i->i,i->1,(a,b)->(a+b)))
                .entrySet().stream().filter(entrySet-> entrySet.getValue()%2 == 1)
                .findFirst()
                .get();
        return mapedValues.getKey();
    }

    public int solution(int[] A) {
        HashMap <Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();

        for(int i=0; i<A.length; i++) {
            if(occurrencesMap.containsKey(A[i])) {
                int occurrences = occurrencesMap.get(A[i]);
                occurrences++;
                occurrencesMap.put(A[i], occurrences); //increment occurrence counter and store it
            }
            else {
                occurrencesMap.put(A[i], 1); //1st occurrences of this value
            }
        }

        Set<Integer> keySet = occurrencesMap.keySet();

        for(int currentKey : keySet) {
            int occurrences = occurrencesMap.get(currentKey);

            //if occurs odd number of times, we found the unpaired value - no need to continue checking
            if(occurrences % 2 != 0) return currentKey;
        }
        //should never get to here
        throw new RuntimeException("shouldn't get to here - should've return unpaired value by now");
    }

    public static  void main(String args[]) {
        int n = 5000000;
        var streamInt= IntStream.concat( rangeClosed(1, 1),  iterate(5, i->i+2).limit(n));
        var ranged = IntStream.concat(iterate(5, i->i+2).limit(n),streamInt).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        Object[] aaa =ranged.stream().toArray();
        Object[][] A= new Object[][]{
                {new Object[]{"mesage"},new Object[] { 9, 3, 9, 3, 9, 7, 9 },  7 }
                ,{new Object[]{"long int"}, aaa ,  1 }


        };
        executeTest(A);
    }

    private static void executeTest(Object[][] A) {
        for (Object[] a: A) {
            long reference=System.nanoTime();
            var arrayInt1 = toIntAt((Object[]) a[1]);
            int sec = (int) a[2];
            Object[] sol= (a[2] instanceof Object[])?(Object[]) a[2]: new Object[]{a[2]};
            out.println("\nInput:" + Arrays.deepToString(a));

            out.println("\nOutput:"
                    + //Arrays.toString(
                            new OddOccurenciesInArray().solutionB(arrayInt1)
                    + " \nExpect:"
                    + Arrays.toString(sol)
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
