package two.pointer;

import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections_986 {
    /**
     * Definition for an interval.
     **/
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class Solution {
        public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
            if (A == null || A.length == 0 || B == null || B.length == 0) {
                return null;
            }

            List<Interval> result = new ArrayList<>();

            int i = 0;
            int j = 0;
            while (i < A.length && j < B.length) {
                Interval a = A[i];
                Interval b = B[j];

                int start = Math.max(a.start, b.start);
                int end = Math.min(a.end, b.end);

                if (start <= end) {
                    result.add(new Interval(start, end));
                }

                if (a.end == end) {
                    i++;
                }
                if (b.end == end) {
                    j++;
                }
            }

            return result.toArray(new Interval[0]);
        }
    }
}
