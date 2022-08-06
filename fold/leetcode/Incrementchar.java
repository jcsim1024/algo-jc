package fold.leetcode;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Incrementchar {

    public static void main( String[] args) {
        var l = "aaa";
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

            ArrayList<Character>  res = new ArrayList<>() ;
            res.add( l.charAt(0));
            for ( int i =1; i< l.length();i++ ) {
            
            res.add((char)(1 + l.charAt(i)));
            
            
            }
       
       
       
        System.out.println(res);
    }
}
