package fold.leetcode;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class AddCharToString {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String T = in.nextLine();
        String T2 = in.nextLine();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        String res = "";
        for (int i = 0; i < T.length(); i++) {
             res+=(char) ((T.charAt(i)<=T2.charAt(i) ) ? T2.charAt(i): T.charAt(i));
        }
        
        System.out.println(res);
    }
}