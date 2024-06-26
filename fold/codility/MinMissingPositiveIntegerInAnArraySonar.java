package fold.codility;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

/** search through an unsorted array the first minimum missign value
 * has to be efficient
 * */
public class MinMissingPositiveIntegerInAnArraySonar {

    public static  void main(String args[]) {
        int n = 4000000;
        var streamInt=IntStream.concat( rangeClosed(1, 3),  iterate(5, i->i+3).limit(n));
        var ranged = IntStream.concat(iterate(5, i->i+2).limit(n),streamInt).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        Object[] aaa = ranged.toArray();
        Object[][][] A= new Object[][][]{
                {new Object[]{1,2,8,7,5,6},new Object[]{3}},
                {aaa,new Object[]{4}},
                {new Object[]{1},new Object[]{2}}
        };
        executeTest(A);
    }

    private static void executeTest(Object[][][] A) {
        for (Object[][] a: A) {
            long reference=System.nanoTime();
            var b = Arrays.stream(a[0])
                    .mapToInt(x-> (int) x)
                    .toArray();
            out.println("\nInput:" + Arrays.deepToString(a));

            out.println("\nOutput:"+ new MinMissingPositiveIntegerInAnArraySonar()
                    .solutionAa(b) // here
                            + " ,Expected:" + Arrays.toString(a[1])
                    );
            long finishm=System.nanoTime();
            out.println("Time " + ( (double)(finishm-reference)/1000000 )+ "ms");  //in seconds
        }
    }

    /**
     * 26sec
     * @param A
     * @return
     */
    public int solutionAc(int[] A) {
        SortedSet<Integer> set = IntStream
                .rangeClosed(1, A.length+1)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));
        for (Integer a :
                A) {
            set.remove(a);
        }
        return set.first();
    }

    /**
     *  8 sec
     * @param A
     * @return
     */
    public int solutionAb(int[] A) {
        LinkedHashSet<Integer> set = IntStream
                .rangeClosed(1, A.length+1)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        for (Integer a :
                A) {
            set.remove(a);
        }
        return set.stream().findFirst().get();
    }

    /**
     * 4sec
     * fastest
     * @param A
     * @return
     */
    public int solutionAa(int[] A) {
        boolean[] pigeonHole = new boolean[A.length+1];
        for (int a : A) {
            if (a > 0 && a < A.length+1) {
                pigeonHole[a]=true;
            }
        }
        int first = 1;
        for (int i =1; i< pigeonHole.length ; i++) {
            if (!pigeonHole[i]) {
                first = i;
                break;
            }
        }
        return first;
    }

        public int solutionB(int[] A) {

        ArrayList<int[]> inters = new ArrayList<>();
        inters.add(new int[]{0,0});
        for (int i = 0; i < A .length; i++) {
            var val =A[i];

            if(val >=1){
                int n = inters.size();
                for (int j = 0; j < inters.size(); j++) {
                    if(inters.get(j)[0] > val+1){
                        inters.add(j,new int[]{val,val});
                        break;

                    }
                    else if(inters.get(j)[0] == val+1)
                    {
                        inters.get(j)[0]=val;
                        if( j>0 && inters.get(j-1)[1]== val-1 ){
                            inters.get(j-1)[1] = inters.get(j)[1];
                            inters.remove(j);
                        }
                        break;
                    }
                    else if (inters.get(j)[0] <= val && inters.get(j)[1] >= val)
                    {break;}
                    else if(inters.get(j)[1] == val-1)

                    {
                        inters.get(j)[1] = val;
                        if( j<inters.size()-1 && inters.get(j+1)[0]== val+1 ){
                            inters.get(j)[1] = inters.get(j+1)[1];
                            inters.remove(j+1);
                        }
                        break;
                    }
                    if( inters.size() == j+1 && inters.get(j)[1]< val ){
                        inters.add(new int[]{val, val});
                        break;

                    }

                }


            }
        }
        out.println("Inters :"+ Arrays.deepToString(inters.stream().toArray()));
        return inters.stream().findFirst().orElse(new int[]{0,0})[1]+1;
    }
    // 13 sec ~12
    public int solution(int[] A) {
            var x = 1;
            var sortedpositives = Arrays.stream(A).distinct().filter(value -> value>0).sorted().toArray();
            for (int i :
                    sortedpositives) {
                if (x == i) {
                    x+=1;
                } else {
                    break;
                }
            }
            return x;
    }
    

    //14sec
    public int solutionC(int[] A) {
        AtomicInteger x = new AtomicInteger(1);

        Arrays.stream(A).distinct().filter(value -> value>0)
                .sorted()
                .takeWhile(value -> {
            return value == x.get();
        })
                .forEach(value -> x.getAndIncrement());
        return x.get();
    }
}
