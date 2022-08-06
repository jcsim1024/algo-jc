package fold.leetcode;

import java.util.*;

import javax.crypto.AEADBadTagException;
import javax.naming.spi.DirStateFactory.Result;

import java.io.*;
import java.math.*;
class BestTimeToBuyStockArray {
      public static  void main(String args[]) {
      
      int[] expected={0,1};
      int[] init = {1,4,5,7};
      System.out.println(Arrays.equals(expected, bestTimeToBuyStockArray(init))); 
      }

      static int[] bestTimeToBuyStockArray(int[] prices ){
            //parcourir le tableau n-1 
            // faire des couples de valeurs
            // comparer leur différence 
            // retourner la diff max
            // si max zero alors retourner zero

            int[] result = null;
            ArrayList<Pair> pairs = new ArrayList<>();
            var tmp = new Pair();
            var max = new Pair();
            for (int i = 0; i < prices.length-1; i++) {
                  
                  
                  for (int j = i+1; j < prices.length; j++) {
                        tmp.diff = prices[j] - prices[i];
                        tmp.where= new int[] {i,j};
                        if (tmp.diff >max.diff) {
                              max =tmp.clone();
                        }      
                  }

                  
            }
            System.out.println(Arrays.toString(max.where)+" " + max.diff);
            return max.where; 
      }
      
      static class Pair implements Cloneable {
            int diff;
            int[] where;
            @Override
            public Pair clone() {
            try {
                  return (Pair) super.clone();
            } catch (CloneNotSupportedException e) {
                  return null;
            }
            }
      }
}