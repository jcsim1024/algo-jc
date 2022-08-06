package fold.leetcode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.text.*;

import javax.crypto.AEADBadTagException;
import javax.naming.spi.DirStateFactory.Result;

import java.io.*;
import java.math.*;
class ValidAnagram {
      public static  void main(String args[]) {
      
      int[] expected={0,1};
      int[] init = {1,4,5,7};
      // System.out.println(data);
      // System.out.println(invertTree(data));
      String a = "éA1112";
      //faire un mapping lettre nombre
      // comparer map
            var result = countOccurence(a).equals(countOccurence("ae2111"));
            
            System.out.println(result);


      }

      private static HashMap<Integer, Long> countOccurence(String wordRaw) {
            // other way
            // String.valueOf(c)
            Function< Integer,String> toStr= ( i) -> {
                  // var ch = (char)(i.intValue());
                  // var str = String.valueOf(ch);
                  var str = String.valueOf(i); 
                  return str;
            };
            var other = wordRaw.chars().boxed().map(String::valueOf).collect(Collectors.joining ());
            var word = unaccent(wordRaw)
                  .chars()
                  .map(Character::toLowerCase)
                  .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                  .toString();
            
            var result = new HashMap<Integer, Long>();
            word.chars()
            .distinct()
            .forEach(c-> {var count = word.chars().filter(cha-> cha ==c).count();
                  result.put(c, count);
            });
            System.out.println(result);
            return result;
      }
      public static String unaccent(String src) {
		return Normalizer
				.normalize(src, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}

}