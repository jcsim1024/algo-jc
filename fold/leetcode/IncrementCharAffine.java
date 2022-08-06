package fold.leetcode; /**
 * 
 * You have to encode an ASCII text using an affine function in a finite field.
A to Z are coded in 0 to 25, a space is 26, a . is 27 and a , is 28.
We work modulo 29.
You have to print the encoded text by x↦ax+b mod 29*





Line 1: a and b
Line 2: The length of the text
Line 3: The text
Sortie
The encoded text
Contraintes
Exemple

Entrée
1 3
5
HELLO

Sortie
KHOOR

 */

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class IncrementcharAffine {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = 1;
        int b = 3;
        int length = 5;
        
        String text = "HELLO";
        String alp= "ABCDEFGHIJKLMNOPQRSTUVWXYZ .,";
        String res="";
        for (int i = 0; i< text.length(); i++) {
            var tempChar = text.charAt(i);
            var charProjected = (int) alp.indexOf(tempChar);
            var translatedIndex = (charProjected*a+b)%alp.length();
            var invertedProjectionChar = (char) alp.charAt(translatedIndex);
            res+=invertedProjectionChar;
            //res += (char) alp.charAt((alp.indexOf(text.charAt(i))*a+b)%29);
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(res);
    }
}