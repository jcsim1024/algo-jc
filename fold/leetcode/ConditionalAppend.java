package fold.leetcode;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String urlbar = in.nextLine();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        var res = urlbar;
        if (!urlbar.contains("http://" ) && !urlbar.contains("https://" ) && !urlbar.contains("ftp://" ) )
            res = (urlbar.contains(".") ? "http://":"ftp://") + urlbar;
        
            
        System.out.println(res);
    }
}
