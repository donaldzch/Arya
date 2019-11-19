package bit.operation;

class Complement_of_Base_10_Integer_1009 {
    class Solution {
        public int bitwiseComplement(int N) {
            if (N == 0) 
            return N;
            int X = N;

            X |= X >> 1;
            X |= X >> 2;

            X |= X >> 4;
            X |= X >> 8;

            X |= X >> 16;

            return N ^ X;
        }
    }
}