//import java.util.*;
//
//import javax.crypto.AEADBadTagException;
//
//import java.io.*;
//import java.math.*;
//class StackParenthesisCheck {
//      public static  void main(String args[]) {
//        String s= "()[][()]";
//        LinkedList<String> op = new LinkedList<>();
//        // []
//        // op
//
//        int[] result = new int[2];
//        boolean match=false;
//        for (int i=0;  i <  s.length() ; i++ ){
//            String current= ""+s.charAt(i);
//            if ("{[(".contains(current)){
//             op.push(""+s.charAt(i));
//
//            }else if ("}])".contains(current)){
//                var opening=  op.pop();
//                if(!( current.charAt(0)==  closing(opening.charAt(0)))){
//                    System.out.println(opening+current+i);
//                };
//            }
//        }
//
//    }
//
//    public static int closing(char c){
//        return  switch (c) {
//            case '[':
//                yield ']';
//            case '{':
//                yield '}';
//            case '(':
//                yield ')';
//
//            default:
//                System.out.println("KO");
//                yield -1;
//        };
//    }
//}