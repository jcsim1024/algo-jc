package fold.leetcode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.text.*;

import javax.crypto.AEADBadTagException;
import javax.naming.spi.DirStateFactory.Result;

import java.io.*;
import java.math.*;
public class BinarySearch {

    public static  void main(String args[]) {
        int[] tab = {-1,0,3,5,9,12};
        
        System.out.println(search(tab, 9));
    }
    public static int search(int[] nums, int target) {
        //dichotomie
        //prendre la longueur divisé par deux
        // taill 0 retour char zero
        // sinon si pas egale changer intervalle et chercher dans moitier tableau.
        Integer result = null;
        Integer a=0;
        Integer b = nums.length-1;
        
        if (b==-1) {
            return -1;
        }
        while (result==null) {
            Integer mid = (a + b)/2;
            if( nums[mid]<target){
                a = mid;
            } else if ( nums[mid] > target) {
                b= mid;
            } else if (target == nums[mid]) {
                result = mid;
            } else {
                result =-1;
            }
        }

        return result;
    }
    
    public static boolean isInside(int a ,int b ,Integer[] tab, int target) {
        return tab[a] <= target && tab[b]>= target; 
        
    }
}
