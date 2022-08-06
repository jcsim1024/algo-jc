package fold.leetcode;

import java.util.*;

import javax.crypto.AEADBadTagException;
import javax.naming.spi.DirStateFactory.Result;

import java.io.*;
import java.math.*;
class MergesortedListNodes {
      public static  void main(String args[]) {
        Integer[] list1={2};
        Integer[] list2={1,4};
        Integer[] list3={3};
        // int[] result = new int[list1.length + list2.length] ;
        // LinkedList l1 = new LinkedList<>(Arrays.asList(list1));
        // LinkedList l2 = new LinkedList<>(Arrays.asList(list2));

        var it1 = Arrays.stream(list1).iterator();
        var it2 = Arrays.stream(list2).iterator();
        var it3 = Arrays.stream(list3).iterator();

        ArrayList<Integer> result= new ArrayList<>();
        var l1 = new ResIteTemp(result, list1)
          .chain(new ResIteTemp(result, list2))
          .chain(new ResIteTemp(result, list3)).root();
        // var l2 = new ResIteTemp(result, list2).setNext(l1);
        // var l3 = new ResIteTemp(result, list3).setNext(l2);
        l1.execute();
        for (int i =0  ; i< list1.length + list2.length + list3.length;i++){
            l1.execute();
            
            // if (temp1!=null && !(temp1 > temp2) && !(temp1> temp3)){
            //   result[i]=temp1;
            //   temp1 = assignTemp(it1);
            // }else if ( temp2!=null && !( temp2 > temp1) && !(temp2 >temp3) ) {
            //   result[i] =temp2;
            //   temp2 = assignTemp(it2);  
            // }else if (temp3!=null && !(temp3 > temp1) && !( temp3 >temp2)  ){
            //   result[i] =temp3;
            //   temp3 = assignTemp(it3);  
            // }
        }
        System.out.println(result);
    }
    public static Integer assignTemp(Iterator<Integer> iterator)
    {
        if( iterator.hasNext()){
            return iterator.next();
        }
          return  null;
    }

    static class ResIteTemp {
      ArrayList<Integer> result;
      Integer[] list;
      Iterator<Integer> it;
      Integer current;
      ResIteTemp next;
      ResIteTemp parent;
      ArrayList<ResIteTemp> otherArrays = new ArrayList<>();

      public ResIteTemp(ArrayList<Integer> result, Integer[] list) {
        this.otherArrays.add(this);
        this.result = result;
        this.list = list;
        it = Arrays.stream(list).iterator() ;
        current = assignTemp(it);
      }
      /**
       * fluent way
       * update current handler context 
       * then share current context with next handler (override it)
       * because the execution is in reverse order 
       * @param next
       * @return
       */
      ResIteTemp setNext (ResIteTemp nextel) {
        this.otherArrays.addAll(next.otherArrays);//appends next childrens to currents 
        nextel.parent =this;
        nextel.otherArrays = this.otherArrays;//share
        this.next= nextel;
        return this;
      }
      /**
       * this should return a builder class not current class
       * 
       * 
       * @param next
       * @return
       */
      ResIteTemp chain(ResIteTemp next) {
        this.otherArrays.addAll(next.otherArrays);
        next.otherArrays = this.otherArrays;//share
        next.parent = this;
        this.next= next;
        return next;
      }
      
      ResIteTemp root(){
        if (this.parent == null){
          return this;
        }else {
          return this.parent.root();
        }
      }

      boolean isMin( ){
        var min = otherArrays.stream().map(arr -> arr.current).filter(e-> e !=null ).min(Comparator.naturalOrder());
        return min.map(minInt -> minInt.equals(this.current)).orElse(false);
      }
      void moveOn(){
        result.add(current);
        current= assignTemp(it);
      }
      /**
       * should be ran on the root instance since the context is shared 
       */
      void execute(){
        if (isMin()){
          moveOn();
        }
        else if(next !=null){
          next.execute();
        }
      }
    }
}