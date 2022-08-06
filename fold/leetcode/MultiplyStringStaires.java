package fold.leetcode;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class MutiplyStringStaires {

    public static void main(String args[]) {
        int n = 3;

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        var res ="";
        if (n >0){
            
            
            res+= "   ".repeat(n) + "__";

            for (int i = 1; i <= n; i+=1) {
                res+= "\n" + "   ".repeat(n-i) + "__|" ;
            }
        }
        System.out.println(res);

    }
}