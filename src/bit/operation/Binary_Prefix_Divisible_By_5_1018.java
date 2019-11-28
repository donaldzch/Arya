package bit.operation;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();

        int num = 0;

        for (int i = 0; i < A.length; i++) {
            num = ((num << 1) + A[i]) % 5;
            result.add(num == 0);
        }

        return result;
    }
}