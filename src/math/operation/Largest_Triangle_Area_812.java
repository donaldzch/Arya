package math.operation;

class Largest_Triangle_Area_812 {
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double result = 0;

            for (int[] i : points) {
                for (int[] j : points) {
                    for (int[] k : points) {
                        result = Math.max(result, i[0]*j[1] + j[0] * k[1] + k[0] * i[1] - i[0] * k[1] - j[0] * i[1] - k[0] * j[1]);
                    }
                }
            }

            return result / 2;
        }
    }
}