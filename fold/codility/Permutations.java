package fold.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 Task 1

 Java 11
 Programming Language

 Task description
 There are N cities arranged in a row (numbered from 0 to N−1). The K-th city is located at position X[K] and contains A[K] liters of fuel. Getting from city J to city K requires |X[J] − X[K]| liters of fuel.

 Tom is planning a trip. He wants to visit as many cities as possible. Unfortunately, he is limited by the available fuel. To be precise, at the departure time from city J, leaving for city K, the tank should contain at least |X[J] − X[K]| liters of fuel. When Tom visits a city, he refuels his car with all the available fuel at this city. He can refuel at each city just once at most. The fuel tank has an infinite capacity.

 Tom can arbitrarily choose the city from which to start his trip. Tom begins with an empty tank and immediately refuels his car at the starting city. He wants to know how many cities he can visit.

 Write a function:

 class Solution { public int solution(int[] A, int[] X); }

 that, given two arrays A, X consisting of N integers each, returns the maximum number of different cities that Tom can visit.

 Examples:

 1. Given A = [4, 1, 4, 3, 3], X = [8, 10, 11, 13, 100], the function should return 4. One of the possible trips is: 1 → 2 → 0 → 3.

 Tom starts his trip in city number 1 and refuels 1 liter of fuel.
 Then he drives to city number 2 (it costs |10 − 11| = 1 liter of fuel) and refuels 4 liters of fuel.
 Next he drives to city number 0 (it costs |11 − 8| = 3 liters of fuel) and refuels 4 liters of fuel.
 Finally he drives to city number 3 (it costs |8 − 13| = 5 liters of fuel) and refuels 3 liters of fuel.
 Tom has insufficient fuel to reach city number 4.
 The picture describes the first example test.

 2. Given A = [0, 10, 0], X = [1, 2, 3], the function should return 3. Tom can start his trip in city number 1. Then he can visit city number 0 followed by city number 2 (or vice versa). It costs 3 liters of fuel in total.

 3. Given A = [0, 1, 0, 1, 1, 1, 0], X = [1, 2, 3, 4, 5, 6, 7], the function should return 4. Tom can start his trip in city number 3. Then he visits cities 4, 5 and 6, respectively.


 Example test:   ([4, 1, 4, 3, 3], [8, 10, 11, 13, 100])
 WRONG ANSWER (got 0 expected 4)

 Example test:   ([0, 10, 0], [1, 2, 3])
 WRONG ANSWER (got 0 expected 3)

 Example test:   ([0, 1, 0, 1, 1, 1, 0], [1, 2, 3, 4, 5, 6, 7])
 WRONG ANSWER (got 0 expected 4)
 */
public class Permutations {

    // Fonction utilitaire pour échanger deux caractères dans un array de caractères
    private static void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Fonction récursif pour générer toutes les permutations d'une string
    private static void permutations(char[] chars, int currentIndex, List<Object> result)
    {
        if (currentIndex == chars.length - 1) {
            result.add(String.valueOf(chars));
        }

        for (int i = currentIndex; i < chars.length; i++)
        {
            swap(chars, currentIndex, i);
            permutations(chars, currentIndex + 1, result);
            swap(chars, currentIndex, i);
        }
    }

    public static ArrayList<Object> findPermutations(String str) {

        // cas de base
        if (str == null || str.length() == 0) {
            return null;
        }
        var result= new ArrayList<Object>();
        permutations(str.toCharArray(), 0, result);
        return result;
    }

    // génère toutes les permutations d'une string en Java
    public static void main(String[] args)
    {
        var str = new Object[]{"A", "B", "C"};
        //findPermutations(str).forEach(object ->System.out.println(object));
        printPermutationsIterative(str);


        int arr1[] = { 0, 1, 2, 3, 4, 5 };
        Object[] arr2 = { 6, 10, 20, 30, 40, 50, 60 };

        // copies an array from the specified source array
        //System.arraycopy(arr1, 0, arr2, 3, 4);
        swap(arr2,0);
        System.out.println(Arrays.deepToString(arr2));
        //System.out.print(Arrays.deepToString(new int[]{arr2}));
    }

    private static void printPermutationsIterative(Object[] string) {
        int[] factorials = new int[string.length + 1];
        factorials[0] = 1;
        for (int i = 1; i <= string.length; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        for (int i = 0; i < factorials[string.length]; i++) {
            List<Object> onePermutation = new ArrayList<>();
            Object[] temp = string.clone();
            int positionCode = i;
            for (int position = string.length; position > 0; position--) {
                int selected = positionCode / factorials[position - 1];
                onePermutation .add( temp[selected]);
                positionCode = positionCode % factorials[position - 1];
                temp =concatWithArrayCopy( Arrays.copyOfRange(temp,0, selected), Arrays.copyOfRange(temp,selected + 1,temp.length));
                 //System.arraycopy(temp,selected+1,temp,selected,temp.length-selected-1);//je prend temp1 je copy pendant lenght - selected
            }
            System.out.println(onePermutation);

        }
    }
    static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    static void swap(Object[] src,  int  from){
        System.arraycopy(src,from+1,src,from,src.length-from-1);
    }
}
