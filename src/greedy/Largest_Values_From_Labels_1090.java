package greedy;

import java.util.HashMap;

class Largest_Values_From_Labels_1090 {
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
            int result = 0;
            Map<Integer, Integer> labelMap = new HashMap<>();

            for (int label : labels) {
                labelMap.put(label, 0);
            }

            int size = values.length;
		    int[][] valueTolabel = new int[size][2];

            // creating a 2D array which has values and labels corresponding to the values
		    for (int i = 0; i < size; i++) {
                valueTolabel[i][0] = values[i];
                valueTolabel[i][1] = labels[i];
		    }

            // sorting the array in descending order based on the values from column 0
		    Arrays.sort(valueTolabel, new Comparator<int[]>() {
			    public int compare(final int[] entry1, final int[] entry2) {
                    if (entry1[0] < entry2[0]) {
                        return 1;
                    } else {
                        return -1;
                    }
			    }
            });
            
            int sum = 0;

		    for (int i = 0; i < size; i++) {
			    int value = valueTolabel[i][0];
			    int label = valueTolabel[i][1];
                // if label usage less than use_limit and subset size is less than num_wanted, include array item in the subset
			    if (num_wanted > 0 && labelMap.get(label) < use_limit) {
                    sum += val;
				    labelMap.put(label, labelMap.get(label) + 1);
				    num_wanted--;
			    }
		    }

		    return sum;
        }
    }
}