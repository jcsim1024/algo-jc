package fold.codility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There are N points (numbered from 0 to N−1) on a plane. Each point is colored either red ('R') or green ('G'). The K-th point is located at coordinates (X[K], Y[K]) and its color is colors[K]. No point lies on coordinates (0, 0).
 *
 * We want to draw a circle centered on coordinates (0, 0), such that the number of red points and green points inside the circle is equal. What is the maximum number of points that can lie inside such a circle? Note that it is always possible to draw a circle with no points inside.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] X, int[] Y, String colors); }
 *
 * that, given two arrays of integers X, Y and a string colors, returns an integer specifying the maximum number of points inside a circle containing an equal number of red points and green points.
 */
public class JurrasicCerclesRayon {

    public static  void main(String args[]) {

        int[] x = {4, 0, 2, -2};
        int[] y ={4, 1, 2, -3};
        var colors= "RGRR";
        var sol = new JurrasicCerclesRayon().solution(x, y ,colors);
        System.out.println(sol);

        //X = [1, 1, −1, −1], Y = [1, −1, 1, −1] and colors = "RGRG", res 4

        //X = [1, 0, 0], Y = [0, 1, −1] and colors = "GGR", res 0

        //4. Given X = [5, −5, 5], Y = [1, −1, −3] and colors = "GRG", res 2
    }
    public int solution(int[] X, int[] Y, String colors)
        // write your code in Java SE 11
    {
        var maxPoint = 0;
        ArrayList<JurrasicCerclesRayon.Point> points = new ArrayList<Point>();
        for (int i = 0; i < X.length; i++) {
            points.add(new Point(X[i],Y[i],colors.charAt(i)));
        }
        var orderedRayon =points.stream().sorted(Comparator.comparing(Point::rayon).reversed()).collect(Collectors.toList());
        for (Point p :
                orderedRayon) {
            var green = green(p,orderedRayon);
            var red = red(p,orderedRayon);
             if(green == red ) {
                 maxPoint = (int) (green + red);
                 break;
             }
        };
        return maxPoint;
    }
    long green(Point cercle,List<Point> points) {
       return count( cercle,'G', points);
    }
    long red(Point cercle,List<Point> points) {
        return count( cercle,'R', points);
    }
    long count(Point cercle,char color, List<Point> points){
        return points.stream()
                .filter(point ->
                        cercle.rayon() >= point.rayon()
                                && point.color == color).count();
    }
    public class Point {
        double x;
        double y;
        char color;

        public Point(double x, double y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }


        double rayon(){
            return Math.sqrt((x*x) + (y*y));
        }
    }
}
