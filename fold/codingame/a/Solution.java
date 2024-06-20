package fold.codingame.a;

import java.io.PrintStream;
import java.util.HashMap;

class Solution {

    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");

        HashMap<Integer,Integer> nodes = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for (int i = 0; i < fromIds.length; i++) {
            nodes.put(fromIds[i], toIds[i]);
            count.put(fromIds[i], 0);
        }


        int next = startNodeId ;
        int lastid ;

        //
        do {

            count.put(next, 1);
            lastid = next;
            next = nodes.get(next);
            System.out.println(next);
        }
        while(count.get(next)!=null && count.get(next) <= 0);

        if(count.get(next)==null) lastid=next;

        return lastid;
    }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        int[] fromIds = new int[]{1,7,3,4,2,6,9};
        int[] toIds = new int[]{3,3,4,6,6,9,5};
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int endPointId = findNetworkEndpoint(2, fromIds, toIds);
        System.setOut(outStream);
        System.out.println(endPointId);
    }
    // #endregion
}