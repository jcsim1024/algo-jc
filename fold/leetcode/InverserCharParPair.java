package fold.leetcode;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class InverserCharParPair {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String res= "";
        for (int i = 1; i < t.length(); i = i+2) {
            res+= (char) t.charAt(i);
            res+=  (char) t.charAt(i-1);
        }
        res+= (t.length()%2 ==1) ? t.charAt(t.length()-1) : "";
        System.out.println(res);

        //OU 

        for (int i = 0; i < t.length(); i = i+2) {

            res+=  (char) ((i+1 < t.length()) ? t.charAt(i+1): (char) 0);
            res+= (char) t.charAt(i);
        }


    }
}