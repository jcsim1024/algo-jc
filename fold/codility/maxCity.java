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
public class maxCity {

    public static  void main(String args[]) {

        var sol = new maxCity().solution(new int[]{4,100,1},
                new int[]{8,2,1});
        System.out.println(sol);

    }
    public int solution(int[] fuel, int[] posi) {
        var cities= new City[fuel.length];
        var empty= new City[fuel.length];
        for (int i = 0; i < fuel.length; i++) {
            cities[i]= new City(fuel[i],posi[i]);
        }
        System.out.println(Arrays.deepToString(cities));
        combinationPossible(cities,empty,0,fuel.length,0,fuel.length);
        return 0;
    }
    public class City implements Cloneable {
        int fuel;
        int position;

        public City(int fuel, int position) {
            this.fuel = fuel;
            this.position = position;
        }

        int distance(City destination){
            return Math.abs(this.position- destination.position);
        }

        @Override
        public String toString() {
            return "City{" +
                    "fuel=" + fuel +
                    ", position=" + position +
                    '}';
        }
    }
    class Car{
        int fuel;
        City city;

        List<City> history=new ArrayList<>();
        boolean reachable(City dest){
            return this.fuel>= this.city.distance(dest);
        }

        boolean reach(City dest){
            if (this.reachable(dest)) {
                this.fuel = fuel - this.city.distance(dest);
                this.city=dest;
                this.fuel+=dest.fuel;
                this.history.add(dest);
                return true;
            }else{
                return false;
            }

        }


    }
    static void  combinationPossible(City[] cities,City[] plans,
                             int Start_Element, int End_Element, int Array_Index,int r){

        if (Array_Index == r) {
            for (int x=0; x<r; x++) {
                System.out.print(plans[x]);
            }
            System.out.println(", ");
            return;
        }

        for (int y=Start_Element; y<=End_Element && End_Element-y+1 >= r-Array_Index; y++) {
            plans[Array_Index] = cities[y];
            maxCity.combinationPossible(cities, plans, y+1, End_Element, Array_Index+1, r);
        }
    }


}
