public class Solution {

    public static  void main(String args[]) {

        var sol = new Solution().solution(new int[]{ 4,3,2,5,1,1});
        System.out.println(sol);

    }
    public int solution(int[] A) {
        int min=A[0];
        int max=A[0];
        for (int i = 1; i < A.length; i++) {
            if (max<= A[i]){
                max= A[i];
            }
            if (min>= A[i]){
                min = A[i];
            }
        }
        return Math.abs(max-min);
    }

}
