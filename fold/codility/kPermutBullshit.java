package fold.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example test:   ([0, 1, 0, 1, 1, 1, 0], [1, 2, 3, 4, 5, 6, 7])
 * WRONG ANSWER (got 7 expected 4)
 */
public class kPermutBullshit {

    public static  void main(String args[]) {
        var A= new int[]{0, 1, 0, 1, 1, 1, 0};

        var X= new int[]{1, 2, 3, 4, 5, 6, 7};

        var sol = new kPermutBullshit().solution(A,X);
        System.out.println(sol);

    }
    public int solution(int[] fuel, int[] posi) {
        var res= 0;
        var cities= new kPermutBullshit.City[fuel.length];
        var empty= new kPermutBullshit.City[fuel.length];
        for (int i = 0; i < fuel.length; i++) {
            cities[i]= new kPermutBullshit.City(fuel[i],posi[i]);
        }

        res = printPermutationsIterative( cities);
        return res;
    }

    private int printPermutationsIterative(City[] string) {
        int[] factorials = new int[string.length + 1];
        factorials[0] = 1;
        for (int i = 1; i <= string.length; i++) {
            factorials[i] = factorials[i - 1] * i;
        }


        var max = 0;
        for (int i = 0; i < factorials[string.length]; i++) {
            List<City> onePermutation = new ArrayList<>();
            City[] temp = string.clone();
            var car = new Car();

            int positionCode = i;
            for (int position = string.length; position > 0; position--) {
                int selected = positionCode / factorials[position - 1];

                onePermutation .add( temp[selected]);
                positionCode = positionCode % factorials[position - 1];
                temp =concatWithArrayCopy( Arrays.copyOfRange(temp,0, selected), Arrays.copyOfRange(temp,selected + 1,temp.length));
                //System.arraycopy(temp,selected+1,temp,selected,temp.length-selected-1);//je prend temp1 je copy pendant lenght - selected
            }


            var maxtemp =car.maxCity( onePermutation.toArray(City[]::new));
            //System.out.println(onePermutation + " maxtem:" + maxtemp);
            if (maxtemp>=max)
                max=(int) maxtemp;
        }
        return max;
    }
    static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public static class City implements Cloneable {
        int fuel;
        int position;

        public City(int fuel, int position) {
            this.fuel = fuel;
            this.position = position;
        }

        int distance(kPermutBullshit.City destination){
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
        kPermutBullshit.City city;

        List<kPermutBullshit.City> history=new ArrayList<>();
        boolean reachable(kPermutBullshit.City dest){
            return this.fuel>= this.city.distance(dest);
        }

        boolean reach(kPermutBullshit.City dest){
            if (this.city == null || this.reachable(dest)) {
                if (city!= null){
                this.fuel = fuel - this.city.distance(dest);}
                this.city=dest;
                this.fuel+=dest.fuel;
                this.history.add(dest);
                return true;
            }else{
                return false;
            }

        }
        long maxCity(City[] cities){
            int i =0;
            while (i< cities.length && this.reach(cities[i] )){
                i++;
            }
            return i;

        }


        @Override
        public String toString() {
            return "Car{" +
                    "fuel=" + fuel +
                    ", city=" + city +
                    ", history=" + history +
                    '}';
        }
    }
}
