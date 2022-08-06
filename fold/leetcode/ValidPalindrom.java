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
class ValidPalindrom {
      public static  void main(String args[]) {

      var fail ="race a car";
      String a = "A man, a plan, a canal: Panama";

      var result = isPal(a);
            // clean lower + replace all regex
            // for size /2 
            //compare i &&  size -i  i=0


            System.out.println(result);


      }

      private static boolean isPal(String wordRaw) {
            String lowered = wordRaw.chars().map(Character::toLowerCase).boxed().map((t) -> (char)t.intValue() )
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
            var reg = lowered.replaceAll("[\\W]", "");
            System.out.println("REG = " + reg);
            var clean = lowered.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(lowered);
            System.out.println(clean);

            for (int i = 0; i < clean.length()/2; i++) {
                  var I= clean.length()-i-1;
                  var begin = clean.charAt(i);
                  var end = clean.charAt(I);
                  System.out.println(begin+" + "+end);
                  if(begin != end){
                        return false;

                  }                  
            }
            return true;
      }

}