package fold.codility;
import java.util.*;

public class MinMissingPositiveIntegerInAnArray {
        public int solution(int[] A) {
            var x = 1;
            var sortedpositives = Arrays.stream(A).sorted().distinct().filter(value -> value>0).toArray();
            for (int i :
                    sortedpositives) {
                if (x == i) {
                    x+=1;
                } else {
                    break;
                }
            }
            return x;
    }
}
