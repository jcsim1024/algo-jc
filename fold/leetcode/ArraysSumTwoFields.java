package fold.leetcode;

import java.io.*;
import java.math.*;
import java.util.*;
class ArraysSumTwoFields {
      public static  void main(String args[]) {
        
        int[] nums ={0,1,4,2}; 
        int target = 3;
        // 1 2 
        //1
        //2
        //i+1 
        int[] result = new int[2];
        boolean match=false;
        for (int i=0;  i <  nums.length ; i++ ){
            int col = nums[i];
            for (int j = i+1 ; j<  nums.length ; j++ ){
                match = col + nums[j] == target;
                if ( match ) {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
                
            }
            if (match ) {
                break;}

            
        }
         System.out.println(Arrays.toString(result));   
    }
}