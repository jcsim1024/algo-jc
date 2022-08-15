package fold.codility.lessons08.leader;

import java.util.Stack;

public class Dominator {
    public int solution(int[] A) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
            } else {
                if (stack.peek() == A[i]) {
                    stack.push(A[i]);
                } else {
                    stack.pop();
                }
            }
        }
        //no candidate if stack is empty
        if (stack.isEmpty())
            return -1;
        int candidate = stack.peek();
        int count = 0;
        int candidateIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
                if (candidateIndex < 0) {
                    candidateIndex = i; //only store index of first occurence of candidate
                    // works for even and odd number of A elements
                    // e.g. if A.length = 4, count needs to be > 2
                    //e.g. if A.length = 5, count needs to be > 2
                    if (count > (A.length / 2))
                        return candidateIndex;

                }
            }
        }
        return -1; //no dominator found
    }
}
