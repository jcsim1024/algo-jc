package fold.leetcode; /**
public //The objective is to mix a sentence into n blocks.

Go through the sentence placing one character into each block in turn. After the last block, go back to the first block and repeat until the end of the sentence.

At the end, all blocks should have the same length, so use 'x' to fill any short blocks.

Example:
Sentence:    AbcdEfghIjk

    Block 1: A          Block 2: b
    Block 1: Ac         Block 2: bd
    Block 1: AcE        Block 2: bdf
    ...                 ...
    Block 1: AcEgIk     Block 2: bdfhj

Complete with 'x':
    Block 1: AcEgIk     Block 2: bdfhjx

Final state: AcEgIk bdfhjx

Une chocolatine !
Is text important ? 3

Ittmrn? se pttx  xioa x **/
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class AdvencedConditionalAppend {

    public static void main(String args[]) {
        
        int n = 3;
        
        String sentence = "Is text important ?";

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.err.println(sentence +" " + n);
        
        String[] b = new String[n];
        Arrays.fill(b, "");
        ArrayList<String> bb = new ArrayList<>(Collections.nCopies(n, ""));
        for (int i = 0; i < sentence.length(); i+=n) {
            for (int j = 0; j < n; j++) {
                var sent = ((i+j>=sentence.length()) ? "x" : sentence.charAt(i+j));
                
                bb.set(j, bb.get(j)+ sent );

                b[j]+= sent ;
                var c = String.join("",b);
                var d ="";
            } 
        }
        System.out.println(String.join(" ",b));
        System.out.println(String.join(" ",bb));
        System.out.print("Ittmrn? se pttx  xioa x");
    }
}
